package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskEntity {

    private String titolo;
    private String descrizione;
    private LocalDate scadenza;
    private int maxPuntiAssegnabili;
    private ClasseVirtualeEntity classe;
    private List<TaskEntity> task = new ArrayList<>();

    public TaskEntity(String titolo, String descrizione, LocalDate scadenza, int maxPuntiAssegnabili) {

        this.titolo = titolo;
        this.descrizione = descrizione;
        this.scadenza = scadenza;
        this.maxPuntiAssegnabili = maxPuntiAssegnabili;

    }

    public TaskEntity() {

        this.titolo = "";
        this.descrizione = "";
        this.scadenza = null;
        this.maxPuntiAssegnabili = 0;

    }

    public TaskEntity(TaskEntity taskEntity) {

        this.titolo = taskEntity.titolo;
        this.descrizione = taskEntity.descrizione;
        this.scadenza = taskEntity.scadenza;
        this.maxPuntiAssegnabili = taskEntity.maxPuntiAssegnabili;

    }

    public String getTitolo() {return titolo;}

    public void setTitolo(String titolo) {this.titolo = titolo;}

    public String getDescrizione() {return descrizione;}

    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

    public LocalDate getScadenza() {return scadenza;}

    public void setScadenza(LocalDate scadenza) {this.scadenza = scadenza;}

    public int getMaxPuntiAssegnabili() {return maxPuntiAssegnabili;}

    public void setMaxPuntiAssegnabili(int maxPuntiAssegnabili) {this.maxPuntiAssegnabili = maxPuntiAssegnabili;}

    public ClasseVirtualeEntity getClasse() {return classe;}

    public void setClasse(ClasseVirtualeEntity classe) {this.classe = classe;}

    public List<TaskEntity> getTask() {return task;}

    public void setTask(TaskEntity task) {this.task.add(task);}
}
