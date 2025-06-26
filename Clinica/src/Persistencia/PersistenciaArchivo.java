package Persistencia;

import Model.Clinica;

import java.io.*;

public class PersistenciaArchivo {

    private static final String ARCHIVO = "clinica.dat";

    public static void guardarClinica(Clinica clinica) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(clinica);
        } catch (IOException e) {
            System.err.println("Error al guardar la clínica: " + e.getMessage());
        }
    }

    public static Clinica cargarClinica() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (Clinica) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontró el archivo de clínica. Se creará uno nuevo.");
            return new Clinica(); // Devuelve clínica vacía si no hay archivo
        }
    }
}
