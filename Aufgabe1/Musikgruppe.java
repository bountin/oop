/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aufgabe1;

import java.util.Date;

/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Musikgruppe {
    private Termincontainer termincontainer;
    private MitgliedContainer mitgliedcontainer;
    // pirvate Musikstueckcontainer musikstueckcontainer;
    
    private String name;
    private String ausrichtung;

    public Musikgruppe(String name, String ausrichtung) {
        this.name = name;
        this.ausrichtung = ausrichtung;
        this.termincontainer = new Termincontainer();
        this.mitgliedcontainer = new MitgliedContainer();
        //this.musikstueckcontainer = new Musikstueckcontainer();
    }

    public String getAusrichtung() {
        return ausrichtung;
    }

    public MitgliedContainer getMitgliedcontainer() {
        return mitgliedcontainer;
    }

    public String getName() {
        return name;
    }

    public Termincontainer getTermincontainer() {
        return termincontainer;
    }
    
   /* public Musikstueckcontainer getMusikstueckcontainer() {
        return musikstueckcontainer;
    }*/

    @Override
    public String toString() {
        return "Musikgruppe{" + "name=" + name + ", ausrichtung=" + ausrichtung + '}';
    } 
    
}
