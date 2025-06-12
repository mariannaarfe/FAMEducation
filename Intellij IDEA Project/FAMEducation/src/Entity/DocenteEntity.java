package Entity;

import java.util.ArrayList;
import java.util.List;

public class DocenteEntity extends UtenteEntity{

    private List<ClasseVirtualeEntity> classi = new ArrayList<>();

    public DocenteEntity(String nome, String cognome, String email, Ruolo ruolo, String password) {super(nome, cognome, email, ruolo, password);}

    public DocenteEntity() {super();}

    public DocenteEntity(UtenteEntity utenteEntity) {super(utenteEntity);}

    public List<ClasseVirtualeEntity> getClassi() {return classi;}

    public void aggiungiClasse(ClasseVirtualeEntity classe) {
        classi.add(classe);
    }

    @Override
    public String toString() {return super.toString();}

    //public String CreaClasse(String nome) {return codiceUnivico;}

    //public void CreaTask(String nome, String descrizione, LocalDate scadenza, int maxPuntiAssegnabili) {}

}
