package Entities;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {
    private Map<Produto, Integer> produtosNoEstoque = new HashMap<>();

    public void adicionarProduto(Produto produto, int quantidade){
        int quantidadeAtual = produtosNoEstoque.getOrDefault(produto, 0);
        produtosNoEstoque.put(produto, quantidadeAtual + quantidade);
        System.out.println(quantidade + " unidades de '" + produto.getNome() + "' adicionadas no estoque.");
    }

    public void removerProduto(Produto produto, int quantidade){
        if (produtosNoEstoque.containsKey(produto)) {
            int quantidadeAtual = produtosNoEstoque.get(produto);

            if (quantidadeAtual >= quantidade){
                produtosNoEstoque.put(produto, quantidadeAtual - quantidade);
                System.out.println(quantidade + "unidades de '" + produto.getNome() + "' vendidas.");
            } else {
                System.out.println("Erro: Estoque insuficiente de '" + produto.getNome() + "' para a venda, Disponível: " + quantidadeAtual);
            }
        } else{
            System.out.println("Erro: Produto não encontrado no estoque.");
        }
    }

    public void listarEstoque(){
        System.out.println("\n === RELATÓRIO DE ESTOQUE ===");
        if (produtosNoEstoque.isEmpty()){
            System.out.println("O estoque está vazio.");
            return;
        }

        for (Map.Entry<Produto, Integer> registro : produtosNoEstoque.entrySet()) {
            Produto p = registro.getKey();
            Integer quantidade = registro.getValue();
            System.out.println("- " + p.getNome() + " (" + p.getCategoria().getNome() + ") | Qtd: " + quantidade + " | R$ " + p.getPreco());
        }
    }
 }
