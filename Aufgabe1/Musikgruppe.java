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
    private Mitgliedcontainer mitgliedcontainer;
    // pirvate Musikstueckcontainer musikstueckcontainer;
    
    private String name;
    private String ausrichtung;

    public Musikgruppe(String name, String ausrichtung) {
        this.name = name;
        this.ausrichtung = ausrichtung;
        this.termincontainer = new Termincontainer();
        this.mitgliedcontainer = new Mitgliedcontainer();
        //this.musikstueckcontainer = new Musikstueckcontainer();
    }

    public String getAusrichtung() {
        return ausrichtung;
    }

    public Mitgliedcontainer getMitgliedcontainer() {
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
    
    /**
	 * <p>Gibt eine formattierte, unsortierte Liste aller Mitglieder zum angegebenen Zeitpunkt
	 * auf dem Standardoutput zur�ck</p>
	 * 
	 * @param date das Datum, zu welchem die Mitglieder ausgegeben werden sollen
	 */
    public void printLineup(Date date){
    	System.out.println(lineup.printMitgliederAt(date));
    }
    
    /**
	 * <p> F�gt ein aktives Mitglied hinzu, falls nicht bereits ein aktives Mitglied
	 * mit diesem Namen existiert</p>
	 * 
	 * <p> Gibt es bereits ein aktives Mitglied mit diesem Namen wird eine entsprechende
	 * Meldung auf dem Standardoutput ausgegeben</p>
	 * 
	 * @param String name
	 * @param long telnum
	 * @param String instrument
     */
    public void addMitglied(String name, long telnum, String instrument){
    	lineup.addMitglied(name,telnum,instrument);
    }
    
	/**
	 * <p> Sucht nach einem aktiven Mitglied mit dem gegebenen Namen 
	 * und setzt das Austrittsdatum auf das aktuelle Datum</p>
	 * 
	 * <p> Gibt es kein aktives Mitglied mit diesem Namen wird eine entsprechende
	 * Meldung auf dem Standardoutput ausgegeben</p>
	 * 
	 * @param String name: der Name des zu entfernenden Mitglieds
	 */
    public void removeMitglied(String name){
    	lineup.removeMitglied(name);
    }
        
    public MitgliedContainer getLineup() {
		return lineup;
	}

	public void setLineup(MitgliedContainer lineup) {
		this.lineup = lineup;
	}

    /* 
     * -----------------------------------------------------------
     * ENDE: Methoden f�r das Lineup (MitgliedContainer)
     * -----------------------------------------------------------
     */
}
