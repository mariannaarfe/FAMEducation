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
    private DocenteEntity docente;
    private ArrayList<ConsegnaEntity> consegne;

    public TaskEntity(String titolo, String descrizione, LocalDate scadenza, int maxPuntiAssegnabili, DocenteEntity docente) {

        this.titolo = titolo;
        this.descrizione = descrizione;
        this.scadenza = scadenza;
        this.maxPuntiAssegnabili = maxPuntiAssegnabili;
        this.docente = docente;
        this.consegne = new ArrayList<>();
        this.classe = classe;

    }

    public TaskEntity() {

        this.titolo = "";
        this.descrizione = "";
        this.scadenza = null;
        this.maxPuntiAssegnabili = 0;
        this.docente = null;
        this.consegne = null;
        this.classe = null;

    }

    public TaskEntity(TaskEntity taskEntity) {

        this.titolo = taskEntity.titolo;
        this.descrizione = taskEntity.descrizione;
        this.scadenza = taskEntity.scadenza;
        this.maxPuntiAssegnabili = taskEntity.maxPuntiAssegnabili;
        this.docente = taskEntity.docente;
        this.consegne = taskEntity.consegne;
        this.classe = taskEntity.classe;

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public int getMaxPuntiAssegnabili() {
        return maxPuntiAssegnabili;
    }

    public void setMaxPuntiAssegnabili(int maxPuntiAssegnabili) {
        this.maxPuntiAssegnabili = maxPuntiAssegnabili;
    }

    public ClasseVirtualeEntity getClasse() {
        return classe;
    }

    public void setClasse(ClasseVirtualeEntity classe) {
        this.classe = classe;
    }

    public DocenteEntity getDocente() {
        return docente;
    }

    public void setDocente(DocenteEntity docente) {
        this.docente = docente;
    }

    public ArrayList<ConsegnaEntity> getConsegne() {
        return consegne;
    }

    public void setConsegne(ArrayList<ConsegnaEntity> consegne) {
        this.consegne = consegne;
    }

    //metodi non implementati:

    //public void AssegnaTask (TaskEntity t) {}



}
