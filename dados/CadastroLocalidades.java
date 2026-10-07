package dados;

import java.util.ArrayList;

public class CadastroLocalidades {
    ArrayList<Localidade> localidades = new ArrayList<>();

    public void cadastra(Localidade localidade){
        for (Localidade l : localidades) {
            if (l.getCep().equals(localidade.getCep())) {
                return;
            }
        }
        localidades.add(localidade);
    }

    public Localidade busca(String cep) {
        for (Localidade l : localidades) {
            if (l.getCep().equals(cep)) return l;
        }
        return null;
    }

    public ArrayList<Localidade> getLocalidades() { return localidades; }
}
