package Boundary;

import Controller.ControllerGestoreClasse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IscrizioneIndiretta extends JFrame {

    private JPanel panel;
    private JLabel label;
    private JLabel codice_label;
    private JTextField codice_text;
    private JButton iscrivitiButton;
    private JButton annullaButton;

    public IscrizioneIndiretta(Sessione sessioneCorrente) {

        this.setContentPane(this.panel);

        this.setVisible(true);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("FAMEDucation - Iscrizione a classe");

        this.setSize(530, 200);

        iscrivitiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ControllerGestoreClasse controller = ControllerGestoreClasse.getInstance();

                int controllo = controlloDati();

                if (controllo == 0) {

                    int ret = controller.iscrizioneIndiretta(codice_text.getText(), sessioneCorrente.getEmail());

                    switch (ret) {

                        case 0 -> {

                            JOptionPane.showMessageDialog(new JFrame(), "L'iscrizione è avvenuta correttamente", "Iscrizione effettuata!", JOptionPane.INFORMATION_MESSAGE);
                            dispose();

                        }

                        case -1 -> JOptionPane.showMessageDialog(new JFrame(), "L'utente è già iscritto ad una classe", "Iscrizione non effettuata", JOptionPane.INFORMATION_MESSAGE);

                        default -> JOptionPane.showMessageDialog(new JFrame(), "Errore generico nell'iscrizione", "Iscrizione non effettuata", JOptionPane.INFORMATION_MESSAGE);

                    }

                }

            }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public int controlloDati() {

        int ret = 0;

        if (!(codice_text.getText().length() == 8)) {

            JOptionPane.showMessageDialog(new JFrame(), "La lunghezza del codice deve essere di 8 caratteri", "Errore inserimento codice", JOptionPane.ERROR_MESSAGE);
            ret = -1;

        }


        if (!(codice_text.getText().matches(".*[^a-zA-Z0-9].*"))) {

            JOptionPane.showMessageDialog(new JFrame(), "Il codice deve necessariamente contenere un carattere speciale", "Errore inserimento codice", JOptionPane.ERROR_MESSAGE);

        }

        return ret;

    }
}