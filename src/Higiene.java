// Ricardo Augusto Scalada Mercante RA: a2865483

public class Higiene extends ItemFarmacia{
    private int unidadesPorPacote;
    private String publicoAlvo;

    // Construtor
    public Higiene() {
        unidadesPorPacote = 0;
        publicoAlvo = "";
    }
    // Getters e Setters
    public int getUnidadesPorPacote() {
        return unidadesPorPacote;
    }

    public void setUnidadesPorPacote(int unidadesPorPacote) {
        this.unidadesPorPacote = unidadesPorPacote;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }
    //Sobrescrita
    public String toString() {
        return super.toString() + " | Unidades por Pacote: "+unidadesPorPacote+" | Publico Alvo: "+publicoAlvo;
    }
}
