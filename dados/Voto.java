package dados;

public class Voto {
    private int id;
    private int hora;
    private Candidato candidato;
    private Localidade localidade;

    public Voto(int id, int hora, Candidato candidato, Localidade localidade) {
        this.id = id;
        this.hora = hora;
        this.candidato = candidato;
        this.localidade = localidade;
    }

    public int getId() { return id; }
    public int getHora() { return hora; }
    public Candidato getCandidato() { return candidato; }
    public Localidade getLocalidade() { return localidade; }

    public void setId(int id) { this.id = id; }
    public void setHora(int hora) { this.hora = hora; }
    public void setCandidato(Candidato candidato) { this.candidato = candidato; }
    public void setLocalidade(Localidade localidade) { this.localidade = localidade; }

    public String getDescricao() {
        return id + " - " + hora + " - " + candidato.getNome() + " - " + localidade.getNome();
    }
}
