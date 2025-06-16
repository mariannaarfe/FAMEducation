package Entity;

import java.util.ArrayList;
import java.util.List;

public class BadgeEntity {

    private String nome;
    private String descrizione;
    private String immagine;

    public BadgeEntity(String nome, String descrizione, String immagine) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.immagine = immagine;
    }

    public BadgeEntity() {
        this.nome = "";
        this.descrizione = "";
        this.immagine = "";
    }

    public BadgeEntity (BadgeEntity badgeEntity) {
        this.nome = badgeEntity.nome;
        this.descrizione = badgeEntity.descrizione;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getDescrizione() {return descrizione;}

    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

    public String getImmagine() {return immagine;}

    public void setImmagine(String immagine) {this.immagine = immagine;}

}