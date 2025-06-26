package View;

import Viewmodel.ClinicaViewModel;
import Excepciones.CampoVacioException;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {

    private final ClinicaViewModel viewModel;

    public PanelRegistro(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 250, 255)); // fondo suave

        JLabel titulo = new JLabel("Registro de Pacientes y Médicos", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pestañas.addTab("Paciente", crearPanelPaciente());
        pestañas.addTab("Médico", crearPanelMedico());

        add(titulo, BorderLayout.NORTH);
        add(pestañas, BorderLayout.CENTER);
    }

    private JPanel crearPanelPaciente() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField();

        JLabel lblCorreo = new JLabel("Correo:");
        JTextField txtCorreo = new JTextField();

        JButton btnRegistrar = new JButton("Registrar Paciente");
        btnRegistrar.setBackground(new Color(180, 215, 255));
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 14));

        btnRegistrar.addActionListener(e -> {
            try {
                viewModel.registrarPaciente(
                        txtNombre.getText(),
                        txtId.getText(),
                        txtCorreo.getText()
                );
                JOptionPane.showMessageDialog(this, "Paciente registrado correctamente.");
                txtNombre.setText("");
                txtId.setText("");
                txtCorreo.setText("");
            } catch (CampoVacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblNombre, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblId, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblCorreo, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(txtCorreo, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 3; panel.add(btnRegistrar, gbc);

        return panel;
    }

    private JPanel crearPanelMedico() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField();

        JLabel lblCorreo = new JLabel("Correo:");
        JTextField txtCorreo = new JTextField();

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        JTextField txtEspecialidad = new JTextField();

        JButton btnRegistrar = new JButton("Registrar Médico");
        btnRegistrar.setBackground(new Color(180, 215, 255));
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 14));

        btnRegistrar.addActionListener(e -> {
            try {
                viewModel.registrarMedico(
                        txtNombre.getText(),
                        txtId.getText(),
                        txtCorreo.getText(),
                        txtEspecialidad.getText()
                );
                JOptionPane.showMessageDialog(this, "Médico registrado correctamente.");
                txtNombre.setText("");
                txtId.setText("");
                txtCorreo.setText("");
                txtEspecialidad.setText("");
            } catch (CampoVacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblNombre, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblId, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblCorreo, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(txtCorreo, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblEspecialidad, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(txtEspecialidad, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 4; panel.add(btnRegistrar, gbc);

        return panel;
    }
}



