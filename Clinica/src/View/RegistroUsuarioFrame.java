package View;

import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RegistroUsuarioFrame extends JFrame {

    private Map<String, Usuario> usuarios;

    public RegistroUsuarioFrame(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
        setTitle("Crear Nuevo Usuario");
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblUsuario = new JLabel("Usuario:");
        JTextField txtUsuario = new JTextField();

        JLabel lblClave = new JLabel("Contraseña:");
        JPasswordField txtClave = new JPasswordField();

        JLabel lblTipo = new JLabel("Tipo:");
        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"admin", "medico"});

        JButton btnCrear = new JButton("Crear Usuario");

        btnCrear.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String clave = new String(txtClave.getPassword());
            String tipo = (String) cmbTipo.getSelectedItem();

            if (usuario.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (usuarios.containsKey(usuario)) {
                JOptionPane.showMessageDialog(this, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            usuarios.put(usuario, new Usuario(usuario, clave, tipo));
            LoginFrame.guardarUsuariosExternamente(); // 🔥 Guarda en archivo
            JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
            dispose();
        });

        panel.add(lblUsuario); panel.add(txtUsuario);
        panel.add(lblClave); panel.add(txtClave);
        panel.add(lblTipo); panel.add(cmbTipo);
        panel.add(new JLabel()); panel.add(btnCrear);

        add(panel);
    }
}


