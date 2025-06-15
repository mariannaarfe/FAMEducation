package Controller;

import Entity.*;

import java.time.LocalDate;

public class ControllerGestoreClasse {

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int registraUtente (String nome, String cognome, String email, Ruolo ruolo, String password) {

        UtenteEntity nuovoUtente = new UtenteEntity(nome, cognome, email, ruolo, password);
        return nuovoUtente.registraUtente(nome, cognome, email, ruolo, password);

    }

    public int iscrizioneIndiretta (String codiceUnivoco, String mail) { //la mail deve essere mantenuta in boundary

        StudenteEntity studente = new StudenteEntity();
        studente.setEmail(mail);
        return studente.iscrizioneIndiretta(codiceUnivoco);

    }

    public int creaTask (String titolo, String descrizione, LocalDate scadenza, int maxPuntiAssegnabili, String email) {

        DocenteEntity docente = new DocenteEntity();
        docente.setEmail(email);
        return docente.creaTask(titolo, descrizione, scadenza, maxPuntiAssegnabili);

    }





}
