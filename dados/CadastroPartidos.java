package dados;

import java.util.ArrayList;

public class CadastroPartidos {
     ArrayList<Partido> partidos = new ArrayList<>();

     public void cadastra(Partido partido){
        for (Partido p : partidos) {
            if (p.getCodigo() == partido.getCodigo()) {
                return;
            }
        }
        partidos.add(partido);
    }

    public Partido busca(int codigo) {
        for (Partido p : partidos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }

    public ArrayList<Partido> getPartidos() { return partidos; }
}
