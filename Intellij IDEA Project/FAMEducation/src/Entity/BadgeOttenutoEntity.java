package Entity;

import java.time.LocalDate;



public class BadgeOttenutoEntity {

    private StudenteEntity studente;
    private BadgeEntity badge;
    private LocalDate dataOttenimento;

    public BadgeOttenutoEntity(StudenteEntity studente, BadgeEntity badge, LocalDate dataOttenimento) {
        this.studente = studente;
        this.badge = badge;
        this.dataOttenimento = dataOttenimento;
    }

    public LocalDate getDataOttenimento() {
        return dataOttenimento;
    }

    public void setDataOttenimento(LocalDate dataOttenimento) {
        this.dataOttenimento = dataOttenimento;
    }

    public StudenteEntity getStudente() {
        return studente;
    }

    public void setStudente(StudenteEntity studente) {
        this.studente = studente;
    }

    public BadgeEntity getBadge() {
        return badge;
    }

    public void setBadge(BadgeEntity badge) {
        this.badge = badge;
    }

}
