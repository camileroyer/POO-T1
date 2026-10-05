package dados;

import java.util.ArrayList;

public class CadastroPresidente{
    ArrayList<Presidente> presidentes = new ArrayList<>();

    public void cadastra(Presidente presidente){
        for (Presidente p : presidentes) {
            if (p.getNome() == presidente.getNome()) {
                System.out.println("ERRO - presidente repetido");
                return;
            }
        }
        presidentes.add(presidente);
    }
}