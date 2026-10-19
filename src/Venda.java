// Ricardo Augusto Scalada Mercante RA: a2865483

public class Venda implements Calculo{
    private Cliente cliente;
    private ItemFarmacia item;
    private int quantidade;

    // getters e setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFarmacia getItem() {
        return item;
    }

    public void setItem(ItemFarmacia item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    //=====================

    public double calcTotal() {
        return getItem().getPreco() * getQuantidade(); //Reflexividade
    }
    //Sobrecarga
    public double calcTotal(double desc){
        return  calcTotal() - ((calcTotal() * desc) / 100);
    }
}
