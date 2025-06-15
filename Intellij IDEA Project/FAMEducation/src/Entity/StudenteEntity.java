package Entity;

import Database.StudenteDAO;

import java.util.ArrayList;

public class StudenteEntity extends UtenteEntity{

    private ArrayList<ConsegnaEntity> consegne;
    private BadgeOttenutoEntity badgeOttenuto;

    public StudenteEntity(String nome, String cognome, String email, Ruolo ruolo, String password) {
        super(nome, cognome, email, ruolo, password);
        this.consegne = new ArrayList<>();
    }

    public StudenteEntity() {
        super();
        this.consegne = new ArrayList<>();
    }

    public StudenteEntity(StudenteEntity e) {
        super(e);
        this.consegne = e.consegne;
    }

    public ArrayList<ConsegnaEntity> getConsegne() {
        return consegne;
    }

    public void setConsegne(ArrayList<ConsegnaEntity> consegne) {
        this.consegne = consegne;
    }

    public BadgeOttenutoEntity getBadgeOttenuto() {
        return badgeOttenuto;
    }

    public void setBadgeOttenuto(BadgeOttenutoEntity badgeOttenuto) {
        this.badgeOttenuto = badgeOttenuto;
    }

    @Override
    public String toString() {return super.toString();}

    public int iscrizioneIndiretta (String codice) {

        int ret = 0;

        StudenteDAO studenteDAO = new StudenteDAO(super.getEmail());

        if (studenteDAO.controlloIscrizione(studenteDAO.getEmail())) {

            int controllo = studenteDAO.iscriviAClasse(codice);

            if (controllo == 0) {

                ret = 0;

            } else {ret = -2;}

        } else {

            System.out.println("Studente già iscritto ad una classe.");
            ret=-1;

        }

        return ret;

    }

    //metodi non implementati

    //public void visualizzaProfilo () {}

    public void consegnaTask (ConsegnaEntity consegna) {
        this.consegne.add(consegna);

        //la restante parte, compresa di gestione della pertinenza con il database, non è implementata
    }

}
