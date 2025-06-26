package View;

import Model.Medico;
import Model.Paciente;
import Viewmodel.ClinicaViewModel;
import Excepciones.CampoVacioException;
import Excepciones.UsuarioNoEncontradoException;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class PanelConsulta extends JPanel {

    private ClinicaViewModel viewModel = new ClinicaViewModel();

    public PanelConsulta(ClinicaViewModel viewModel1) {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 250, 255));

        JLabel titulo = new JLabel("Registro de Consultas Médicas", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(Color.white);
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblPaciente = new JLabel("Paciente:");
        JComboBox<Paciente> cmbPacientes = new JComboBox<>();
        for (Paciente p : viewModel.getPacientes()) {
            cmbPacientes.addItem(p);
        }

        JLabel lblMedico = new JLabel("Médico:");
        JComboBox<Medico> cmbMedicos = new JComboBox<>();
        for (Medico m : viewModel.getMedicos()) {
            cmbMedicos.addItem(m);
        }

        JLabel lblSintomas = new JLabel("Síntomas:");
        JTextField txtSintomas = new JTextField();

        JLabel lblDiagnostico = new JLabel("Diagnóstico:");
        JTextField txtDiagnostico = new JTextField();

        JLabel lblTratamiento = new JLabel("Tratamiento:");
        JTextField txtTratamiento = new JTextField();

        JButton btnRegistrar = new JButton("Registrar Consulta");
        btnRegistrar.setBackground(new Color(180, 215, 255));
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 14));

        btnRegistrar.addActionListener(e -> {
            try {
                Paciente paciente = (Paciente) cmbPacientes.getSelectedItem();
                Medico medico = (Medico) cmbMedicos.getSelectedItem();

                if (paciente == null || medico == null) {
                    throw new CampoVacioException("Debe seleccionar paciente y médico.");
                }

                String idConsulta = UUID.randomUUID().toString();

                viewModel.registrarConsulta(
                        idConsulta,
                        medico.getId(),
                        paciente.getId(),
                        txtSintomas.getText(),
                        txtDiagnostico.getText(),
                        txtTratamiento.getText()
                );

                JOptionPane.showMessageDialog(this, "Consulta registrada correctamente.");
                txtSintomas.setText("");
                txtDiagnostico.setText("");
                txtTratamiento.setText("");

            } catch (CampoVacioException | UsuarioNoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Añadir componentes al formulario
        gbc.gridx = 0; gbc.gridy = 0; panelFormulario.add(lblPaciente, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panelFormulario.add(cmbPacientes, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panelFormulario.add(lblMedico, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panelFormulario.add(cmbMedicos, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panelFormulario.add(lblSintomas, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panelFormulario.add(txtSintomas, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panelFormulario.add(lblDiagnostico, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panelFormulario.add(txtDiagnostico, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panelFormulario.add(lblTratamiento, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panelFormulario.add(txtTratamiento, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 5; panelFormulario.add(btnRegistrar, gbc);

        // Añadir al panel principal
        add(titulo, BorderLayout.NORTH);
        add(panelFormulario, BorderLayout.CENTER);
        
        
    }
}



