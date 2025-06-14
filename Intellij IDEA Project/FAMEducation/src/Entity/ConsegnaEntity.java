package Entity;

public class ConsegnaEntity {

    private String soluzione;
    private int punteggio;
    private TaskEntity task;
    private StudenteEntity studente;

    public ConsegnaEntity(String soluzione, int punteggio, StudenteEntity studente, TaskEntity task) {
        this.soluzione = soluzione;
        this.punteggio = punteggio;
        this.studente = studente;
        this.task = task;
    }

    public ConsegnaEntity() {

        this.soluzione = "";
        this.punteggio = 0;
        this.studente = null;
        this.task = null;

    }

    public ConsegnaEntity(ConsegnaEntity consegnaEntity) {

        this.soluzione = consegnaEntity.soluzione;
        this.punteggio = consegnaEntity.punteggio;
        this.studente = consegnaEntity.studente;
        this.task = consegnaEntity.task;

    }

    public String getSoluzione() {
        return soluzione;
    }

    public void setSoluzione(String soluzione) {
        this.soluzione = soluzione;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public StudenteEntity getStudente() {
        return studente;
    }

    public void setStudente(StudenteEntity studente) {
        this.studente = studente;
    }

    //public void valutaConsegna () {}

}
