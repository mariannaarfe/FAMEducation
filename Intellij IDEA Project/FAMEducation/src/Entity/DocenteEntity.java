package Entity;

import Database.TaskDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DocenteEntity extends UtenteEntity{

    private ArrayList<ClasseVirtualeEntity> classi;
    private ArrayList<TaskEntity> task;

    public DocenteEntity(String nome, String cognome, String email, Ruolo ruolo, String password) {
        super(nome, cognome, email, ruolo, password);
        this.classi = new ArrayList<>();
        this.task = new ArrayList<>();
    }

    public DocenteEntity() {super(); this.classi = null; this.task = null;}

    public DocenteEntity(DocenteEntity docente) {

        super(docente);
        this.classi = docente.classi;
        this.task = docente.task;

    }

    public ArrayList<ClasseVirtualeEntity> getClassi() {
        return classi;
    }

    public void setClassi(ArrayList<ClasseVirtualeEntity> classi) {
        this.classi = classi;
    }

    public ArrayList<TaskEntity> getTask() {
        return task;
    }

    public void setTask(ArrayList<TaskEntity> task) {
        this.task = task;
    }



    @Override
    public String toString() {return super.toString();}

    public void creaTask(String titolo, String descrizione, LocalDate scadenza, int maxPuntiAssegnabili) {

        TaskDAO nuovoTask = new TaskDAO();

        nuovoTask.write(titolo, super.getEmail(), descrizione, scadenza, maxPuntiAssegnabili);

    }


    //metodi non implementati:

    //public String creaClasse(String nome) {}


}
