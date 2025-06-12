package Entity;

public class UtenteEntity {

    private String nome;
    private String cognome;
    private String email;

    public enum Ruolo {Docente, Studente};
    private Ruolo ruolo;

    private String password;

    //Costruttori

    public UtenteEntity(String nome, String cognome, String email, Ruolo ruolo, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
        this.password = password;
    }

    public UtenteEntity() {
        this.nome = "";
        this.cognome = "";
        this.email = "";
        this.ruolo = null;
        this.password = "";
    }

    public UtenteEntity(UtenteEntity utenteEntity) {
        this.nome = utenteEntity.nome;
        this.cognome = utenteEntity.cognome;
        this.email = utenteEntity.email;
        this.ruolo = utenteEntity.ruolo;
        this.password = utenteEntity.password;
    }

    //Getter e setter

    public String getNome() {return nome;}

    public String getCognome() {return cognome;}

    public String getEmail() {return email;}

    public Ruolo getRuolo() {return ruolo;}

    public String getPassword() {return password;}

    public void setNome(String nome) {this.nome = nome;}

    public void setCognome(String cognome) {this.cognome = cognome;}

    public void setEmail(String email) {this.email = email;}

    public void setRuolo(Ruolo ruolo) {this.ruolo = ruolo;}

    public void setPassword(String password) {this.password = password;}

    @Override
    public String toString() {
        return "UtenteEntity{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", ruolo=" + ruolo +
                ", password='" + password + '\'' +
                '}';
    }

    public void RegistraUtente (String nome, String cognome, String email, Ruolo ruolo, String password) {}

    public void Accesso (String nome, String cognome, String email, Ruolo ruolo, String password) {}

}
