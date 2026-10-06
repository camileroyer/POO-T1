package dados;

import java.util.ArrayList;

public class CadastroCandidato{
    ArrayList<Presidente> presidentes = new ArrayList<>();
    ArrayList<Governador> governadores = new ArrayList<>();

    public void cadastraPresidente(Presidente presidente) {

    for (Presidente p : presidentes) {
        if (p.getNome().equals(presidente.getNome())) {
            System.out.println("ERRO - presidente repetido");
            return;
        }
    }
    presidentes.add(presidente);
}

    public void cadastraGovernador(Governador governador){
        for (Governador g : governadores) {
            if (g.getNome().equals(governador.getNome())) {
                System.out.println("ERRO - governador repetido");
                return;
            }
        }
        governadores.add(governador);
    }

    public void consultaCandidato(int numero) {
    for (Presidente p : presidentes) {
        if (p.getNumero() == numero) {
            System.out.println("6: " + p.getNumero() + " - " + p.getNome() + " - " +
                p.getPartido().getNome() + " - " + p.getLocalidade().getNome() + " - " + p.getPatrimonio()); //isso é de getdescricao
            return;
        }
    }
    for (Governador g : governadores) {
        if (g.getNumero() == numero) {
            System.out.println("6: " + g.getNumero() + " - " + g.getNome() + " - " + 
            g.getPartido().getNome() + " - " + g.getLocalidade().getNome() + " - " + g.getEscolaridade());
            return;
        }
    }
    System.out.println("6: ERRO - candidato inexistente.");
}

public void consultaCandidatosPartido(int codigoPartido) {
    boolean encontrou = false;
    for (Presidente p : presidentes) {
        if (p.getPartido().getCodigo() == codigoPartido) {
            System.out.println(
                p.getNumero() + " - " +
                p.getNome() + " - Presidente"
            );
            encontrou = true;
        } }
    for (Governador g : governadores) {
        if (g.getPartido().getCodigo() == codigoPartido) {

            System.out.println(
                g.getNumero() + " - " +
                g.getNome() + " - Governador"
            );
            encontrou = true;
        } }
    if (!encontrou) {
        System.out.println("ERRO - nenhum candidato encontrado.");
    }
}

public void mostraEleito(String cep, CadastroVotos cadastroVoto) {
    int maiorVotos = 0;
    int numeroEleito = 0;
    String nomeEleito = "";
    boolean encontrouCandidato = false;
    for (Presidente p : presidentes) {
        if (p.getLocalidade().getCep().equals(cep)) {
            encontrouCandidato = true;
            int quantidadeVotos = 0;
            for (Voto v : cadastroVoto.getVotos()) {
                if (v.getCep().equals(cep) &&
                    v.getNumeroCandidato() == p.getNumero()) {
                    quantidadeVotos++;
                }
            }
            if (quantidadeVotos > maiorVotos) {
                maiorVotos = quantidadeVotos;
                numeroEleito = p.getNumero();
                nomeEleito = p.getNome();
            }
        }
    }
    for (Governador g : governadores) {
        if (g.getLocalidade().getCep().equals(cep)) {
            encontrouCandidato = true;
            int quantidadeVotos = 0;
            for (Voto v : cadastroVoto.getVotos()) {
                if (v.getCep().equals(cep) &&
                    v.getNumeroCandidato() == g.getNumero()) {
                    quantidadeVotos++;
                }
            }
            if (quantidadeVotos > maiorVotos) {
                maiorVotos = quantidadeVotos;
                numeroEleito = g.getNumero();
                nomeEleito = g.getNome();
            }
        }
    }
    if (!encontrouCandidato) {
        System.out.println("8: nenhum candidato cadastrado.");
        return;
    }
    if (maiorVotos == 0) {
        System.out.println("8: nenhum candidato eleito.");
        return;
    }
    System.out.println(
        "8: " + numeroEleito + " - " +
        nomeEleito + " - " +
        maiorVotos
    );
}

}