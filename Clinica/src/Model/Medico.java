/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jhpcp
 */
public class Medico extends Persona implements Agendable {

    private String especialidad;

    public Medico(String nombre, String id, String correo, String especialidad) {
        super(nombre, id, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void agendarConsulta() {
        // Lógica pendiente
    }

    @Override
    public String getTipo() {
        return "Medico";
    }
}