package br.com.ecommerce.model;

import br.com.ecommerce.exception.TipoFreteInvalidoException;

public class CalculadoraFrete {
    public double processarFrete(double valorPedido,
                                 EstrategiaFrete estrategiaFrete) {
        if (estrategiaFrete == null) {
            throw new TipoFreteInvalidoException(
                    "Erro: tipo de frete invalido."
            );
        }

        return estrategiaFrete.calcular(valorPedido);
    }
}
