package Database;

import Entity.Ruolo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudenteDAO extends UtenteDAO {

    private String codiceUnivoco;

    public StudenteDAO(String email) {super(email); read();}

    public StudenteDAO() {super();}

    public String getCodiceUnivoco() {return codiceUnivoco;}

    public void setCodiceUnivoco(String codiceUnivoco) {this.codiceUnivoco = codiceUnivoco;}

    @Override
    public void read() {

        String query = "SELECT * FROM Studenti WHERE Email = '" + super.getEmail() + "';";

        try {

            ResultSet rs = DBManager.selectQuery(query);

            if (rs.next()) {

                this.setNome(rs.getString("Nome"));
                this.setCognome(rs.getString("Cognome"));
                this.setPassword(rs.getString("Password"));
                this.setRuolo(Ruolo.valueOf(rs.getString("Ruolo"))); //valueOf passa da stringa a enum
                this.setCodiceUnivoco(rs.getString("ClassiVirtuali_CodiceUnivoco"));
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }


    public int iscriviAClasse(String codiceUnivoco) {

        int ret = 0;

        String query = "UPDATE Studenti SET ClassiVirtuali_CodiceUnivoco = '"+ codiceUnivoco +
                "' WHERE Email = '"+ super.getEmail() +"';";

        try {

            DBManager.updateQuery(query);
            ret = 0;

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            ret = -1;

        }

        return ret;

    }

    public boolean controlloIscrizione (String email) {

        String query = "SELECT * FROM Studenti WHERE Email = '" + email + "' AND ClassiVirtuali_CodiceUnivoco IS NULL;";
        boolean bool = false;

        try {

            ResultSet rs = DBManager.selectQuery(query);

            if (rs.next()) {

                bool = true; //lo studente non è iscritto a nessuna classe

            } else {bool = false;}

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

        return bool;
    }

}
