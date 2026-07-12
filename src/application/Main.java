package application;
import java.util.Locale;
import java.util.Scanner;
import entities.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Estoque estoque = new Estoque();
        GerenciadorCategoria gerCategoria = new GerenciadorCategoria();
        boolean rodando = true;

        while (rodando) {
            System.out.println("---- MENU PRINCIPAL ----");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Editar");
            System.out.println("4 - Listar");
            System.out.println("5 - Vender/Abastecer");
            System.out.println("6 - Pesquisar produto");
            System.out.println("7 - Sair");

            System.out.println();
            System.out.print("Qual ação você deseja realizar? ");
            int acao = sc.nextInt();
            System.out.println();
            sc.nextLine();

            switch (acao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    Double preco = sc.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Categoria: ");
                    String nomeCategoria = sc.nextLine();
                    Categoria categoria = gerCategoria.obterOuCriar(nomeCategoria);

                    System.out.print("Fornecedor: ");
                    String nomeFornecedor = sc.nextLine();
                    Fornecedor fornecedor = new Fornecedor(nomeFornecedor);

                    estoque.cadastrarProduto(nome, preco, quantidade, categoria, fornecedor);
                    break;

                case 2:
                    System.out.print("Informe o ID do produto que você deseja excluir: ");
                    int id = sc.nextInt();
                    estoque.removerProduto(id);
                    break;

                case 3:
                    System.out.print("Informe o ID do produto que você deseja editar: ");
                    id = sc.nextInt();
                    estoque.editar(id);
                    break;

                case 4:
                    estoque.listarProdutos();
                    break;

                case 5:
                    System.out.print("Informe o ID do produto que você deseja fazer a operação: ");
                    id = sc.nextInt();
                    estoque.venderAbastecer(id);
                    break;

                case 6:
                    System.out.print("Informe o ID do produto que você deseja verificar: ");
                    id = sc.nextInt();
                    estoque.buscarId(id);
                    break;

                case 7:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}