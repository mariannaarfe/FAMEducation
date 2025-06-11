package Entity;

public class StudenteEntity extends UtenteEntity{

    public StudenteEntity(String nome, String cognome, String email, UtenteEntity.Ruolo ruolo, String password) {
        super(nome, cognome, email, ruolo, password);
    }

    public StudenteEntity() {
        super();
    }

    public StudenteEntity(UtenteEntity utenteEntity) {
        super(utenteEntity);
    }

    @Override
    public String toString() {return super.toString();}

    public void IscrizioneIndiretta (String codice) {}


    //metodi non implementati

    //public void VisualizzaProfilo () {}

    //public void ConsegnaTask () {}

}
