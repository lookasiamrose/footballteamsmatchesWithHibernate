/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author lukasz.jamroz
 */
@Entity
@Table(name="OSOBY")
public class Osoba implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Osoba() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID_OSOBY")
    private int id;
    @Column(name = "IMIE")
    private String imie;
    @Column(name = "NAZWISKO")
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

}
