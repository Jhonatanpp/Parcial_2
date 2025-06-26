package View;

import Viewmodel.ClinicaViewModel;
import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel {

    public PanelInicio() {
        setLayout(new BorderLayout());

        // Panel con imagen de fondo
        JPanel panelImagen = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carga desde recursos del proyecto
                ImageIcon img = new ImageIcon(getClass().getResource("/resources/img/portada_clinica.png"));
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        panelImagen.setLayout(new BorderLayout());

        // Frase central
        JLabel frase = new JLabel("<html><div style='text-align: center;'>Nuestras<br><b>sonrisas hablan</b></div></html>", SwingConstants.CENTER);
        frase.setFont(new Font("SansSerif", Font.BOLD, 32));
        frase.setForeground(Color.WHITE);
        frase.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));

        // Subfrase
        JLabel subtitulo = new JLabel("Técnicas dentales en manos de profesionales", SwingConstants.CENTER);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subtitulo.setForeground(Color.WHITE);

        // Botón de acción
        JButton btnAgendar = new JButton("Agendar Cita");
        btnAgendar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnAgendar.setBackground(new Color(0, 120, 215));
        btnAgendar.setForeground(Color.WHITE);
        btnAgendar.setFocusPainted(false);

        // Acción: abrir PanelConsulta
        btnAgendar.addActionListener(e -> {
            JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);
            ClinicaViewModel viewModel = null;
            ventana.setContentPane(new PanelConsulta(viewModel));
            ventana.revalidate();
        });

        // Contenedor de texto y botón
        JPanel contenedorTexto = new JPanel(new GridLayout(3, 1, 10, 10));
        contenedorTexto.setOpaque(false);
        contenedorTexto.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));

        contenedorTexto.add(frase);
        contenedorTexto.add(subtitulo);
        contenedorTexto.add(btnAgendar);

        panelImagen.add(contenedorTexto, BorderLayout.CENTER);
        add(panelImagen, BorderLayout.CENTER);
    }
}
