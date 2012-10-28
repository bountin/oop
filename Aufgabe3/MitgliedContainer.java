import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MitgliedContainer {
	private ArrayList<Mitglied> mitglieder;

	//POSTCONDITION: Ein den Parametern entsprechendes Objekt wurde erzeugt
	public MitgliedContainer(){
		this.mitglieder = new ArrayList<Mitglied>();
	}

	//POSTCONDITION: mitglied wird in die Liste hinzugefuegt, falls es nicht bereits
	//aktiv ist
	public void addMitglied(Mitglied mitglied){
		for(Mitglied m: mitglieder){
			if(m.getName().equals(mitglied.getName()) && m.getAustritt() == null){
				return;
			}
		}
		mitglieder.add(mitglied);
	}

	//POSTCONDITION: alle aktiven Mitglieder mit dem angegebenem Namen werden
	//(sofern sie existieren) auf inaktiv gesetzt (austritt = jetzt)
	public void removeMitglied(String name){
		for(Mitglied m: mitglieder){
			if(m.getName().equals(name) && m.getAustritt() == null){
				m.setAustritt(new Date());
				return;
			}
		}
	}

	/**
	 * POSTCONDITION: Sendet jedem momentan aktiven Mitglied eine Nachricht
	 * GOOD: Termine sind austauschbar, sowohl Proben als auch Auftritte koennen verwendet werden.
	 * BAD: Das Datum wird nicht uebergeben bzw. vom Termin geholt, sondern ist immer TODAY()
	 */
    public void updateTermin(Termin t) {
        List<Mitglied> l = this.getMitgliederOn(new Date());
        for(Mitglied m : l) {
            m.sendInfo("Termin '" + t + "' aendert Status auf '" + t.getStatus() + "'");
        }
    }

  //POSTCONDITION: Die Liste aller zu dem Zeitpunkt "date" aktiven Mitglieder
    //wird zurueckgegeben
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

}
