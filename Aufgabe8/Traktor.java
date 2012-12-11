
abstract public class Traktor {

	/**
	 * ausruestung ist entweder eine Drill- oder eine DuengeAusruestung
	 */
	private Ausruestung ausruestung;

	/**
	 * nummer > 0
	 */
	private int nummer;

	/**
	 * betriebsdauer >= 0
	 */
	private int betriebsdauer = 0;

	/**
	 * Ausruestung muss eine gueltige ausruestung sein und != null
	 * Nummer muss > 0 sein
	 */
	Traktor(int nummer, Ausruestung ausruestung) {
		this.ausruestung = ausruestung;
		this.nummer = nummer;
	}

	/**
	 * betrag muss positiv sein
	 */
	public void erhoehe_betriebsdauer(int betrag) {
		this.betriebsdauer += betrag;
	}

	public int getBetriebsdauer() {
		return this.betriebsdauer;
	}

	/**
	 * Ausruestung muss gueltige ausruestung sein und != null
	 */
	public void aendere_ausruestung(Ausruestung ausruestung) {
		this.ausruestung = ausruestung;
	}

	/**
	 * Liefert Seriennummer zurueck
	 * Rueckgabewert > 0
	 */
	public int getNummer() {
		return nummer;
	}

	/**
	 * Liefert Instanz von aktueller Ausruestung zurueck
	 */
	public Ausruestung getAusruestung() {
		return ausruestung;

	}
}
