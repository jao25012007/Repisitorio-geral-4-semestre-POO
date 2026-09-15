package br.com.banco.main;

import br.com.banco.model.Agencia;
import br.com.banco.model.Cliente;
import br.com.banco.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) {
        Cliente primeiroCliente = new Cliente(
                "123.456.789-00",
                "Joao",
                "joao@email.com"
        );

        Cliente segundoCliente = new Cliente(
                "123.456.789-00",
                "Maria",
                "maria@email.com"
        );

        if (primeiroCliente.equals(segundoCliente)) {
            System.out.println("Os clientes sao iguais.");
        }

        ContaBancaria conta = new ContaBancaria(
                "0001",
                primeiroCliente,
                50.0
        );

        boolean saqueRealizado = conta.sacar(50.0);

        System.out.println("Saque realizado: " + saqueRealizado);
        System.out.println("Saldo atual: R$ " + conta.getSaldo());
        System.out.println("Total de contas abertas: "
                + Agencia.getTotalContasAbertas());
        System.out.println(conta.getTitular());
    }
}
