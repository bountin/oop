
@Autor("Martin")
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
	@Autor("Martin")
	Traktor(int nummer, Ausruestung ausruestung) {
		this.ausruestung = ausruestung;
		this.nummer = nummer;
	}

	/**
	 * betrag muss positiv sein
	 */
	@Autor("Martin")
	public void erhoehe_betriebsdauer(int betrag) {
		this.betriebsdauer += betrag;
	}

	/**
	 * Rueckgabe der Betriebsdauer des Traktors (>= 0)
	 */
	@Autor("Martin")
	public int getBetriebsdauer() {
		return this.betriebsdauer;
	}

	/**
	 * Ausruestung muss gueltige ausruestung sein und != null
	 */
	@Autor("Martin")
	public void aendere_ausruestung(Ausruestung ausruestung) {
		this.ausruestung = ausruestung;
	}

	/**
	 * Liefert Seriennummer zurueck
	 * Rueckgabewert > 0
	 */
	@Autor("Martin")
	public int getNummer() {
		return nummer;
	}

	/**
	 * Liefert Instanz von aktueller Ausruestung zurueck
	 */
	@Autor("Martin")
	public Ausruestung getAusruestung() {
		return ausruestung;
	}
}
