package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TaskDAO {

    private String titolo;
    private String descrizione;
    private LocalDate scadenza;
    private int maxPuntiAssegnabili;
    private String codiceUnivoco;

    public TaskDAO(String titolo, String descrizione, LocalDate scadenza, int maxPuntiAssegnabili, String codiceUnivoco) {
        this.titolo = titolo;
        this.codiceUnivoco = codiceUnivoco;
        read();
    }

    public TaskDAO() {super();}

    public String getTitolo() {return titolo;}

    public void setTitolo(String titolo) {this.titolo = titolo;}

    public String getDescrizione() {return descrizione;}

    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

    public LocalDate getScadenza() {return scadenza;}

    public void setScadenza(LocalDate scadenza) {this.scadenza = scadenza;}

    public int getMaxPuntiAssegnabili() {return maxPuntiAssegnabili;}

    public void setMaxPuntiAssegnabili(int maxPuntiAssegnabili) {this.maxPuntiAssegnabili = maxPuntiAssegnabili;}

    public String getCodiceUnivoco() {return codiceUnivoco;}

    public void setCodiceUnivoco(String codiceUnivoco) {this.codiceUnivoco = codiceUnivoco;}

    public void read() {

        String query = "SELECT * FROM Task WHERE ClassiVirtuali_CodiceUnivoco = '" + this.codiceUnivoco + "' AND Titolo = '"+this.titolo+"';";

        try {

            ResultSet rs = DBManager.selectQuery(query);

            if (rs.next()) {

                this.setDescrizione(rs.getString("Descrizione"));
                this.setMaxPuntiAssegnabili(rs.getInt("MaxPuntiAssegnabili"));
                java.sql.Date date = rs.getDate("Scadenza");
                this.setScadenza(date.toLocalDate());

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }

    public int write() {

        int ret = 0;

        String query = "INSERT INTO Task VALUES (" + this.titolo + ", " + this.descrizione + ", " + this.scadenza +", " + this.maxPuntiAssegnabili +");";

        try {

            ret = DBManager.updateQuery(query);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            ret = -1;

        }

        return ret;

    }


}
