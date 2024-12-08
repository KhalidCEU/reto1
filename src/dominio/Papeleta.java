package dominio;

import java.util.ArrayList;

public class Papeleta {
    private ArrayList<Candidato> listaPreferencias;

    public Papeleta() {
        this.listaPreferencias = new ArrayList<Candidato>();
    }

    public ArrayList<Candidato> getListaPreferencias() {
        return this.listaPreferencias;
    }

    public void agregarPreferencia(Candidato candidato) {
        listaPreferencias.add(candidato);
    }

    public Candidato eliminarCandidato(Candidato candidato) {
        if (listaPreferencias == null) {
            return null;
        }

        try {
            listaPreferencias.remove(candidato);
        } catch (Exception e) {
            System.out.println("Error al eliminar candidato : " + e.getMessage());
        }
        return candidato;
    }

    public Candidato obtenerPrimeraPreferencia() {
        if (listaPreferencias == null || listaPreferencias.isEmpty()) {
            return null;
        }

        try {
            return listaPreferencias.get(0);
        } catch (Exception e) {
            System.out.println("Error al obtener primera preferencia : " + e.getMessage());
            return null;
        }
    }

    public Candidato obtenerSiguientePreferencia(Candidato candidatoEliminado) {
        int index = listaPreferencias.indexOf(candidatoEliminado);

        if (index >= 0 && index < listaPreferencias.size() - 1) {
            return listaPreferencias.get(index + 1);
        }
        return null;
    }

    public boolean esValida(ArrayList<Candidato> candidatosValidos) {
        if (listaPreferencias.isEmpty()) {
            return false;
        }

        for (int i = 0; i < listaPreferencias.size(); i++) {
            Candidato candidato = listaPreferencias.get(i);

            if (!candidatosValidos.contains(candidato)) {
                return false;
            }

            // Verificar duplicados
            for (int j = i + 1; j < listaPreferencias.size(); j++) {
                if (candidato.equals(listaPreferencias.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
