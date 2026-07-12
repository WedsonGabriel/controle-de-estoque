package entities;
import java.util.HashSet;
import java.util.Set;

public class GerenciadorCategoria {
    private Set<Categoria> categorias = new HashSet<>();
    private int proximoId = 1;

    public Categoria obterOuCriar(String nome) {
        Categoria tentativa = new Categoria(0, nome);

        for (Categoria c : categorias) {
            if (c.equals(tentativa)) {
                return c;
            }
        }

        Categoria nova = new Categoria(proximoId++, nome);
        categorias.add(nova);
        return nova;
    }
}