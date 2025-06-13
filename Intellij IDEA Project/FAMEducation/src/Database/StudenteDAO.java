package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudenteDAO extends UtenteDAO {

    private String codiceUnivoco;

    public StudenteDAO(String email) {super(email);}

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
                this.setEmail(rs.getString("ClassiVirtuali_CodiceUnivoco"));
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public int write(String email) {

        int ret = 0;

        String query = "UPDATE Studenti SET ClassiVirtuali_CodiceUnivoco = '"+ this.codiceUnivoco +
                "' WHERE Email = '"+ email +"';";

        try {

            ret = DBManager.updateQuery(query);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            ret = -1;

        }

        return ret;

    }

}
