package Controller;

import Entity.*;

import java.time.LocalDate;

public class ControllerGestoreClasse {

    public void registraUtente (String nome, String cognome, String email, Ruolo ruolo, String password) {

        UtenteEntity nuovoUtente = new UtenteEntity(nome, cognome, email, ruolo, password);
        nuovoUtente.registraUtente(nome, cognome, email, ruolo, password);

    }

    public void iscrizioneIndiretta (String codiceUnivoco, String mail) { //la mail deve essere mantenuta in boundary

        StudenteEntity studente = new StudenteEntity();
        studente.setEmail(mail);
        studente.iscrizioneIndiretta(codiceUnivoco);

    }

    public void creaTask (String titolo, String descrizione, LocalDate scadenza, int maxPuntiAssegnabili, String email) {

        DocenteEntity docente = new DocenteEntity();
        docente.setEmail(email);
        docente.creaTask(titolo, descrizione, scadenza, maxPuntiAssegnabili);

    }





}
