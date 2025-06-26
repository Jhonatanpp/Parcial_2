package View;

import Viewmodel.ClinicaViewModel;
import javax.swing.*;
import java.awt.*;

public class VentanaMedico extends JFrame {

    public VentanaMedico() {
        setTitle("Panel Médico – Clínica Vida");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("Registro de Consultas Médicas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        ClinicaViewModel viewModel = null;
        panelPrincipal.add(new PanelConsulta(viewModel), BorderLayout.CENTER);

        add(panelPrincipal);
    }
}