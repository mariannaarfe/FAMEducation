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
    private List<StudenteEntity> studenti = new ArrayList<>();
    private DocenteEntity docente;
    private List<TaskEntity> task = new ArrayList<>();

    public ClasseVirtualeDAO(String codiceUnivoco) {

        this.codiceUnivoco = codiceUnivoco;
        read();

    }

    public ClasseVirtualeDAO() {super ();}

    public void read() {

        String query = "SELECT * FROM ClassiVirtuali WHERE CodiceUnivoco = '" + codiceUnivoco + "'";

        try {

            ResultSet rs = DBManager.selectQuery(query);

            if (rs.next()) {

                this.nome = rs.getString("nome");

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }
/*
    public int write(String email) {

        int ret = 0;

        //String query = "INSERT INTO ClassiVirtuali VALUES (\'"+codiceUnivoco+"\', \\'\"+nome+\"\\', \\'\"+cognome+\"\\', \\'\"+password+\"\\', \\'\"+ruolo+\"\\')";

        try {

            if (ruolo == UtenteDAO.Ruolo.Docente) {

                ret = DBManager.updateQuery(queryDocenti);

            } else {

                ret = DBManager.updateQuery(queryStudenti);

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            ret = -1;

        }

        return ret;

    }
*/
}
