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
 * @author regina.gialbas
 */
@Entity
@Table(name="RODZAJSTATYSTYKI")
public class RodzajStatystyki implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RodzajStatystyki(int id, String opis) {
        this.id = id;
        this.opis = opis;
    }

    public RodzajStatystyki() {
    }

    public RodzajStatystyki(int id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public RodzajStatystyki(String opis) {
        this.opis = opis;
    }
    @Id
    @GeneratedValue
    @Column(name = "ID_RODZAJUSTATYSTYKI")
    private int id;
    @Column(name = "OPIS")
    private String opis;
    
}
