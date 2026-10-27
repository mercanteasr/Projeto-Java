// Ricardo Augusto Scalada Mercante RA: a2865483

public class ItemFarmacia {
    private String nome;
    private String marca;
    private double preco;
    private int qtdEstoque;

    // Construtor
    public ItemFarmacia() {
        nome = "";
        marca = "";
        preco = 0;
        qtdEstoque = 0;
    }
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    //Sobrescrita
    public String toString(){
        return "Nome: "+nome+"\n | Marca: "+marca+"\n | Preço: "+preco+"\n | Quantidade Estoque: "+qtdEstoque;
    }
}
