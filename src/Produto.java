// criado classe para referenciar depois
public class Produto {

    private String nome; // classe string para armazenar o nome
    private String categoria; // classe string para armazenar a categoria
    private double preco; // classe double para armazenar o preço, já que preço é fracionado e classe double é usada para números fracionados
    private int quantidadeEstoque;  // classe quantidade de estoque do int que armazena números

    // Construção

    public Produto(String nome, String categoria, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;

    }
    // Método para vender um produto

    public void vender(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente em estoque");
        }
    }

}

