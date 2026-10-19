// Ricardo Augusto Scalada Mercante RA: a2865483

public class AparelhoMedico extends ItemFarmacia{
    private String voltagem;
    private int garantiaMeses;

    // Construtor
    public AparelhoMedico (){
        voltagem = "";
        garantiaMeses = 0;
    }
    // Getterrs e Setters
    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
    // Sobrescrita
    public String toString(){
        return super.toString() + " | Voltagem: "+voltagem+" | Garantia Meses: "+garantiaMeses;
    }
}
