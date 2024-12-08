package dominio;

import java.util.ArrayList;


public class Eleccion {
    private ArrayList<Candidato> candidatos;
    private ArrayList<Papeleta> papeletas;

    private int totalVotos;

    public Eleccion() {
        this.candidatos = new ArrayList<Candidato>();
        this.papeletas = new ArrayList<Papeleta>();
    }

    public ArrayList<Candidato> getCandidatos() {
        return this.candidatos;
    }

    public void agregarCandidato(Candidato c) {
        this.candidatos.add(c);
    }

    public void agregarPapeleta(Papeleta papeleta) {
        papeletas.add(papeleta);
    }

    public void realizarRecuento() {
        try {
            for (Candidato c : candidatos) {
                c.setVotos(0);
            }
            for (Papeleta p : papeletas) {
                Candidato primeraPreferencia  = p.obtenerPrimeraPreferencia();
                if (primeraPreferencia != null) {
                    primeraPreferencia.incrementarVotos();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al realizar recuento " + e.getMessage());
        }
    }

    public void mostrarResultado() {
        System.out.print("\n");
        System.out.println("Resultados del recuento");
        System.out.println("-----------------------");
        System.out.print("\n");


        for (Candidato c : candidatos) {
            System.out.println(c.getNombre() + ": " + c.getVotos()
            + " votos.");
        }
    }

    public Candidato eliminarCandidatoConMenosVotos() {
        if (candidatos.isEmpty()) {
            return null;
        }

        Candidato candidatoConMenosVotos = candidatos.get(0);
        for (Candidato c : candidatos) {
            if (c.getVotos() < candidatoConMenosVotos.getVotos()) {
                candidatoConMenosVotos = c;
            }
        }
        candidatos.remove(candidatoConMenosVotos);
        System.out.println("El candidato " + candidatoConMenosVotos.getNombre()
            + " (" + candidatoConMenosVotos.getVotos() + " votos)" + " ha sido eliminado.");

        return candidatoConMenosVotos;
    }

    public boolean comprobarMayoríaAbsoluta() {
        this.totalVotos = 0;

        for (Candidato c : candidatos) {
            this.totalVotos += c.getVotos();
        }

        int votosNecesarios = this.totalVotos / 2 + 1;

        for (Candidato c : candidatos) {
            if (c.getVotos() >= votosNecesarios) {
                System.out.println("El candidato " + c.getNombre() +
                    " tiene mayorîa absoluta con " + c.getVotos() + " votos.");

                return true;
            };
        }
        return false;
    }

    public void transferirVotos(Candidato candidatoEliminado) {
        int votosTransferidos = 0;
        Candidato siguientePreferencia = null;

        for (Papeleta p : papeletas) {
            if (p.obtenerPrimeraPreferencia().equals(candidatoEliminado)) {
                siguientePreferencia = p.obtenerSiguientePreferencia(candidatoEliminado);
                if (siguientePreferencia != null && candidatos.contains(siguientePreferencia)) {
                    siguientePreferencia.incrementarVotos();
                    votosTransferidos++;
                }
            }
        }

        if (votosTransferidos > 0) {
            System.out.println("Se han transferido " + votosTransferidos + " votos de " + candidatoEliminado.getNombre()
                + " a " + siguientePreferencia.getNombre());
        } else {
            System.out.println("No se han transferido votos de " + candidatoEliminado.getNombre());
        }
    }

    public boolean validarPapeletas() {
        for (Papeleta p : papeletas) {
            if (!p.esValida(candidatos)) {
                return false;
            }
        }
        return true;
    }

}
