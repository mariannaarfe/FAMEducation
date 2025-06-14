package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.String.valueOf;

public class UtenteDAO {

    private String nome;
    private String cognome;
    private String email;
    public enum Ruolo {Docente, Studente};
    private Ruolo ruolo;
    private String password;

    public UtenteDAO(String email) {this.email = email; read();}

    public UtenteDAO() {super();}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCognome() {return cognome;}

    public void setCognome(String cognome) {this.cognome = cognome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Ruolo getRuolo() {return ruolo;}

    public void setRuolo(Ruolo ruolo) {this.ruolo = ruolo;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public void read () {

        String query = "SELECT Email, Nome, Cognome, Ruolo, Password FROM Studenti WHERE Email = '" + email + "' UNION SELECT Email, Nome, Cognome, Ruolo, Password  FROM Docenti WHERE Email = '" + email + "';";

        try {

            ResultSet rs = DBManager.selectQuery(query);

            if (rs.next()) {

                this.setNome(rs.getString("Nome"));
                this.setCognome(rs.getString("Cognome"));
                this.setPassword(rs.getString("Password"));
                this.setRuolo(Ruolo.valueOf(rs.getString("Ruolo"))); //valueOf passa da stringa a enum

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }

    public int write(String email) {

        int ret = 0;

        String queryStudenti = "INSERT INTO Studenti VALUES (" + this.email + ", " + this.nome + ", " + this.cognome +", " + this.password +", "+ this.ruolo+");";
        String queryDocenti = "INSERT INTO Docenti VALUES (" + this.email + ", " + this.nome + ", " + this.cognome +", " + this.ruolo +", "+ this.password+");";

        try {

            if (this.ruolo == Ruolo.Docente) {

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

    @Override
    public String toString() {
        return "UtenteDAO{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", ruolo=" + ruolo +
                ", password='" + password + '\'' +
                '}';
    }

}
