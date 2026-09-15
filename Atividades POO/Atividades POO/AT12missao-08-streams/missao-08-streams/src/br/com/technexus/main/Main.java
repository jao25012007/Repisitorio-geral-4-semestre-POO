package br.com.technexus.main;

import br.com.technexus.model.Loja;
import br.com.technexus.model.Produto;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        loja.cadastrar(new Produto("The Witcher", "GAMES", 150.00));
        loja.cadastrar(new Produto("FIFA", "GAMES", 200.00));
        loja.cadastrar(new Produto("Java for Dummies", "LIVROS", 100.00));
        loja.cadastrar(new Produto("Clean Code", "LIVROS", 80.00));
        loja.cadastrar(new Produto("Mouse", "HARDWARE", 50.00));

        System.out.println("Produtos da categoria GAMES:");
        loja.buscarPorCategoria("GAMES")
                .forEach(produto -> System.out.println(produto));

        System.out.printf(
                "%nPatrimônio total: R$ %.2f%n",
                loja.calcularPatrimonioTotal()
        );

        System.out.printf(
                "Total da categoria LIVROS: R$ %.2f%n",
                loja.calcularTotalPorCategoria("LIVROS")
        );
    }
}
