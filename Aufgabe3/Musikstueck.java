import java.lang.String;
import java.util.Date;

public class Musikstueck {
    private String name;
    private int laenge;

    private Date eintragung;
    private Date austragung;

	/**
	 * Anmerkung: Laenge ist in Sekunden
	 * Precondition: Laenge ist positiv
	 * Precondition: Name != null
	 */
    public Musikstueck(String name, int laenge) {
        this.name = name;
        this.laenge = laenge;
    }

    public String getName() {
        return name;
    }

    public int getLaenge() {
        return laenge;
    }

    public Date getEintragung() {
        return eintragung;
    }

    public Date getAustragung() {
        return austragung;
    }

    public void setEintragung(Date eintragung) {
        this.eintragung = eintragung;
    }

    public void setAustragung(Date austragung) {
        this.austragung = austragung;
    }

	/**
	 * Precondition: datum darf nicht null sein
	 * Postcondition: Warhheitswert, ob das Musikstueck am gegebenen Tag aktiv war, wird zurueck gegegebn
	 */
    public boolean isActive(Date datum) {
        if (eintragung == null ) {
            return false;
        }

        if (austragung == null) {
            return datum.after(eintragung) || datum.equals(eintragung);
        }

        return
            (datum.after(eintragung) || datum.equals(eintragung))
         && (datum.before(austragung) || datum.equals(austragung));
    }

	/**
	 * Precondition: Other darf nicht null sein
	 * Postcondition: Wahr, wenn beide Musikstuecke identisch sind. Ansonsten falsch.
	 */
    public boolean equals(Musikstueck other) {
        return this.getClass().equals(other.getClass())
        	&& this.getName().equals(other.getName())
            && this.getLaenge() == other.getLaenge()
            && this.getEintragung() == other.getEintragung()
            && this.getAustragung() == other.getAustragung();
    }

	/**
	 * Precondition: Other darf nicht null sein
	 * Postcondition: Wahr, wenn beide Musikstuecke mit Ausnahme der beiden Datuemer identisch sind. Ansonsten falsch.
	 */
    public boolean equalsIgnoreDates(Musikstueck other){
    	return this.getClass().equals(other.getClass())
            	&& this.getName().equals(other.getName())
                && this.getLaenge() == other.getLaenge();
    }

    public String toString(){
    	return "Musikstueck{ Name= " + name + ", Laenge=" + laenge
				+ " Eintragung=" + eintragung
				+ ", Austragung=" + austragung + "}";
    }
}
