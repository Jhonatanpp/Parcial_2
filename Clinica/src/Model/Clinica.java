package Model;

import Excepciones.UsuarioNoEncontradoException;

import java.io.Serializable;
import java.util.*;

public class Clinica implements Serializable {

    private Map<String, Paciente> pacientes;
    private Map<String, Medico> medicos;
    private List<Consulta> consultas;

    public Clinica() {
        this.pacientes = new HashMap<>();
        this.medicos = new HashMap<>();
        this.consultas = new ArrayList<>();
    }

    // Registrar Paciente
    public void agregarPaciente(Paciente paciente) {
        pacientes.put(paciente.getId(), paciente);
    }

    // Registrar Médico
    public void agregarMedico(Medico medico) {
        medicos.put(medico.getId(), medico);
    }

    // Registrar Consulta
    public void registrarConsulta(String idConsulta, String idMedico, String idPaciente, String sintomas, String diagnostico, String tratamiento)
            throws UsuarioNoEncontradoException {

        Medico medico = medicos.get(idMedico);
        Paciente paciente = pacientes.get(idPaciente);

        if (medico == null || paciente == null) {
            throw new UsuarioNoEncontradoException("Médico o paciente no encontrado");
        }

        Consulta consulta = new Consulta(idConsulta, medico, paciente, sintomas, diagnostico, tratamiento);
        consultas.add(consulta);
    }

    // Obtener todos los pacientes
    public List<Paciente> getPacientes() {
        return new ArrayList<>(pacientes.values());
    }

    // Obtener todos los médicos
    public List<Medico> getMedicos() {
        return new ArrayList<>(medicos.values());
    }

    // Obtener historial de un paciente
    public List<Consulta> obtenerHistorialPaciente(String idPaciente) throws UsuarioNoEncontradoException {
        if (!pacientes.containsKey(idPaciente)) {
            throw new UsuarioNoEncontradoException("Paciente no encontrado");
        }

        List<Consulta> resultado = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getId().equals(idPaciente)) {
                resultado.add(consulta);
            }
        }
        return resultado;
    }

    // Obtener historial de un médico
    public List<Consulta> obtenerConsultasMedico(String idMedico) throws UsuarioNoEncontradoException {
        if (!medicos.containsKey(idMedico)) {
            throw new UsuarioNoEncontradoException("Médico no encontrado");
        }

        List<Consulta> resultado = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().getId().equals(idMedico)) {
                resultado.add(consulta);
            }
        }
        return resultado;
    }
}

