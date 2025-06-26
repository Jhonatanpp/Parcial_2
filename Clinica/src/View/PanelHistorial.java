package View;

import Viewmodel.ClinicaViewModel;
import Excepciones.UsuarioNoEncontradoException;
import Model.Consulta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelHistorial extends JPanel {

    private final ClinicaViewModel viewModel;

    public PanelHistorial(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 250, 255));

        JLabel titulo = new JLabel("Consulta de Historial Médico", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pestañas.addTab("Por Paciente", crearPanelPorPaciente());
        pestañas.addTab("Por Médico", crearPanelPorMedico());

        add(titulo, BorderLayout.NORTH);
        add(pestañas, BorderLayout.CENTER);
    }

    private JPanel crearPanelPorPaciente() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JPanel panelBuscar = new JPanel(new FlowLayout());
        panelBuscar.setBackground(Color.white);

        JLabel lblId = new JLabel("ID Paciente:");
        JTextField txtId = new JTextField(15);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(180, 215, 255));
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));

        JTextArea areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(areaResultado);

        btnBuscar.addActionListener(e -> {
            String id = txtId.getText().trim();
            try {
                List<Consulta> historial = viewModel.obtenerHistorialPaciente(id);
                if (historial.isEmpty()) {
                    areaResultado.setText("No se encontraron consultas para este paciente.");
                } else {
                    StringBuilder resultado = new StringBuilder();
                    for (Consulta consulta : historial) {
                        resultado.append(consulta.toString()).append("\n-------------------\n");
                    }
                    areaResultado.setText(resultado.toString());
                }
            } catch (UsuarioNoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panelBuscar.add(lblId);
        panelBuscar.add(txtId);
        panelBuscar.add(btnBuscar);

        panel.add(panelBuscar, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelPorMedico() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JPanel panelBuscar = new JPanel(new FlowLayout());
        panelBuscar.setBackground(Color.white);

        JLabel lblId = new JLabel("ID Médico:");
        JTextField txtId = new JTextField(15);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(180, 215, 255));
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));

        JTextArea areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(areaResultado);

        btnBuscar.addActionListener(e -> {
            String id = txtId.getText().trim();
            try {
                List<Consulta> historial = viewModel.obtenerConsultasMedico(id);
                if (historial.isEmpty()) {
                    areaResultado.setText("No se encontraron consultas para este médico.");
                } else {
                    StringBuilder resultado = new StringBuilder();
                    for (Consulta consulta : historial) {
                        resultado.append(consulta.toString()).append("\n-------------------\n");
                    }
                    areaResultado.setText(resultado.toString());
                }
            } catch (UsuarioNoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panelBuscar.add(lblId);
        panelBuscar.add(txtId);
        panelBuscar.add(btnBuscar);

        panel.add(panelBuscar, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }
}


