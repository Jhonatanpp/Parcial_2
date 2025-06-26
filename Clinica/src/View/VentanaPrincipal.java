package View;

import Viewmodel.ClinicaViewModel;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private ClinicaViewModel viewModel; // ✅ instancia única

    public VentanaPrincipal() {
        setTitle("Clínica Vida – Sistema de Gestión");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        viewModel = new ClinicaViewModel(); // ✅ se crea solo una vez

        initComponents();
        setContentPane(new PanelInicio()); // pantalla de bienvenida
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menú");
        JMenuItem itemRegistro = new JMenuItem("Registro");
        JMenuItem itemConsulta = new JMenuItem("Consulta");
        JMenuItem itemHistorial = new JMenuItem("Historial");

        // Acciones
        itemRegistro.addActionListener(e -> {
            setContentPane(new PanelRegistro(viewModel)); // ✅ pasa el ViewModel
            revalidate();
        });

        itemConsulta.addActionListener(e -> {
            setContentPane(new PanelConsulta(viewModel)); // ✅ pasa el ViewModel
            revalidate();
        });

        itemHistorial.addActionListener(e -> {
            setContentPane(new PanelHistorial(viewModel)); // ✅ pasa el ViewModel
            revalidate();
        });

        menu.add(itemRegistro);
        menu.add(itemConsulta);
        menu.add(itemHistorial);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
}


