package Entity;

import java.util.Date;

public class DocenteEntity extends UtenteEntity{

    public DocenteEntity(String nome, String cognome, String email, Ruolo ruolo, String password) {
        super(nome, cognome, email, ruolo, password);
    }

    public DocenteEntity() {
        super();
    }

    public DocenteEntity(UtenteEntity utenteEntity) {
        super(utenteEntity);
    }

    @Override
    public String toString() {return super.toString();}

    //public String CreaClasse(String nome) {return codiceUnivico;}

    //public void CreaTask(String nome, String descrizione, Date scadenza, int maxPuntiAssegnabili) {}

}
