import java.util.ArrayList;
import java.util.Date;

/**
 * <p>Eine Container Klasse für Mitglied Entities </p>
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
		this.mitglieder = new ArrayList<Mitglied>();
	}

	/**
	 * <p> Fügt ein aktives Mitglied hinzu, falls nicht bereits ein aktives Mitglied
	 * mit diesem Namen existiert</p>
	 *
	 * <p> Gibt es bereits ein aktives Mitglied mit diesem Namen wird eine entsprechende
	 * Meldung auf dem Standardoutput ausgegeben</p>
	 *
	 * @param String name
	 * @param long telnum
	 * @param String instrument
	 * @param Date beitritt
	 * @param Date austritt
	 */
	public void addMitglied(String name, String telnum, String instrument, Date beitritt, Date austritt){
		for(Mitglied m: mitglieder){
			if(m.getName().equals(name) && m.getAustritt() == null){
				return;
			}
		}
		mitglieder.add(new Mitglied(name,telnum,instrument,beitritt,austritt));
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
	}
	
	/**
	 * <p>Gibt die aktiven Mitglieder an einem bestimmten Datum wieder</p>
	 * 
	 * @param Date date: das momentane Datum wird angenommen, falls date null ist
	 * @return eine Liste der aktiven Mitglieder zu einem gewissen Zeitpunkt. Kann leer sein, aber nicht null
	 */
	public ArrayList<Mitglied> getMitgliederOn(Date date){
		ArrayList<Mitglied> m = new ArrayList<Mitglied>();
		if(date == null){
			for(Mitglied mitglied: mitglieder){
				if(mitglied.getAustritt()== null){
					m.add(mitglied);
				}
			}
		}else{
			for(Mitglied mitglied: mitglieder){
				if( mitglied.getBeitritt().compareTo(date)<=0){
					if(mitglied.getAustritt() == null || mitglied.getAustritt().compareTo(date)>=0){
						m.add(mitglied);
					}
				}
			}
		}
		
		return m;
	}

	public ArrayList<Mitglied> getMitglieder() {
		return mitglieder;
	}
}
