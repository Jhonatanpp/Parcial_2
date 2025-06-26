package Viewmodel;

import Model.*;
import Persistencia.PersistenciaArchivo;
import Excepciones.CampoVacioException;
import Excepciones.UsuarioNoEncontradoException;

import java.util.List;

public class ClinicaViewModel {

    private Clinica clinica;

    public ClinicaViewModel() {
        this.clinica = PersistenciaArchivo.cargarClinica(); // ✅ Carga desde archivo
    }

    // ✅ Registrar Paciente
    public void registrarPaciente(String nombre, String id, String correo) throws CampoVacioException {
        if (nombre.isEmpty() || id.isEmpty() || correo.isEmpty()) {
            throw new CampoVacioException("Todos los campos son obligatorios.");
        }

        Paciente paciente = new Paciente(nombre, id, correo);
        clinica.agregarPaciente(paciente);
        PersistenciaArchivo.guardarClinica(clinica); // ✅ Guardar después de agregar
    }

    // ✅ Registrar Médico
    public void registrarMedico(String nombre, String id, String correo, String especialidad) throws CampoVacioException {
        if (nombre.isEmpty() || id.isEmpty() || correo.isEmpty() || especialidad.isEmpty()) {
            throw new CampoVacioException("Todos los campos son obligatorios.");
        }

        Medico medico = new Medico(nombre, id, correo, especialidad);
        clinica.agregarMedico(medico);
        PersistenciaArchivo.guardarClinica(clinica);
    }

    // ✅ Registrar Consulta
    public void registrarConsulta(String idConsulta, String idMedico, String idPaciente,
                                  String sintomas, String diagnostico, String tratamiento)
            throws CampoVacioException, UsuarioNoEncontradoException {

        if (sintomas.isEmpty() || diagnostico.isEmpty() || tratamiento.isEmpty()) {
            throw new CampoVacioException("Debe completar todos los campos de la consulta.");
        }

        clinica.registrarConsulta(idConsulta, idMedico, idPaciente, sintomas, diagnostico, tratamiento);
        PersistenciaArchivo.guardarClinica(clinica);
    }

    // ✅ Obtener listas para ComboBox
    public List<Paciente> getPacientes() {
        return clinica.getPacientes();
    }

    public List<Medico> getMedicos() {
        return clinica.getMedicos();
    }

    // ✅ Consultar historial por paciente o médico
    public List<Consulta> obtenerHistorialPaciente(String idPaciente) throws UsuarioNoEncontradoException {
        return clinica.obtenerHistorialPaciente(idPaciente);
    }

    public List<Consulta> obtenerConsultasMedico(String idMedico) throws UsuarioNoEncontradoException {
        return clinica.obtenerConsultasMedico(idMedico);
    }
}


