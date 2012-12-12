

@Autor("Undefined")
public class GasTraktor extends Traktor {

	/**
	 * Geerbt von parent:
	 *  Ausruestung muss eine gueltige ausruestung sein und != null
	 *  Nummer muss > 0 sein
	 */
	@Autor("Martin")
	public GasTraktor(int nummer, Ausruestung ausruestung) {
		super(nummer, ausruestung);
	}


	// Verbrauch ist immer >= 0.0
	private double verbrauch = 0.0;

	// Rueckgabe des Gasverbrauchs (>=0.0)
	public double getVerbrauch() {
		return verbrauch;
	}

	// Erhoehung des Verbrauchs um delta
	public void incVerbrauch(double delta) {
		this.verbrauch += delta;
	}
}
