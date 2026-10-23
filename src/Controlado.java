// Ricardo Augusto Scalada Mercante RA: a2865483

public class Controlado extends Remedio{
    private String tarja;
    private boolean receitaApresentada;

    // Construtor
    public Controlado(){
        tarja = "";
        receitaApresentada = false;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public boolean isReceitaApresentada() {
        return receitaApresentada;
    }

    public void setReceitaApresentada(boolean receitaApresentada) {
        this.receitaApresentada = receitaApresentada;
    }
    //Sobrescrita


    @Override
    public String toString() {
        return super.toString() + " | Tarja: "+ tarja;
    }
}
