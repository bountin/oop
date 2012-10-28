import Buchung.BuchungContainer;
import Buchung.Filter.AbstractFilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Musikgruppe {
    private TerminContainer termincontainer;
    private MitgliedContainer mitgliedcontainer;
    private BuchungContainer buchungcontainer;
    private OrtContainer ortcontainer;

    private String name;
    private String ausrichtung;

    //POSTCONDITION: Ein den Parametern entsprechendes Objekt wurde erzeugt
    public Musikgruppe(String name, String ausrichtung) {
        this.name = name;
        this.ausrichtung = ausrichtung;
        this.termincontainer = new TerminContainer();
        this.mitgliedcontainer = new MitgliedContainer();
        this.buchungcontainer = new BuchungContainer();
        this.ortcontainer = new OrtContainer();
    }

    public String getName() {
        return name;
    }

    public String getAusrichtung() {
        return ausrichtung;
    }

    public MitgliedContainer getMitgliedContainer() {
        return mitgliedcontainer;
    }

    public TerminContainer getTerminContainer() {
        return termincontainer;
    }

    public BuchungContainer getBuchungContainer() {
        return buchungcontainer;
    }

    public OrtContainer getOrtContainer() {
        return ortcontainer;
    }
    /**
	 * <p>Gibt das Repertoire der Band zu einem bestimmten Zeitpunkt wieder.
	 *  Das Repertoire ist die Schnittmenge der Repertoires aller aktiver Mitglieder
	 *  zu angegebenen Zeitpunkt</p>
	 *
	 * @param Date date: das momentane Datum wird angenommen, falls date null ist
	 * @return eine Liste des zusammengesetzten Repertoires, basierend auf den zu dem angegebenen
	 * Zeitpunkt aktiven Mitgliedern
	 */
	public ArrayList<Musikstueck> getActiveRepertoire(Date date){
		ArrayList<Musikstueck> temp = new ArrayList<Musikstueck>();
		ArrayList<Musikstueck> repertoire = new ArrayList<Musikstueck>();
		boolean first = true;
		for(Mitglied mitglied: this.mitgliedcontainer.getMitgliederOn(date)){
			if(first){
				temp.addAll(mitglied.getRepertoire().getList(date));
				repertoire.addAll(mitglied.getRepertoire().getList(date));
				first = false;
			}else{
				for(Musikstueck m:temp){
					boolean check = false;
					for(Musikstueck n: mitglied.getRepertoire().getList(date)){
						if(check = m.equalsIgnoreDates(n)){
							break;
						}
					}
					if(!check){
						repertoire.remove(m);
					}
				}
			}
		}
		return repertoire;
	}

    @Override
    public String toString() {
        return "Musikgruppe{" + "name=" + name + ", ausrichtung=" + ausrichtung + '}';
    }

	public float getSaldo(List<AbstractFilter> filters) {
		return this.getBuchungContainer().summe(filters) + this.termincontainer.getSaldo(filters);
	}
}
