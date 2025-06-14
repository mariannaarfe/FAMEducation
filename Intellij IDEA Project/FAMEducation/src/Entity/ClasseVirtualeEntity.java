package Entity;
import java.util.ArrayList;
import java.util.List;

public class ClasseVirtualeEntity {

    private String nome;
    private String codiceUnivoco;
    private List<StudenteEntity> studenti = new ArrayList<>();
    private DocenteEntity docente;
    private List<TaskEntity> task = new ArrayList<>();

    public ClasseVirtualeEntity(String nome, String codiceUnivoco) {
        this.nome = nome;
        this.codiceUnivoco = codiceUnivoco;
    }

    public ClasseVirtualeEntity() {this.nome = ""; this.codiceUnivoco = "";}

    public ClasseVirtualeEntity(ClasseVirtualeEntity e) {this.nome = e.nome; this.codiceUnivoco = e.codiceUnivoco;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCodiceUnivoco() {return codiceUnivoco;}

    public void setCodiceUnivoco(String codiceUnivoco) {this.codiceUnivoco = codiceUnivoco;}

    public void IscrizioneDiretta (String email) {}

    public void aggiungiStudente(StudenteEntity studente) {studenti.add(studente);}

    public List<StudenteEntity> getStudenti() {return studenti;}

    public DocenteEntity getDocente() {return docente;}

    public void setDocente(DocenteEntity docente) {this.docente = docente;}

    public List<TaskEntity> getTask() {return task;}

    public void setTask(TaskEntity task) {this.task.add(task);}

    //public void visualizzaTask (TaskEntity task) {}

    //public void monitoraAndamento () {}

}
