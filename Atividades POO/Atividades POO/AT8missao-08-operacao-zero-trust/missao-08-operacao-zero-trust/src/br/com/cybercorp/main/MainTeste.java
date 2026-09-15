package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.Veiculo;
import br.com.cybercorp.service.SistemaSeguranca;

public class MainTeste {
    public static void main(String[] args) {
        Departamento departamento = new Departamento(
                "SEG",
                "Segurança da Informação",
                3
        );

        Funcionario funcionario = new Funcionario(
                "FC-001",
                "João",
                departamento
        );

        Veiculo veiculo = new Veiculo(
                "ABC-1234",
                "Honda Civic",
                funcionario
        );

        SistemaSeguranca sistema = new SistemaSeguranca(2);

        Credencial c1 = new Credencial("FFF-999", true, funcionario);
        Credencial clone = new Credencial("FFF-999", true, funcionario);

        sistema.registrarCatraca(funcionario);
        sistema.registrarCatraca(funcionario);

        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        sistema.estacionarVeiculo(veiculo, 0);
        sistema.estacionarVeiculo(veiculo, 5);
    }
}
