
@Autor("Martin")
public class DuengeAusruestung extends Ausruestung{
	// Kapazitaet des Tanks, muss >= 0.0 sein
	private double kapazitaet;

	/**
	 * kapazitaet muss >= 0 sein
	 */
	@Autor("Martin")
	public DuengeAusruestung(double kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	/**
	 * Rueckgabe der Kapazitaet des Tanks (>= 0)
	 */
	@Autor("Martin")
	public double getKapazitaet() {
		return kapazitaet;
	}
}
