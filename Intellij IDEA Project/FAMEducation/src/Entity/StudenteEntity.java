package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudenteEntity extends UtenteEntity{

    private List<ConsegnaEntity> consegne = new ArrayList<ConsegnaEntity>();
    private List<BadgeOttenutoEntity> badgeOttenuti = new ArrayList<>();

    public StudenteEntity(String nome, String cognome, String email, UtenteEntity.Ruolo ruolo, String password) {
        super(nome, cognome, email, ruolo, password);
    }

    public StudenteEntity() {
        super();
    }

    public StudenteEntity(UtenteEntity utenteEntity) {
        super(utenteEntity);
    }

    public List<ConsegnaEntity> getConsegne() {return consegne;}

    public void setConsegne(ConsegnaEntity consegna) {consegne.add(consegna);}

    public List<BadgeOttenutoEntity> getBadgeOttenuti() {return badgeOttenuti;}

    public void aggiungiBadge(BadgeEntity badge, LocalDate dataOttenimento) {badgeOttenuti.add(new BadgeOttenutoEntity(this, badge, dataOttenimento));}

    @Override
    public String toString() {return super.toString();}

    public void IscrizioneIndiretta (String codice) {}

    //metodi non implementati

    //public void VisualizzaProfilo () {}

    //public void ConsegnaTask () {}

}
