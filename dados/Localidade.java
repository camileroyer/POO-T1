package dados;

public class Localidade {
    private String cep;
    private String nome;
    private long qtdEleitores;
    private TipoLocalidade tipo;

    public String getCep() { return cep; }
    public String getNome() { return nome; }
    public long getQtdEleitores() { return qtdEleitores; }
    public TipoLocalidade getTipo() { return tipo; }
    
    public void setCep(String cep) { this.cep = cep; }
    public void setNome(String nome) { this.nome = nome; }
    public void setQtdEleitores(long qtdEleitores) { this.qtdEleitores = qtdEleitores; }
    public void setTipo(TipoLocalidade tipo) { this.tipo = tipo; }
    
}
