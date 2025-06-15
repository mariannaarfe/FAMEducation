package Boundary;

import Controller.ControllerGestoreClasse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Studente extends JFrame{
    private JPanel panel;
    private JLabel titolo_finestra;
    private JLabel label2;
    private JButton iscriviAClasseButton;
    private JButton visualizzaIlTuoProfiloButton;
    private JButton visualizzaITuoiTaskButton;
    private JButton consegnaUnTaskButton;

    private ControllerGestoreClasse controller;

    public Studente(ControllerGestoreClasse controller) {

        this.setContentPane(this.panel);

        this.setVisible(true);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("FAMEDucation - Portale Studenti");

        this.setSize(530, 350);

        this.label2.setText(("Ciao, "+controller.getNome()+"!"));

        iscriviAClasseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new IscrizioneIndiretta(controller);

            }
        });
    }



}
