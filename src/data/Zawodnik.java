/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.persistence.*;

/**
 *
 * @author lukasz.jamroz
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Zawodnik extends Osoba {

    public Zawodnik(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public Zawodnik() {
    }

    @ManyToOne
    private Druzyna druzyna;
    @ManyToOne
    private Pozycja pozycja;

    public Pozycja getPozycja() {
        return pozycja;
    }

    public void setPozycja(Pozycja pozycja) {
        this.pozycja = pozycja;
    }

    public Druzyna getDruzyna() {
        return druzyna;
    }

    public void setDruzyna(Druzyna druzyna) {
        this.druzyna = druzyna;
    }
}
