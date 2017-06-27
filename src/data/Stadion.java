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
@Table(name="STADIONY")
public class Stadion implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public Stadion(int id) {
        this.id = id;
    }

    public Stadion(String nazwa, String lokalizacja) {
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
    }

    public Stadion(int id, String nazwa, String lokalizacja) {
        this.id = id;
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
    }

    public Stadion() {
    }
    @Id
    @GeneratedValue
    @Column(name = "ID_STADIONU")
    private int id;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "LOKALIZACJA")
    private String lokalizacja;
    
}