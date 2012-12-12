
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

	// Erhoehung des Verbrauchs um delta
	@Autor("Martin")
	public void incVerbrauch(int delta) {
		this.verbrauch += delta;
	}
}
