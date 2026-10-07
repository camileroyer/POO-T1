package dados;

import java.util.ArrayList;

public class CadastroCandidato{
    ArrayList<Presidente> presidentes = new ArrayList<>();
    ArrayList<Governador> governadores = new ArrayList<>();

    public void cadastraPresidente(Presidente presidente) {
        presidentes.add(presidente);
    }

    public void cadastraGovernador(Governador governador){
        governadores.add(governador);
    }

    public boolean existeNumero(int numero) {
        for (Presidente p : presidentes) if (p.getNumero() == numero) return true;
        for (Governador g : governadores) if (g.getNumero() == numero) return true;
        return false;
    }

    public Candidato busca(int numero) {
        for (Presidente p : presidentes) if (p.getNumero() == numero) return p;
        for (Governador g : governadores) if (g.getNumero() == numero) return g;
        return null;
    }

    public void consultaCandidato(int numero) {
        Candidato candidato = busca(numero);
        if (candidato == null) System.out.println("6: ERRO - candidato inexistente.");
        else System.out.println("6: " + candidato.getDescricao());
    }

    public void consultaCandidatosPartido(int codigoPartido) {
        boolean encontrou = false;
        for (Presidente p : presidentes) {
            if (p.getPartido().getCodigo() == codigoPartido) {
                System.out.println("7: " + p.getDescricao());
                encontrou = true;
            }
        }
        for (Governador g : governadores) {
            if (g.getPartido().getCodigo() == codigoPartido) {
                System.out.println("7: " + g.getDescricao());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("7: nenhum candidato cadastrado.");
    }

    public Candidato mostraEleito(String cep, CadastroVotos cadastroVoto) {
        Candidato eleito = null;
        int maiorVotos = 0;
        int ultimoVoto = Integer.MAX_VALUE;

        for (Presidente p : presidentes) {
            if (p.getLocalidade().getCep().equals(cep)) {
                int votos = cadastroVoto.contaVotos(p);
                int ultimo = cadastroVoto.ultimoVoto(p);
                if (votos > maiorVotos || (votos == maiorVotos && votos > 0 && ultimo < ultimoVoto)) {
                    maiorVotos = votos;
                    ultimoVoto = ultimo;
                    eleito = p;
                }
            }
        }
        for (Governador g : governadores) {
            if (g.getLocalidade().getCep().equals(cep)) {
                int votos = cadastroVoto.contaVotos(g);
                int ultimo = cadastroVoto.ultimoVoto(g);
                if (votos > maiorVotos || (votos == maiorVotos && votos > 0 && ultimo < ultimoVoto)) {
                    maiorVotos = votos;
                    ultimoVoto = ultimo;
                    eleito = g;
                }
            }
        }
        return eleito;
    }

    public ArrayList<Presidente> getPresidentes() { return presidentes; }
    public ArrayList<Governador> getGovernadores() { return governadores; }
}
