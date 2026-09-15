package br.com.cybercorp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.Veiculo;

public class SistemaSeguranca {
    private Veiculo[] vagasGaragem;
    private List<Funcionario> catracaPrincipal = new ArrayList<>();
    private Set<Credencial> cofreFisico = new HashSet<>();

    public SistemaSeguranca(int totalVagas) {
        vagasGaragem = new Veiculo[totalVagas];
    }

    public void estacionarVeiculo(Veiculo veiculo, int vaga) {
        vagasGaragem[vaga] = veiculo;
        System.out.println("Garagem: Veículo " + veiculo.getPlaca()
                + " estacionado na vaga " + vaga);
    }

    public void registrarCatraca(Funcionario funcionario) {
        catracaPrincipal.add(funcionario);
        System.out.println("Catraca: Acesso liberado para "
                + funcionario.getNome());
    }

    public void acessarCofre(Credencial credencial) {
        boolean acessoConcedido = cofreFisico.add(credencial);

        if (acessoConcedido) {
            System.out.println("Cofre: Acesso CONCEDIDO. Bem-vindo(a) "
                    + credencial.getTitular().getNome());
        } else {
            System.out.println("ALERTA MÁXIMO: Credencial "
                    + credencial.getCodigoHex()
                    + " bloqueada! Tentativa de clonagem detectada.");
        }
    }
}
