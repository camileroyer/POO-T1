package dados;

public class Governador extends Candidato {
    private String escolaridade;

    public Governador(int numero, String nome, String escolaridade){
        super(numero, nome);
        this.escolaridade = escolaridade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    @Override
    public void getDescricao(){
        //return "Numero: " + getNumero()  + "Nome: " + getNome() + "Escolaridade: " +escolaridade;
    }
}
