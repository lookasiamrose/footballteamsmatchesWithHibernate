/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
/**
 *
 * @author lukasz.jamroz
 */
@Entity
@Table(name="POZYCJE")
public class Pozycja implements Serializable {

    @ManyToMany
    private List<Mecz> meczs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pozycja(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Pozycja(int id) {
        this.id = id;
    }

    public Pozycja(String nazwa) {
        this.nazwa = nazwa;
    }

    public Pozycja() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "ID_POZYCJI")
    private int id;
    @Column(name = "NAZWA")
    private String nazwa;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_ZAWODNIKA", foreignKey = @javax.persistence.ForeignKey(name = "ID_OSOBY"))
    private Zawodnik zawodnik;
    @ManyToOne
    private Mecz mecz;

    public Mecz getMecz() {
        return mecz;
    }

    public void setMecz(Mecz mecz) {
        this.mecz = mecz;
    }

    public Zawodnik getZawodnik() {
        return zawodnik;
    }

    public void setZawodnik(Zawodnik zawodnik) {
        this.zawodnik = zawodnik;
    }
    
}
