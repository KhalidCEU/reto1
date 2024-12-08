package dominio;

public class SistemaElecciones {
    private Eleccion eleccion;

    public SistemaElecciones() {
        this.eleccion = new Eleccion();
    }

    public void iniciarEleccion() {
        if (!eleccion.validarPapeletas()) {
            System.out.println("Error: Algunas papeletas no son válidas.");
            return;
        }

        boolean hayGanador = false;
        int i = 0;

        while (!hayGanador) {
            eleccion.realizarRecuento();
            if (eleccion.comprobarMayoríaAbsoluta()) {
                hayGanador = true;
            } else {
                i++;
                System.out.println("[Ronda " + i + "] " + "Ningún candidato tiene mayoría absoluta.");
                Candidato eliminado = eleccion.eliminarCandidatoConMenosVotos();
                eleccion.transferirVotos(eliminado);

                if (eleccion.getCandidatos().size() <= 1) {
                    hayGanador = true;
                }
            }
        }

        eleccion.mostrarResultado();
    }

    public void agregarPapeleta(Papeleta papeleta) {
        this.eleccion.agregarPapeleta(papeleta);
    }

    public void agregarCandidato(Candidato candidato) {
        this.eleccion.agregarCandidato(candidato);
    }

    public void mostrarResultados() {
        this.eleccion.realizarRecuento();
    }
}
