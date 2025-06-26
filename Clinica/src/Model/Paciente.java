/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jhpcp
 */
public class Paciente extends Persona {

    public Paciente(String nombre, String id, String correo) {
        super(nombre, id, correo);
    }

    @Override
    public String getTipo() {
        return "Paciente";
    }
}
