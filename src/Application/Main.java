package Application;
import java.util.Locale;
import Entities.Categoria;
import Entities.Estoque;
import Entities.Produto;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Categoria jogos = new Categoria("Jogos");

        Produto GTA6 = new Produto("Grand Theft Auto 6", 550.00, jogos);
        Produto TheSims4 = new Produto("The Sims 4", 6000.00, jogos);

        Estoque estoque = new Estoque();

        estoque.adicionarProduto(GTA6, 6);
        estoque.adicionarProduto(TheSims4, 4);
        estoque.adicionarProduto(GTA6, 100);

        estoque.listarEstoque();

        estoque.removerProduto(GTA6, 6);
        estoque.listarEstoque();

    }
}
