/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author jhpcp
 */

import Model.Clinica;
import java.io.IOException;

public interface IPersistencia {
    void guardarDatos(Clinica clinica) throws IOException;
    Clinica cargarDatos() throws IOException, ClassNotFoundException;
}
