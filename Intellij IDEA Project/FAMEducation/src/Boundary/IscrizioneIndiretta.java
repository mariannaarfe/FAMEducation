package Boundary;

import Controller.ControllerGestoreClasse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class IscrizioneIndiretta extends JFrame {

    private ControllerGestoreClasse controller;

    private JPanel panel;
    private JLabel label;
    private JLabel codice_label;
    private JTextField codice_text;
    private JButton iscrivitiButton;


    public IscrizioneIndiretta(ControllerGestoreClasse controller) {

        this.setContentPane(this.panel);

        this.setVisible(true);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("FAMEDucation - Iscrizione a classe");

        this.setSize(530, 250);

        iscrivitiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean datiValidi = false;

                if (!(codice_text.getText().length() == 8)) {

                    JOptionPane.showMessageDialog(new JFrame(), "La lunghezza del codice deve essere di 8 caratteri", "Errore inserimento codice", JOptionPane.ERROR_MESSAGE);

                } else {datiValidi = true;}

                /*
                if (!(codice_text.getText().matches(".*[^a-zA-Z0-9].*"))) {

                    JOptionPane.showMessageDialog(new JFrame(), "Il codice deve necessariamente contenere un carattere speciale", "Errore inserimento codice", JOptionPane.ERROR_MESSAGE);

                } else {datiValidi = true;}

                */


                if (datiValidi) {

                    int ret = controller.iscrizioneIndiretta(codice_text.getText(), controller.getEmail());

                    if (ret == 0) {

                        JOptionPane.showMessageDialog(new JFrame(), "L'iscrizione è avvenuta correttamente", "Iscrizione effettuata!", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(new JFrame(), "L'utente è già iscritto ad una classe", "Iscrizione non effettuata", JOptionPane.INFORMATION_MESSAGE);

                    }


                }

            }
        });
    }
}
