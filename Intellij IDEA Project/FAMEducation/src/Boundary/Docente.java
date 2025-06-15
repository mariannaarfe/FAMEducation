package Boundary;

import Controller.ControllerGestoreClasse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Docente extends JFrame {
    private JPanel panel;
    private JLabel titolo_finestra;
    private JLabel label2;
    private JButton creaUnTaskButton;
    private JButton creaUnaClasseButton;
    private JButton iscriviUnoStudenteButton;
    private JButton valutaUnaConsegnaButton;
    private JButton assegnaUnTaskButton;
    private JButton monitoraAndamentoButton;

    private ControllerGestoreClasse controller;


    public Docente(ControllerGestoreClasse controller) {

        this.controller = controller;

        this.setContentPane(this.panel);

        this.setVisible(true);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("FAMEDucation - Portale Docenti");

        this.setSize(530, 350);

        this.label2.setText(("Ciao, "+controller.getNome()+"!"));

        creaUnTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new CreaTask(controller);

            }
        });
    }
}
