/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jhpcp
 */

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String contraseña;
    private String tipo; // "medico" o "admin"

    public Usuario(String nombre, String contraseña, String tipo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTipo() {
        return tipo;
    }
}

