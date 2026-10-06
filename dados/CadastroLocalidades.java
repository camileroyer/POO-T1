package dados;

import java.util.ArrayList;

public class CadastroLocalidades {
    ArrayList<Localidade> localidades = new ArrayList<>();

    public void cadastra(Localidade localidade){
        for (Localidade l : localidades) {
            if (l.getCep().equals(localidade.getCep())) {
                System.out.println("ERRO - localidade repetida");
                return;
            }
        }
        localidades.add(localidade);
    }

    public ArrayList<Localidade> getLocalidades() {
    return localidades;
}
    }
