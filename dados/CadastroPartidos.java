package dados;

import java.util.ArrayList;

public class CadastroPartidos {
     ArrayList<Partido> partidos = new ArrayList<>();

     public void cadastra(Partido partido){
        for (Partido p : partidos) {
            if (p.getCodigo() == partido.getCodigo()) {
                System.out.println("ERRO - partido repetido");
                return;
            }
        }
        partidos.add(partido);
    }

    public ArrayList<Partido> getPartidos() { return partidos; }
}
