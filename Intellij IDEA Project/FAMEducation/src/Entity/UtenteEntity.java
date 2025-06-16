package Entity;

import Database.UtenteDAO;

public class UtenteEntity {

    private String nome;
    private String cognome;
    private String email;
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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public int registraUtente (String nome, String cognome, String email, Ruolo ruolo, String password) {

        int ret = 0;

        UtenteDAO nuovoUtente = new UtenteDAO();

        if (nuovoUtente.utenteEsistente(email) == true) {

            ret = -1;
            System.out.println("L'utente esiste già!");

        } else {

            int controllo = nuovoUtente.write(email, nome, cognome, ruolo, password);

            if (controllo == 0) {

                ret = 0;
                System.out.println("L'utente è stato registrato!");

            } else {

                ret = -2;

            }

        }

        return ret;

    }

    //public void accesso (String nome, String cognome, String email, Ruolo ruolo, String password) {}

}