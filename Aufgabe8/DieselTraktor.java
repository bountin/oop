
@Autor("Undefined")
public class DieselTraktor extends Traktor {

	/**
	 * Geerbt von parent:
	 *  Ausruestung muss eine gueltige ausruestung sein und != null
	 *  Nummer muss > 0 sein
	 */
	@Autor("Martin")
	public DieselTraktor(int nummer, Ausruestung ausruestung) {
		super(nummer, ausruestung);
	}

	// Verbrauch ist immer >= 0
	private int verbrauch = 0;

	// Rueckgabe des Dieselverbrauchs (>=0)
	public int getVerbrauch() {
		return verbrauch;
	}

	// Erhoehung des Verbrauchs um delta
	public void incVerbrauch(int delta) {
		this.verbrauch += delta;
	}
}
