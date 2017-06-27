/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author lukasz.jamroz
 */
@Entity
@Table(name="STATYSTYKI")
public class Statystyki implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public Statystyki() {
    }

    public Statystyki(int wartosc) {
        this.wartosc = wartosc;
    }

    public Statystyki(int id, int wartosc) {
        this.id = id;
        this.wartosc = wartosc;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID_STATYSTYKI")
    private int id;
    @Column(name = "WARTOSC")
    private int wartosc;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_RODZAJUSTATYSTYKI", foreignKey = @javax.persistence.ForeignKey(name = "FK_RODZAJUSTATYSTYKI_AD"))
    private RodzajStatystyki rodzajStatystyki;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_MECZU", foreignKey = @javax.persistence.ForeignKey(name = "ID_MECZU"))
    private Mecz mecz;

    public Mecz getMecz() {
        return mecz;
    }

    public void setMecz(Mecz mecz) {
        this.mecz = mecz;
    }

    public RodzajStatystyki getRodzajStatystyki() {
        return rodzajStatystyki;
    }

    public void setRodzajStatystyki(RodzajStatystyki rodzajStatystyki) {
        this.rodzajStatystyki = rodzajStatystyki;
    }
    
}
