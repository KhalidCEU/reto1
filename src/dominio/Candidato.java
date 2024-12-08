package dominio;

public class Candidato {
    private String nombre;
    private int votos;

    public Candidato(String nombre ) {
        this.nombre = nombre;
        this.votos = 0;
    }

    public int getVotos() {
        return this.votos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void incrementarVotos() {
        this.votos += 1;
    }

    public void resetearVotos() {
        this.votos = 0;
    }
}
