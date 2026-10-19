// Ricardo Augusto Scalada Mercante RA: a2865483

public class Remedio extends ItemFarmacia{
    private String principioAtivo;
    private String dosagem;

    //Construtor
    public Remedio(){
        principioAtivo = "";
        dosagem = "";
    }
    // Getters e Setters
    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }
    // Sobrescrita
    public String toString(){
        return super.toString() + " | Principio Ativo: "+principioAtivo+" | Dosagem: "+dosagem;
    }
}
