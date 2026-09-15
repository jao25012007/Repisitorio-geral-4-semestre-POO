package br.com.fronteira.main;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class App {
    public static void main(String[] args) {
        String encryptedB64 =
                "U2FsdGVkX1/Jz86x4/Ydu3FZFw5pSo86xHG1MwpCFX/"
                + "Dnn9uCMDd3xLNn61XZouvQy6G2FIhyQXAQwvTWn3/"
                + "01JGIoIh5RN4NXgs+kdpcf6afHmSMvCZu0EiiiXlVpB2"
                + "EQGIKDLIAU9c1aQx6bzEgQ==";

        encryptedB64 = encryptedB64.replaceAll("\\s", "");

        byte[] dadosCriptografados = Base64.getDecoder().decode(encryptedB64);
        byte[] salt = Arrays.copyOfRange(dadosCriptografados, 8, 16);
        byte[] textoCifrado = Arrays.copyOfRange(
                dadosCriptografados,
                16,
                dadosCriptografados.length
        );

        String charset = "abcdefghijklmnopqrstuvwxyz0123456789";
        Pattern padraoLink = Pattern.compile(
                "https?://[A-Za-z0-9./?=_&%-]+"
        );

        System.out.println(
                "Iniciando ataque de força bruta no link da NexusTech..."
        );

        long inicio = System.currentTimeMillis();

        for (char c1 : charset.toCharArray()) {
            for (char c2 : charset.toCharArray()) {
                String senhaTestada = "jav" + c1 + c2;

                try {
                    PBEKeySpec especificacao = new PBEKeySpec(
                            senhaTestada.toCharArray(),
                            salt,
                            1000,
                            384
                    );

                    SecretKeyFactory fabrica = SecretKeyFactory.getInstance(
                            "PBKDF2WithHmacSHA256"
                    );

                    byte[] chaveEIv = fabrica.generateSecret(
                            especificacao
                    ).getEncoded();

                    byte[] chave = Arrays.copyOfRange(chaveEIv, 0, 32);
                    byte[] iv = Arrays.copyOfRange(chaveEIv, 32, 48);

                    Cipher cipher = Cipher.getInstance(
                            "AES/CBC/PKCS5Padding"
                    );

                    cipher.init(
                            Cipher.DECRYPT_MODE,
                            new SecretKeySpec(chave, "AES"),
                            new IvParameterSpec(iv)
                    );

                    byte[] parteDecifrada = cipher.update(textoCifrado);

                    try {
                        byte[] parteFinal = cipher.doFinal();
                        parteDecifrada = juntar(parteDecifrada, parteFinal);
                    } catch (Exception erroDePadding) {
                        // A lista fornecida possui um ultimo bloco inconsistente.
                    }

                    String resultado = new String(
                            parteDecifrada,
                            StandardCharsets.UTF_8
                    );

                    Matcher localizador = padraoLink.matcher(resultado);

                    if (localizador.find()) {
                        long fim = System.currentTimeMillis();

                        System.out.println(
                                "\nSUCESSO! A criptografia foi quebrada!"
                        );
                        System.out.println("Senha encontrada: " + senhaTestada);
                        System.out.println(
                                "Link revelado: " + localizador.group()
                        );
                        System.out.println(
                                "Tempo de execução: " + (fim - inicio) + "ms"
                        );
                        return;
                    }
                } catch (Exception erro) {
                    // Uma senha incorreta faz o loop testar a proxima.
                }
            }
        }

        System.out.println(
                "\nForça bruta concluída. Senha não encontrada."
        );
    }

    private static byte[] juntar(byte[] primeiraParte, byte[] segundaParte) {
        byte[] resultado = new byte[
                primeiraParte.length + segundaParte.length
        ];

        System.arraycopy(
                primeiraParte,
                0,
                resultado,
                0,
                primeiraParte.length
        );

        System.arraycopy(
                segundaParte,
                0,
                resultado,
                primeiraParte.length,
                segundaParte.length
        );

        return resultado;
    }
}
