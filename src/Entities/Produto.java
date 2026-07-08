package Entities;
import java.util.Objects;

public class Produto {
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(String nome, double preco, Categoria categoria){
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nome);
    }
}
