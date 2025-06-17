package Boundary;

import Controller.ControllerGestoreClasse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CreaTask extends JFrame {

    private JPanel panel;
    private JLabel titolo;
    private JTextField titolo_text;
    private JTextArea descr_text;
    private JComboBox anno;
    private JComboBox mese;
    private JComboBox giorno;
    private JTextField punteggio_text;
    private JButton creaButton;
    private JButton annullaButton;

    public CreaTask(Sessione sessioneCorrente) {

        this.setContentPane(this.panel);

        this.setVisible(true);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("FAMEDucation - Crea un Task");

        this.setSize(530, 320);

        ControllerGestoreClasse controller = ControllerGestoreClasse.getInstance();

        creaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LocalDate data;
                data = LocalDate.of(Integer.parseInt((String) anno.getSelectedItem()), Integer.parseInt((String) mese.getSelectedItem()), Integer.parseInt((String) giorno.getSelectedItem()));

                int ret = controlloDati(data);

                if (ret == 0) {

                    int controllo = controller.creaTask(titolo_text.getText(), descr_text.getText(), data, Integer.parseInt(punteggio_text.getText()), sessioneCorrente.getEmail());

                    if (controllo == 0) {

                        JOptionPane.showMessageDialog(new JFrame(), "Task creato correttamente", "Task creato", JOptionPane.WARNING_MESSAGE);
                        dispose();

                    } else {

                        JOptionPane.showMessageDialog(new JFrame(), "Errore creazione Task", "Task non creato", JOptionPane.ERROR_MESSAGE);

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

    public int controlloDati(LocalDate data) {

        int ret = 0;

        if (titolo_text.getText().length() == 0 || titolo_text.getText().length() > 50) {

            JOptionPane.showMessageDialog(new JFrame(), "La lunghezza del titolo deve essere compreso tra 1 e 50 caratteri", "Errore inserimento titolo", JOptionPane.ERROR_MESSAGE);
            ret = -1;

        }

        if (descr_text.getText().length() == 0 || descr_text.getText().length() > 150) {

            JOptionPane.showMessageDialog(new JFrame(), "La lunghezza della descrizione deve essere compreso tra 1 e 150 caratteri", "Errore inserimento descrizione", JOptionPane.ERROR_MESSAGE);
            ret = -1;

        }

        if (punteggio_text.getText().length() <= 0 || !(punteggio_text.getText().matches("\\d+"))) {

            JOptionPane.showMessageDialog(new JFrame(), "Il punteggio deve essere maggiore di 0 e non può contenere caratteri speciali o lettere", "Errore inserimento punteggio", JOptionPane.ERROR_MESSAGE);
            ret=-1;

        }


        if (data.isBefore(LocalDate.now())) {

            JOptionPane.showMessageDialog(new JFrame(), "La scadenza non può essere antecedente ad oggi", "Errore inserimento scadenza", JOptionPane.ERROR_MESSAGE);
            ret = -1;

        }

        return ret;

    }
}