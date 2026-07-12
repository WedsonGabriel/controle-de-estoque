package entities;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Estoque {
    // ATRIBUTOS
    private Map<Integer, Produto> estoqueProdutos = new HashMap<>();
    private Integer proximoId = 1;

    // MÉTODOS
    public void cadastrarProduto(String nome, Double preco, Integer quantidade, Categoria categoria, Fornecedor fornecedor) {
        Produto novoProduto = new Produto(proximoId, nome, preco, quantidade, categoria, fornecedor);
        estoqueProdutos.put(proximoId, novoProduto);
        System.out.println("Produto cadastrado com sucesso! ID = " + proximoId);
        proximoId++;
    }

    public void removerProduto(Integer id) {
        if (estoqueProdutos.containsKey(id)) {
            estoqueProdutos.remove(id);
            System.out.println("Produto do ID" + id + " removido com sucesso!");
        } else {
            System.out.println("Não há nenhum produto cadastrado no ID " + id);
        }
    }

    public void removerQuantidade(Integer id, int valor) {
        Produto produto = estoqueProdutos.get(id);

        if (produto != null) {
            int quantidadeAtual = produto.getQuantidade();
            if (quantidadeAtual >= valor) {
                int novaQuantidade = quantidadeAtual - valor;
                produto.setQuantidade(novaQuantidade);
                System.out.println("Saída de " + valor + " unidades de " + produto.getNome() + " registrada");
                System.out.println("O estoque atual de " + produto.getNome() + " é de " + novaQuantidade + "unidades" + "\n");
            } else {
                System.out.println("Erro: Você tentou vender " + valor + " unidades de " + produto.getNome() +  ", mas só existem " + quantidadeAtual + " unidades desse produto disponíveis no estoque atualmente." + "\n");
            }
        } else {
            System.out.println("Erro: Produto de ID " + id + " não localizado no estoque");
        }
    }

    public void adicionarQuantidade(Integer id, int valor) {
        Produto produto = estoqueProdutos.get(id);

        if (produto != null) {
            int novaQuantidade = produto.getQuantidade() + valor;
            produto.setQuantidade(novaQuantidade);
            System.out.println("Entrada de " + valor + " unidades de " + produto.getNome() + " registrada");
            System.out.println("O estoque atual de " + produto.getNome() + " é de " + novaQuantidade + "unidades" + "\n");
        } else {
            System.out.println("Erro: Produto de ID " + id + " não localizado no estoque" + "\n");
        }
    }

    public void listarProdutos() {
        if (estoqueProdutos.isEmpty()) {
            System.out.println("O estoque está vazio");
            return;
        }
        for (Produto ID : estoqueProdutos.values()) {
            System.out.println(ID);
        }
    }

    public void buscarId(Integer id) {
        Produto produto = estoqueProdutos.get(id);

        if (produto != null) {
            System.out.println(produto);
        }
        else {
            System.out.println("Não há nenhum produto cadastrado no ID " + id);
        }
    }

    public void editar(Integer id) {
        Scanner sc = new Scanner(System.in);

        Produto produto = estoqueProdutos.get(id);

        if (produto != null) {
            System.out.println("O que você deseja editar no produto? ");
            System.out.println("N - Nome | P - Preço | Q - Quantidade | F - Fornecedor");

            char acao = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            switch (acao) {
                case 'N':
                    System.out.print("Informe o novo nome: ");
                    produto.setNome(sc.nextLine());
                    break;
                case 'P':
                    System.out.print("Informe o novo preço: ");
                    produto.setPreco(sc.nextDouble());
                    break;
                case 'Q':
                    System.out.print("Informe a nova quantidade: ");
                    produto.setQuantidade(sc.nextInt());
                    break;
                case 'F':
                    System.out.print("Informe o novo fornecedor: ");
                    String novoFornecedor = sc.nextLine();
                    Fornecedor fornecedorEdit = new Fornecedor(novoFornecedor);
                    produto.setFornecedor(fornecedorEdit);
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } else {
            System.out.println("Erro: O ID" + id + " não foi encontrado no estoque!");
        }


    }

    public void venderAbastecer(Integer id) {
        Scanner sc = new Scanner(System.in);

        Produto produto = estoqueProdutos.get(id);

        if (produto != null) {
            System.out.println("O que você deseja realizar? ");
            System.out.println("V - Vender | A - Abastecer");

            char acao = sc.next().toUpperCase().charAt(0);

            switch (acao) {
                case 'V':
                    System.out.print("Quantas unidades serão vendidas? ");
                    removerQuantidade(id, sc.nextInt());
                    break;
                case 'A':
                    System.out.print("Quantas unidades serão adicionadas? ");
                    adicionarQuantidade(id, sc.nextInt());
                    break;
                default:
                    break;
            }
        }
    }
}
