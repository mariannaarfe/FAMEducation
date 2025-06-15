package Entity;
import java.util.ArrayList;
import java.util.List;

public class ClasseVirtualeEntity {

    private String nome;
    private String codiceUnivoco;
    private ArrayList<StudenteEntity> studenti;
    private DocenteEntity docente;
    private ArrayList<TaskEntity> task;

    public ClasseVirtualeEntity(String nome, String codiceUnivoco, DocenteEntity docente) {
        this.nome = nome;
        this.codiceUnivoco = codiceUnivoco;
        this.docente = docente;
        this.studenti = new ArrayList<>();
        this.task = new ArrayList<>();
    }

    public ClasseVirtualeEntity() {this.nome = ""; this.codiceUnivoco = ""; this.studenti = new ArrayList<>(); this.task = new ArrayList<>(); this.docente = null;}

    public ClasseVirtualeEntity(ClasseVirtualeEntity e) {this.nome = e.nome; this.codiceUnivoco = e.codiceUnivoco; this.studenti = e.studenti; this.task = e.task; this.docente = e.docente;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public ArrayList<StudenteEntity> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<StudenteEntity> studenti) {
        this.studenti = studenti;
    }

    public DocenteEntity getDocente() {
        return docente;
    }

    public void setDocente(DocenteEntity docente) {
        this.docente = docente;
    }

    public ArrayList<TaskEntity> getTask() {
        return task;
    }

    public void setTask(ArrayList<TaskEntity> task) {
        this.task = task;
    }

    //metodi non implementati:

    //public void iscrizioneDiretta (String email) {}

    //public void visualizzaTask (TaskEntity task) {}

    //public void monitoraAndamento () {}

}
