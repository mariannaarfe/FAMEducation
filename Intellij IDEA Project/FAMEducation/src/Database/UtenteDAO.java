package Database;

import Entity.Ruolo;
import Entity.UtenteEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.String.valueOf;

public class UtenteDAO {

    private String nome;
    private String cognome;
    private String email;
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

        String query = "SELECT Email, Nome, Cognome, Ruolo, Password FROM Studenti WHERE Email = '" + this.email + "' UNION SELECT Email, Nome, Cognome, Ruolo, Password  FROM Docenti WHERE Email = '" + this.email + "';";

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

    public int write(String email, String nome, String cognome, Ruolo ruolo, String password) {

        int ret = 0;

        String queryStudenti = "INSERT INTO Studenti (Email, Nome, Cognome, Password, Ruolo) VALUES ('" + email + "', '" + nome + "', '" + cognome +"', '" + password +"', '"+ ruolo+"');";
        String queryDocenti = "INSERT INTO Docenti (Email, Nome, Cognome, Ruolo, Password) VALUES ('" + email + "', '" + nome + "', '" + cognome +"', '" + ruolo +"', '"+ password+"');";

        try {

            if (ruolo == Ruolo.Docente) {

                DBManager.updateQuery(queryDocenti);
                ret = 0;

            } else {

                DBManager.updateQuery(queryStudenti);
                ret = 0;

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            ret = -1;

        }

        return ret;

    }

    public boolean utenteEsistente(String email) {

        String query1 = "SELECT COUNT(*) FROM Studenti WHERE Email = '" + email + "';";
        String query2 = "SELECT COUNT(*) FROM Docenti WHERE Email = '" + email + "';";
        boolean bool = false;
        int risultato = 0;

        try {

            ResultSet rs = DBManager.selectQuery(query1);

            if (rs.next()) {

                risultato += rs.getInt(1);

            }

            rs = DBManager.selectQuery(query2);

            if (rs.next()) {

                risultato += rs.getInt(1);

            }

            if(risultato > 0){
                bool = true;
            } else {
                bool = false;
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

        return bool;

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