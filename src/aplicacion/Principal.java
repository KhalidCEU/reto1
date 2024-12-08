package aplicacion;

import dominio.*;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {
    private static SistemaElecciones sistemaElecciones = new SistemaElecciones();


    public static void main(String[] args) {
        ArrayList<Candidato> candidatos = crearCandidatos();

        for (Candidato c : candidatos) {
            sistemaElecciones.agregarCandidato(c);
        }

        ArrayList<Papeleta> papeletas = crearPapeletas();

        for (Papeleta p : papeletas) {
            sistemaElecciones.agregarPapeleta(p);
        }

        crearPreferenciasAleatorias(candidatos, papeletas);

        sistemaElecciones.iniciarEleccion();
        sistemaElecciones.mostrarResultados();
    }


    private static ArrayList<Candidato> crearCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<>();

        candidatos.add(new Candidato("Carla"));
        candidatos.add(new Candidato("Juan"));
        candidatos.add(new Candidato("Pepe"));
        candidatos.add(new Candidato("Luis"));
        candidatos.add(new Candidato("Rosa"));

        return candidatos;
    }

    private static ArrayList<Papeleta> crearPapeletas() {
        ArrayList<Papeleta> papeletas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Papeleta papeleta = new Papeleta();
            papeletas.add(papeleta);
        }

        return papeletas;
    }

    private static void crearPreferenciasAleatorias(ArrayList<Candidato> candidatos, ArrayList<Papeleta> papeletas) {
        for (Papeleta papeleta : papeletas) {
            ArrayList<Candidato> candidatosAleatorios = new ArrayList<>(candidatos);
            Collections.shuffle(candidatosAleatorios);

            for (Candidato candidato : candidatosAleatorios) {
                papeleta.agregarPreferencia(candidato);
            }
        }
    }
}