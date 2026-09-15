package br.com.ecommerce.main;

import br.com.ecommerce.exception.TipoFreteInvalidoException;
import br.com.ecommerce.model.CalculadoraFrete;
import br.com.ecommerce.model.FreteMotoboy;
import br.com.ecommerce.model.FretePac;
import br.com.ecommerce.model.FreteSedex;

public class MainTeste {
    public static void main(String[] args) {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        double valorPedido = 100.00;

        try {
            double valorSedex = calculadora.processarFrete(
                    valorPedido,
                    new FreteSedex()
            );

            double valorPac = calculadora.processarFrete(
                    valorPedido,
                    new FretePac()
            );

            double valorMotoboy = calculadora.processarFrete(
                    valorPedido,
                    new FreteMotoboy()
            );

            System.out.printf("Frete SEDEX: R$ %.2f%n", valorSedex);
            System.out.printf("Frete PAC: R$ %.2f%n", valorPac);
            System.out.printf("Frete Motoboy: R$ %.2f%n", valorMotoboy);

            calculadora.processarFrete(valorPedido, null);
        } catch (TipoFreteInvalidoException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
