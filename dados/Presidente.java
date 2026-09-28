package dados;

public class Presidente extends Candidato {
    private double patrimonio;

    public Presidente(int idade, String nome, double patrimonio){
        super(idade, nome);
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
