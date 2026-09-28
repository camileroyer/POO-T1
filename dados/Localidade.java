package dados;

public class Localidade {
    private String cep;
    private String nome;
    private long qtdEleitores;

    public String getCep() {
        return cep;
    }
    public String getNome() {
        return nome;
    }
    public long getQtdEleitores() {
        return qtdEleitores;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQtdEleitores(long qtdEleitores) {
        this.qtdEleitores = qtdEleitores;
    }
}
