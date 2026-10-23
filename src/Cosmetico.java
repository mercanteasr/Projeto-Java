// Ricardo Augusto Scalada Mercante RA: a2865483

public class Cosmetico extends ItemFarmacia{
    private String tipoPele;
    private String fragrancia;

    // Construtor
    public Cosmetico(){
        fragrancia = "";
        tipoPele = "";
    }
    // Getters e Setters
    public String getTipoPele() {
        return tipoPele;
    }

    public void setTipoPele(String tipoPele) {
        this.tipoPele = tipoPele;
    }

    public String getFragrancia() {
        return fragrancia;
    }

    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }
    //Sobrescrita
    public String toString() {
        return super.toString() + " | Tipo pele: "+tipoPele+" | Fragrancia: "+fragrancia;
    }
}
