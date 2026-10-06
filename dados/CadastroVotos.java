package dados;

import java.util.ArrayList;

public class CadastroVotos {
    ArrayList<Voto> votos = new ArrayList<>();
    private CadastroCandidato cadastroCandidato;
    private CadastroLocalidades cadastroLocalidade;

    public CadastroVotos(CadastroCandidato cadastroCandidato, CadastroLocalidades cadastroLocalidade) {
        this.cadastroCandidato = cadastroCandidato;
        this.cadastroLocalidade = cadastroLocalidade;
    }

    public void cadastra(Voto voto){
         for (Voto v : votos) {
            if (v.getId() == voto.getId()) {
                System.out.println("ERRO - id repetido");
                return;
            }
        }
        if (voto.getHora() < 17 && voto.getHora() > 7) {
            System.out.println("ERRO - hora incorreta");
            return;
        }
        boolean candidatoValido = false;
        for (Presidente p : cadastroCandidato.getPresidentes()) {
            if (p.getNome().equals(voto.getCandidato())) {
                candidatoValido = true;
                break;
            }
        }
        for (Governador g : cadastroCandidato.getGovernadores()) {
            if (g.getNome().equals(voto.getCandidato())) {
                candidatoValido = true;
                break;
            }
        }
        if (!candidatoValido) {
            System.out.println("ERRO - candidato incorreto");
            return;
        }
        boolean localidadeValida = false;
        for (Localidade l : cadastroLocalidade.getLocalidades()) {
            if (l.getCep().equals(voto.getLocalidade())) {
                localidadeValida = true;
                break;
            }
        }
        if (!localidadeValida) {
            System.out.println("ERRO - localidade incorreta");
            return;
        }
        votos.add(voto);
    }

    public ArrayList<Voto> getVotos() {
        return votos;
    }
}
