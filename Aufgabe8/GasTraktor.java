

@Autor("Martin")
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

	// Erhoehung des Verbrauchs um delta
	@Autor("Martin")
	public void incVerbrauch(double delta) {
		this.verbrauch += delta;
	}
}
