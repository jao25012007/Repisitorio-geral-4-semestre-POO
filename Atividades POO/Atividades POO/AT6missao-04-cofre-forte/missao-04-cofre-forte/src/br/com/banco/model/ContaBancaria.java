package br.com.banco.model;

public class ContaBancaria {
    private final String numeroConta;
    private double saldo;
    private final Cliente titular;

    public ContaBancaria(String numeroConta, Cliente titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("O saldo inicial nao pode ser negativo.");
        }

        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
        Agencia.registrarNovaConta();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        double valorTotal = valor + Agencia.TAXA_SAQUE;

        if (valor > 0 && saldo >= valorTotal) {
            saldo -= valorTotal;
            return true;
        }

        return false;
    }
}
