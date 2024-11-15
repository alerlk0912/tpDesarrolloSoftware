package Tp.DS;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class PantallaIntro {
    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private Consumer<ModeSelection> onModeSelected;

    public PantallaIntro() {
        frame = new JFrame("Bienvenido Usuario");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        JLabel lblWelcome = new JLabel("BIENVENIDO USUARIO", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(lblWelcome);

        JPanel panelButtons = new JPanel();
        JButton btnJDBC = new JButton("JDBC");
        JButton btnMemory = new JButton("MEMORY");
        panelButtons.add(btnJDBC);
        panelButtons.add(btnMemory);
        frame.add(panelButtons);

        JLabel lblInfo = new JLabel("Elige la opción e ingresa tus credenciales:", SwingConstants.CENTER);
        frame.add(lblInfo);

        JPanel panelUsername = new JPanel(new FlowLayout());
        panelUsername.add(new JLabel("Usuario:"));
        txtUsername = new JTextField(15);
        txtUsername.setText("root");
        panelUsername.add(txtUsername);
        frame.add(panelUsername);

        JPanel panelPassword = new JPanel(new FlowLayout());
        panelPassword.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField(15);
        panelPassword.add(txtPassword);
        frame.add(panelPassword);

        btnJDBC.addActionListener(e -> {
            if (validateInputs()) {
                if (onModeSelected != null) {
                    onModeSelected.accept(new ModeSelection(true, txtUsername.getText().trim(), new String(txtPassword.getPassword()).trim()));
                }
                frame.dispose();
            }
        });

        btnMemory.addActionListener(e -> {
            if (onModeSelected != null) {
                onModeSelected.accept(new ModeSelection(false, null, null));
            }
            frame.dispose();
        });

        frame.setVisible(true);
    }

    private boolean validateInputs() {
        String usuario = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Usuario y/o contraseña no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!usuario.equals("root") || !password.equals("")) {
            JOptionPane.showMessageDialog(frame, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void setOnModeSelected(Consumer<ModeSelection> onModeSelected) {
        this.onModeSelected = onModeSelected;
    }
}

