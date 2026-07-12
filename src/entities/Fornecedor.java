package entities;

public class Fornecedor {
    // ATRIBUTOS
    private String nome;

    // CONSTRUTORES
    public Fornecedor(){}
    public Fornecedor(String nome){this.nome = nome;}

    // GET E SET
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // MÉTODOS
    @Override
    public String toString() {
        return getNome();
    }
}
