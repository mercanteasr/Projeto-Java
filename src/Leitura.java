// Ricardo Augusto Scalada Mercante RA: a2865483

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

    public String entDados(String rotulo){
        System.out.print(rotulo);

        String ret = "";
        InputStreamReader tec = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(tec);

        try{
            ret = buffer.readLine();
        }
        catch(IOException ioe){
            System.out.println("\n ERRO DE ENTRADA DE DADOS");
        }

        return ret;
    }

}
