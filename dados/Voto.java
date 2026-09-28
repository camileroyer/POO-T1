package dados;

public class Voto {
    private int id;
    private int hora;

    public Voto(int id, int hora){
        this.id = id;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }
    public int getHora() {
        return hora;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
}
