package Entity;

public class ClasseVirtualeEntity {

    private String nome;
    private String codiceUnivoco;
    private StudenteEntity studenti [];

    public ClasseVirtualeEntity(String nome, String codiceUnivoco, StudenteEntity [] studenti) {this.nome = nome; this.codiceUnivoco = codiceUnivoco;}

    public ClasseVirtualeEntity() {this.nome = ""; this.codiceUnivoco = "";}

    public ClasseVirtualeEntity(ClasseVirtualeEntity e) {this.nome = e.nome; this.codiceUnivoco = e.codiceUnivoco;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCodiceUnivoco() {return codiceUnivoco;}

    public void setCodiceUnivoco(String codiceUnivoco) {this.codiceUnivoco = codiceUnivoco;}
}
