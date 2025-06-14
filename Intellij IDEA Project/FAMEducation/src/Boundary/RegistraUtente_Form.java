package Boundary;

import javax.swing.*;

public class RegistraUtente_Form extends JFrame {
    private JPanel panel;
    private JButton registratiButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;

    public static void main(String[] args) {

        RegistraUtente_Form rf = new RegistraUtente_Form();
        rf.setContentPane(rf.panel);
        rf.setVisible(true);
        rf.setSize(600, 600);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setLocationRelativeTo(null);
        rf.setTitle("Registrazione");
        rf.setResizable(false);

    }

}
