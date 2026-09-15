package br.com.technexus.security;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class ForcaBruta {
    private static final String LINK_CIFRADO =
            "U2FsdGVkX189CvKETNa+k2wHIMpbCwNk7HKB3nBRzOD9bBaP"
            + "t2nFMCdElvKoRfTmmqVv41Trh37ORXFWRVNOX3vpgPHULkka"
            + "oyh9DfmzrGBXkGnu/SJfQkGuU08zbgMQNSwCGTwoIHkUMzR"
            + "FQELN0Q==";

    private static final String CARACTERES =
            "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        byte[] dados = Base64.getDecoder().decode(LINK_CIFRADO);
        byte[] salt = Arrays.copyOfRange(dados, 8, 16);
        byte[] textoCifrado = Arrays.copyOfRange(dados, 16, dados.length);

        System.out.println("Iniciando força bruta...");
        long inicio = System.currentTimeMillis();

        try {
            SecretKeyFactory fabrica = SecretKeyFactory.getInstance(
                    "PBKDF2WithHmacSHA256"
            );

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            for (char primeiro : CARACTERES.toCharArray()) {
                for (char segundo : CARACTERES.toCharArray()) {
                    for (char terceiro : CARACTERES.toCharArray()) {
                        String senha = "lam" + primeiro + segundo + terceiro;

                        String resultado = tentarDescriptografar(
                                senha,
                                salt,
                                textoCifrado,
                                fabrica,
                                cipher
                        );

                        if (resultado != null && resultado.contains("http")) {
                            long fim = System.currentTimeMillis();

                            System.out.println("Senha encontrada: " + senha);
                            System.out.println("URL secreta: " + resultado.trim());
                            System.out.println(
                                    "Tempo de execução: "
                                            + (fim - inicio) + "ms"
                            );
                            return;
                        }
                    }
                }
            }

            System.out.println(
                    "Busca concluída. Os dados cifrados não correspondem "
                            + "ao padrão de senha informado."
            );
        } catch (Exception erro) {
            System.out.println("Erro ao preparar a criptografia: "
                    + erro.getMessage());
        }
    }

    private static String tentarDescriptografar(
            String senha,
            byte[] salt,
            byte[] textoCifrado,
            SecretKeyFactory fabrica,
            Cipher cipher) {
        try {
            PBEKeySpec especificacao = new PBEKeySpec(
                    senha.toCharArray(),
                    salt,
                    1000,
                    384
            );

            byte[] chaveEIv = fabrica.generateSecret(
                    especificacao
            ).getEncoded();

            byte[] chave = Arrays.copyOfRange(chaveEIv, 0, 32);
            byte[] iv = Arrays.copyOfRange(chaveEIv, 32, 48);

            cipher.init(
                    Cipher.DECRYPT_MODE,
                    new SecretKeySpec(chave, "AES"),
                    new IvParameterSpec(iv)
            );

            byte[] resultado = cipher.doFinal(textoCifrado);
            return new String(resultado, StandardCharsets.UTF_8);
        } catch (Exception senhaIncorreta) {
            return null;
        }
    }
}
