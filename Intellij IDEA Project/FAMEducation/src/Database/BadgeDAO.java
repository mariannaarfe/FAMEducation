package Database;
import java.sql.SQLException;

public class BadgeDAO {
    private String nome;
    private String descrizione;
    private String immagine;
    private String traguardo;

    //Metodi di GET/SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getTraguardo() {
        return traguardo;
    }

    public void setTraguardo(String traguardo) {
        this.traguardo = traguardo;
    }

    //toString

    @Override
    public String toString() {
        return super.toString();
    }


    //Metodi specifici
    //Creazione di un nuovo badge
    //Lettura di tutti i badge
    //Aggiornamento di un bage esistente
    //Eliminazione di un bage


}
