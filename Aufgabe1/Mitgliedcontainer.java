package Aufgabe1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * <p>Eine Container Klasse für Mitglied Entities </p>
 * 
 * @author Shahin
 *
 */
public class Mitgliedcontainer {
	private ArrayList<Mitglied> mitglieder;
	
	/**
	 * <p>Der Standardkonstruktor der Mitgliedcontainer Klasse</p>
	 */
	public Mitgliedcontainer(){
		super();
	}
	
	/**
	 * <p>Gibt eine formattierte, unsortierte Liste aller aktueller Mitglieder auf dem 
	 * Standardoutput aus</p>
	 */
	public void printCurrentMitglieder(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		for(Mitglied mitglied: mitglieder){
			if(mitglied.getAustritt() == null){
				System.out.println("Name: " + mitglied.getName() + "  " + 
									"Tel.: " + mitglied.getTelnum() + "  " +
									"Intrument: " + mitglied.getInstrument() + "  "+
									"Beitrittsdatum: " + dateFormat.format(mitglied.getBeitritt()));
			}
		}
	}
	
	/**
	 * <p>Gibt eine formattierte, unsortierte Liste aller Mitglieder zum angegebenen Zeitpunkt
	 * auf dem Standardoutput aus</p>
	 * 
	 * @param date das Datum, zu welchem die Mitglieder ausgegeben werden sollen
	 */
	public void printMitgliederAt(Date date){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		for(Mitglied mitglied: mitglieder){
			if(mitglied.getBeitritt().compareTo(date)<=0){
				if (mitglied.getAustritt() == null){
					System.out.println("Name: " + mitglied.getName() + "  " + 
							"Tel.: " + mitglied.getTelnum() + "  " +
							"Intrument: " + mitglied.getInstrument() + "  "+
							"Beitrittsdatum: " + dateFormat.format(mitglied.getBeitritt()));
				}else if(mitglied.getAustritt().compareTo(date)>0){
					System.out.println("Name: " + mitglied.getName() + "  " + 
							"Tel.: " + mitglied.getTelnum() + "  " +
							"Intrument: " + mitglied.getInstrument() + "  "+
							"Beitrittsdatum: " + dateFormat.format(mitglied.getBeitritt()) + "  " +
							"Austrittsdatum: " + dateFormat.format(mitglied.getAustritt()));
				}
			}
		}
	}
	
	/**
	 * <p> Fügt ein aktives Mitglied hinzu, falls nicht bereits ein aktives Mitglied
	 * mit diesem Namen existiert</p>
	 * 
	 * <p> Gibt es bereits ein aktives Mitglied mit diesem Namen wird eine entsprechende
	 * Meldung auf dem Standardoutput ausgegeben</p>
	 * 
	 * @param mitglied
	 */
	public void addMitglied(Mitglied mitglied){
		for(Mitglied m: mitglieder){
			if(m.getName().equals(mitglied.getName()) && m.getAustritt() == null){
				System.out.println(mitglied.getName() + " ist bereits in der Gruppe!");
				return;
			}
		}
		mitglieder.add(mitglied);
	}
	
	/**
	 * <p> Sucht nach einem aktiven Mitglied mit dem gegebenen Namen 
	 * und setzt das Austrittsdatum auf das aktuelle Datum</p>
	 * 
	 * <p> Gibt es kein aktives Mitglied mit diesem Namen wird eine entsprechende
	 * Meldung auf dem Standardoutput ausgegeben</p>
	 * 
	 * @param name
	 */
	public void removeMitglied(String name){
		for(Mitglied m: mitglieder){
			if(m.getName().equals(name) && m.getAustritt() == null){
				m.setBeitritt(new Date());
				return;
			}
		}
		System.out.println(name + " ist kein aktives Mitglied der Gruppe!");
	}

	public ArrayList<Mitglied> getMitglieder() {
		return mitglieder;
	}

	public void setMitglieder(ArrayList<Mitglied> mitglieder) {
		this.mitglieder = mitglieder;
	}
	
}
