package dados;

public class Presidente extends Candidato {
    private double patrimonio;

    public Presidente(int numero, String nome, Partido partido, Localidade localidade, double patrimonio){
        super(numero, nome, partido, localidade);
        this.patrimonio = patrimonio;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }
    
     @Override
    public void getDescricao(){
        //return "Numero: " + getNumero()  + "Nome: " + getNome() + "Escolaridade: " +escolaridade;
    }
}
