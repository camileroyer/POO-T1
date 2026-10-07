package dados;

import java.util.ArrayList;

public class CadastroVotos {
    ArrayList<Voto> votos = new ArrayList<>();

    public void cadastra(Voto voto){ votos.add(voto); }

    public boolean existeId(int id) {
        for (Voto v : votos) { 
            if (v.getId() == id) {
                return true; } }
        return false;
    }

    public int contaVotos(Candidato candidato) {
        int quantidade = 0;
        for (Voto v : votos) {
            if (v.getCandidato().getNumero() == candidato.getNumero()) {
                quantidade++; }
        }
        return quantidade;
    }

    public int ultimoVoto(Candidato candidato) {
        int ultimo = -1;
        for (Voto v : votos) {
            if (v.getCandidato().getNumero() == candidato.getNumero() && v.getHora() > ultimo) {
                ultimo = v.getHora(); }
        }
        return ultimo;
    }

    public int contaVotos(Partido partido) {
        int quantidade = 0;
        for (Voto v : votos) {
            if (v.getCandidato().getPartido().getCodigo() == partido.getCodigo()) {
                quantidade++; }
        }
        return quantidade;
    }

    public ArrayList<Voto> getVotos() { return votos; }
}
