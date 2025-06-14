package Database;

import Entity.DocenteEntity;
import Entity.StudenteEntity;
import Entity.TaskEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseVirtualeDAO {

    private String nome;
    private String codiceUnivoco;

    public ClasseVirtualeDAO(String codiceUnivoco) {

        this.codiceUnivoco = codiceUnivoco;


    }

    public ClasseVirtualeDAO() {super ();}

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

}
