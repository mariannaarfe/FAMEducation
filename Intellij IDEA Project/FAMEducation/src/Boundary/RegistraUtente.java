package Boundary;

import Controller.ControllerGestoreClasse;
import Entity.Ruolo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraUtente extends JFrame {

    private JPanel panel;
    private JLabel titolo_finestra;
    private JButton registratiButton;
    private JTextField nome_text;
    private JTextField cognome_text;
    private JTextField email_text;
    private JPasswordField password_text;
    private JComboBox ruolo_combo;
    private JCheckBox visualizzaPasswordCheckBox;

    private ControllerGestoreClasse controller;

    public RegistraUtente() {
        registratiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean datiValidi = false;

                String nome;
                String cognome;
                String email;
                Ruolo ruolo;
                String password;

                int ret = controlloDati();

                if (ret == 0) {

                    nome = nome_text.getText();
                    cognome = cognome_text.getText();
                    email = email_text.getText();
                    password = password_text.getText();
                    ruolo = Ruolo.valueOf(ruolo_combo.getSelectedItem().toString());

                    controller = new ControllerGestoreClasse();

                    int controllo = controller.registraUtente(nome, cognome, email, ruolo, password);

                    switch (controllo) {

                        case 0 ->{
                            JOptionPane.showMessageDialog(new JFrame(), "L'utente è stato registrato correttamente", "Utente registrato", JOptionPane.WARNING_MESSAGE);
                            controller.setNome (nome);
                            controller.setEmail (email);


                            if (ruolo == Ruolo.Studente) {

                                new Studente(controller);
                                dispose();

                            } else {

                                new Docente(controller);
                                dispose();

                            }

                        }

                        case -1 -> JOptionPane.showMessageDialog(new JFrame(), "L'utente esiste già!", "Utente non registrato", JOptionPane.ERROR_MESSAGE);

                        default -> JOptionPane.showMessageDialog(new JFrame(), "Errore generico nella registrazione", "Utente non registrato", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }
        });
    }


    public static void main(String[] args) {

        RegistraUtente registraUtente = new RegistraUtente();

        registraUtente.setContentPane(registraUtente.panel);

        registraUtente.setVisible(true);

        registraUtente.setLocationRelativeTo(null);

        registraUtente.setResizable(false);

        registraUtente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registraUtente.setTitle("FAMEducation - Registrazione");

        registraUtente.setSize(530, 350);

    }

    public int controlloDati() {

        int ret = 0;

        if (nome_text.getText().length() == 0 || nome_text.getText().length() > 50) {

            JOptionPane.showMessageDialog(new JFrame(), "La lunghezza del nome deve essere compreso tra 1 e 50 caratteri", "Errore inserimento nome", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        if (cognome_text.getText().length() == 0 || cognome_text.getText().length() > 50) {

            JOptionPane.showMessageDialog(new JFrame(), "La lunghezza del cognome deve essere compreso tra 1 e 50 caratteri", "Errore inserimento cognome", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        if (email_text.getText().length() == 0 || email_text.getText().length() > 50) {

            JOptionPane.showMessageDialog(new JFrame(), "La lunghezza della e-mail deve essere compreso tra 1 e 50 caratteri", "Errore inserimento e-mail", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        if (password_text.getText().length() == 0 || password_text.getText().length() > 15) {

            JOptionPane.showMessageDialog(new JFrame(), "La lunghezza della password deve essere compreso tra 1 e 50 caratteri", "Errore inserimento password", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        if (!(nome_text.getText().matches("^[\\p{L}' ]+$"))) {

            JOptionPane.showMessageDialog(new JFrame(), "Il nome non può contenere caratteri speciali", "Errore inserimento nome", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        if (!(cognome_text.getText().matches("^[\\p{L}' ]+$"))) {

            JOptionPane.showMessageDialog(new JFrame(), "Il cognome non può contenere caratteri speciali", "Errore inserimento cognome", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        if (!(email_text.getText().matches(".*@.*"))) {

            JOptionPane.showMessageDialog(new JFrame(), "La e-mail deve necessariamente contenere la chiocciola", "Errore inserimento email", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        if (!(password_text.getText().matches("^(?=.*[0-9])(?=.*[^a-zA-Z0-9]).+$"))) {

            JOptionPane.showMessageDialog(new JFrame(), "La password deve necessariamente contenere un numero e un carattere speciale", "Errore inserimento password", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }

        return ret;

    }


}
