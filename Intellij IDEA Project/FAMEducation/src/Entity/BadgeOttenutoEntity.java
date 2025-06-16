package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BadgeOttenutoEntity {

    private final StudenteEntity studente;
    private final BadgeEntity badge;
    private final LocalDate dataOttenimento;

    public BadgeOttenutoEntity(StudenteEntity studente, BadgeEntity badge, LocalDate dataOttenimento) {
        this.studente = studente;
        this.badge = badge;
        this.dataOttenimento = dataOttenimento;
    }

    public LocalDate getDataOttenimento() {return dataOttenimento;}

    public StudenteEntity getStudente() {return studente;}

    public BadgeEntity getBadge() {return badge;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BadgeOttenutoEntity that)) return false;
        return Objects.equals(studente, that.studente) && Objects.equals(badge, that.badge) && Objects.equals(dataOttenimento, that.dataOttenimento);
    }

    @Override
    public int hashCode() {return Objects.hash(studente, badge, dataOttenimento);}

}