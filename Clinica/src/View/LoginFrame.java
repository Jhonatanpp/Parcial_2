package View;

import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginFrame extends JFrame {

    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public LoginFrame() {
        setTitle("Ingreso al Sistema - Clínica Vida");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cargarUsuarios(); // Carga desde archivo
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblUsuario = new JLabel("Usuario:");
        JTextField txtUsuario = new JTextField();

        JLabel lblClave = new JLabel("Contraseña:");
        JPasswordField txtClave = new JPasswordField();

        JLabel lblTipo = new JLabel("Tipo:");
        String[] tipos = {"admin", "medico"};
        JComboBox<String> cmbTipo = new JComboBox<>(tipos);

        JButton btnIngresar = new JButton("Ingresar");
        JButton btnRegistrar = new JButton("Crear Usuario");

        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String clave = new String(txtClave.getPassword());
            String tipoSeleccionado = (String) cmbTipo.getSelectedItem();

            Usuario u = usuarios.get(usuario);

            if (u != null && u.getContraseña().equals(clave) && u.getTipo().equals(tipoSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + u.getTipo());

                if (u.getTipo().equals("admin")) {
                    new VentanaPrincipal().setVisible(true);
                } else {
                    new VentanaMedico().setVisible(true);
                }

                dispose(); // Cierra la ventana de login
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas o tipo inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnRegistrar.addActionListener(e -> {
            new RegistroUsuarioFrame(usuarios).setVisible(true);
        });

        panel.add(lblUsuario); panel.add(txtUsuario);
        panel.add(lblClave); panel.add(txtClave);
        panel.add(lblTipo); panel.add(cmbTipo);
        panel.add(btnIngresar); panel.add(btnRegistrar);

        add(panel);
    }

    // ===============================
    // MÉTODOS DE PERSISTENCIA
    // ===============================

    private void cargarUsuarios() {
        File archivo = new File(ARCHIVO_USUARIOS);
        if (!archivo.exists()) {
            // usuarios por defecto
            usuarios.put("admin", new Usuario("admin", "admin", "admin"));
            usuarios.put("medico", new Usuario("medico", "1234", "medico"));
            guardarUsuarios(); // guarda los iniciales
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            usuarios = (Map<String, Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar usuarios: " + e.getMessage());
        }
    }

    // Permitir guardar desde otras clases como RegistroUsuarioFrame
    public static void guardarUsuariosExternamente() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


