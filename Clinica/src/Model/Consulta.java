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

public class Consulta implements Serializable {
    private String idConsulta;
    private Medico medico;
    private Paciente paciente;
    private String sintomas;
    private String diagnostico;
    private String tratamiento;

    public Consulta(String idConsulta, Medico medico, Paciente paciente,
                    String sintomas, String diagnostico, String tratamiento) {
        this.idConsulta = idConsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    @Override
    public String toString() {
        return "Consulta ID: " + idConsulta +
               "\nPaciente: " + paciente.getNombre() +
               "\nMedico: " + medico.getNombre() +
               "\nSíntomas: " + sintomas +
               "\nDiagnóstico: " + diagnostico +
               "\nTratamiento: " + tratamiento + "\n";
    }
}
