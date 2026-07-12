package entities;

public class Produto {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private Categoria categoria;
    private Fornecedor fornecedor;

    // CONSTRUTORES
    public Produto() {}
    public Produto(Integer id, String nome, Double preco, Integer quantidade, Categoria categoria, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public Integer getId() {
        return id;
    }
    public Double getPreco() {
        return preco;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // MÉTODOS
    @Override
    public String toString() {
        return "ID: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Preço: R$ " + String.format("%.2f", getPreco()) + "\n" +
                "Quantidade: " + getQuantidade() + "\n" +
                "Categoria: " +  getCategoria() + "\n" +
                "Fornecedor: " + getFornecedor() + "\n";
    }
}
