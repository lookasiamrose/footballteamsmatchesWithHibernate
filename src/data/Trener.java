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
@Inheritance(strategy=InheritanceType.JOINED)
public class Trener extends Osoba implements Serializable {

    public Trener() {
    }

    public Trener(String imie, String nazwisko) {
        super(imie, nazwisko);
    }


    @OneToOne(mappedBy = "trener")
    private Druzyna druzyna;

    public Druzyna getDruzyna() {
        return druzyna;
    }

    public void setDruzyna(Druzyna druzyna) {
        this.druzyna = druzyna;
    }
}
