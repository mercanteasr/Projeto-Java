// Ricardo Augusto Scalada Mercante RA: a2865483

public class EstoqueInsuficienteException extends Exception{

    public EstoqueInsuficienteException(){
        super("Erro: Estoque insuficiente para este item.");
    }

}
