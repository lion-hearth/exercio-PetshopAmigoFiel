import java.util.Scanner;

public class PetshopApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Produto[] produtos = new Produto[3];
        produtos[0] = new Produto("Ração", "Alimento", 20.0, 50);
        produtos[1] = new Produto("Coleira", "Acessório", 15.0, 30);
        produtos[2] = new Produto("Shampoo", "Higiene", 10.0, 40);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Agendar serviço");
            System.out.println("2. Vender Produtos");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            if (opcao == 1) {
                // Código para agendar serviços (já existente)
            } else if (opcao == 2) {
                realizarVenda(produtos);
            } else if (opcao == 3) {
                System.out.println("Saindo do sistema.");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void realizarVenda(Produto[] produtos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lista de Produtos Disponíveis:");
        for (int i = 0; i < produtos.length; i++) {
            System.out.println((i + 1) + ". " + produtos[i].getNome() + " - Preço: R$" + produtos[i].getPreco() + " - Estoque: " + produtos[i].getQuantidadeEstoque());
        }

        System.out.print("Escolha o número do produto que deseja vender: ");
        int escolhaProduto = scanner.nextInt();

        if (escolhaProduto > 0 && escolhaProduto <= produtos.length) {
            Produto produtoSelecionado = produtos[escolhaProduto - 1];

            System.out.print("Quantidade desejada: ");
            int quantidadeDesejada = scanner.nextInt();

            if (quantidadeDesejada <= produtoSelecionado.getQuantidadeEstoque()) {
                produtoSelecionado.vender(quantidadeDesejada);
                System.out.println("Venda realizada com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente em estoque. Venda cancelada.");
            }
        } else {
            System.out.println("Opção inválida. Venda cancelada.");
        }
    }
}
