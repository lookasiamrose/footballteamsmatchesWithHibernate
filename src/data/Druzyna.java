/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author lukasz.jamroz
 */
@Entity
@Table(name="DRUZYNY")
public class Druzyna implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_DRUZYNY")
    private int id;
    @Column(name = "KRAJ")
    private String kraj;

    
    
    @ManyToMany
    private Set<Mecz> mecz = new HashSet<>(500);

    @OneToMany(mappedBy = "druzyna")
    private Set<Zawodnik> zawodnicy = new HashSet<>(50);

    @OneToOne
    private Trener trener;

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public Druzyna(String kraj) {
        this.kraj = kraj;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Druzyna(int id, String kraj) {
        this.id = id;
        this.kraj = kraj;
    }

    public Druzyna() {
    }
    public Trener getTrener() {
        return trener;
    }

    public Set<Zawodnik> getZawodnicy() {
        return zawodnicy;
    }

    public void setZawodnicy(Set<Zawodnik> zawodnicy) {
        this.zawodnicy = zawodnicy;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Set<Mecz> getMecz() {
        return mecz;
    }

    public void setMecz(Set<Mecz> mecze) {
        this.mecz = mecze;
    }
    
}
