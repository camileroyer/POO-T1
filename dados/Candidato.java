package dados;

public abstract class Candidato {
    private int numero;
    private String nome;

    public Candidato(int numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }
    public int getNumero(){ return numero; }
    public String getNome(){ return nome; }
    public void setNumero() { this.numero = numero; }
    public void setNome() { this.nome = nome; }

    public abstract void getDescricao();
}
