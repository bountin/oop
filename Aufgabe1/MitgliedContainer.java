package Aufgabe1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * <p>Eine Container Klasse f�r Mitglied Entities </p>
 *
 * @author Shahin
 *
 */
public class MitgliedContainer {
	private ArrayList<Mitglied> mitglieder;

	/**
	 * <p>Der Standardkonstruktor der MitgliedContainer Klasse</p>
	 */
	public MitgliedContainer(){
		super();
		this.mitglieder = new ArrayList<Mitglied>();
	}

	/**
	 * <p>Gibt eine formattierte, unsortierte Liste aller aktueller Mitglieder zur�ck</p>
	 *
	 * @return ein String mit einer Liste aller aktiven Mitglieder
	 */
	public String printCurrentMitglieder(){
		int counter = 0;
		String ausgabe = "";
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		for(Mitglied mitglied: mitglieder){
			if(mitglied.getAustritt() == null){
				counter++;
				ausgabe += ("Name: " + mitglied.getName() + ";  " +
							"Tel.: " + mitglied.getTelnum() + ";  " +
							"Intrument: " + mitglied.getInstrument() + ";  "+
							"Beitrittsdatum: " + dateFormat.format(mitglied.getBeitritt()) +"\n");
			}
		}
		if(counter == 0){
			ausgabe = ("Es gibt im Moment keine aktiven Mitglieder!");
		}

		return ausgabe;
	}

	/**
	 * <p>Gibt eine formattierte, unsortierte Liste aller Mitglieder zum angegebenen Zeitpunkt
	 * zur�ck</p>
	 *
	 * @param Date date: das Datum, zu welchem die Mitglieder ausgegeben werden sollen
	 * @return ein String mit einer Liste aller aktiven Mitglieder zu dem gegebenen Zeitpunkt
	 */
	public String printMitgliederAt(Date date){
		int counter = 0;
		String ausgabe = "";
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		for(Mitglied mitglied: mitglieder){
			if(mitglied.getBeitritt().compareTo(date)<=0){
				if (mitglied.getAustritt() == null){
					counter++;
					ausgabe += ("Name: " + mitglied.getName() + ";  " +
								"Tel.: " + mitglied.getTelnum() + ";  " +
								"Intrument: " + mitglied.getInstrument() + ";  "+
								"Beitrittsdatum: " + dateFormat.format(mitglied.getBeitritt()) + "\n");
				}else if(mitglied.getAustritt().compareTo(date)>0){
					counter++;
					ausgabe += ("Name: " + mitglied.getName() + ";  " +
								"Tel.: " + mitglied.getTelnum() + ";  " +
								"Intrument: " + mitglied.getInstrument() + ";  "+
								"Beitrittsdatum: " + dateFormat.format(mitglied.getBeitritt()) + ";  " +
								"Austrittsdatum: " + dateFormat.format(mitglied.getAustritt()) + "\n");
				}
			}
		}
		if(counter == 0){
			ausgabe = ("Es gab zu diesem Zeitpunkt keine aktiven Mitglieder!");
		}

		return ausgabe;
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
		for(Mitglied m: mitglieder){
			if(m.getName().equals(name) && m.getAustritt() == null){
				System.out.println(name + " ist bereits in der Gruppe!");
				return;
			}
		}
		mitglieder.add(new Mitglied(name,telnum,instrument));
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
		for(Mitglied m: mitglieder){
			if(m.getName().equals(name) && m.getAustritt() == null){
				m.setAustritt(new Date());
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
