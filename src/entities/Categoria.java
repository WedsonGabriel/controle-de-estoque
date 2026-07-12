package entities;
import java.util.Objects;

public class Categoria {
    // ATRIBUTOS
    private Integer id;
    private String nome;

    // CONSTRUTORES
    public Categoria(){}
    public Categoria(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    // GET E SET
    public Integer getId() {
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    // MÉTODOS
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return getNome();
    }
}
