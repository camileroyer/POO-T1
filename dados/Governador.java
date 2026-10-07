package dados;

public class Governador extends Candidato {
    private String escolaridade;

    public Governador(int numero, String nome, Partido partido, Localidade localidade, String escolaridade){
        super(numero, nome, partido, localidade);
        this.escolaridade = escolaridade;
    }

    public String getEscolaridade() { return escolaridade; }
    public void setEscolaridade(String escolaridade) { this.escolaridade = escolaridade; }

    @Override
    public String getDescricao(){
        return getNumero() + " - " + getNome() + " - " + getPartido().getNome() + " - " + getLocalidade().getNome() + " - " + escolaridade;
    }
}
