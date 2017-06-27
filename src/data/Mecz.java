/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author lukasz.jamroz
 */
@Entity
@Table(name="MECZ")
public class Mecz implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_MECZU")
    private int id;
    @Column(name = "TERMIN")
    private GregorianCalendar termin;
    @ManyToOne
    private Stadion stadion;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_MECZU")
    private Set<Statystyki> statystyki = new HashSet<>(6);
    
    
    @ManyToMany(mappedBy = "mecz")
    private Set<Druzyna> druzyny = new HashSet<>(2);
    
    @ManyToMany(mappedBy = "meczs")
    private Set<Pozycja> pozycje = new HashSet<>(11);


    public Set<Druzyna> getDruzyny() {
        return druzyny;
    }

    public void setDruzyny(Set<Druzyna> druzyny) {
        this.druzyny = druzyny;
    }
    
    public Mecz() {
    }

    public Set<Statystyki> getStatystyki() {
        return statystyki;
    }

    public void setStatystyki(Set<Statystyki> statystyki) {
        this.statystyki = statystyki;
    }

    public Mecz(int id) {
        this.id = id;
    }

    public Mecz(int id, GregorianCalendar termn) {
        this.id = id;
        this.termin = termn;
    }

    public Mecz(GregorianCalendar termn) {
        this.termin = termn;
    }


    public GregorianCalendar getTermin() {
        return termin;
    }

    public void setTermin(GregorianCalendar termin) {
        this.termin = termin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stadion getStadion() {
        return stadion;
    }

    public void setStadion(Stadion stadion) {
        this.stadion = stadion;
    }

    public Set<Pozycja> getPozycje() {
        return pozycje;
    }

    public void setPozycje(Set<Pozycja> pozycje) {
        this.pozycje = pozycje;
    }
    
}
