
@Autor("Martin")
public class DrillAusruestung extends Ausruestung{
	// Anzahl der Saescharen ist immer >= 0
	private int saeschare_anzahl;

	/**
	 * saeschare_anzahl muss >= 0 sein
	 */
	@Autor("Martin")
	public DrillAusruestung(int saeschare_anzahl) {
		this.saeschare_anzahl = saeschare_anzahl;
	}

	/**
	 * Rueckgabe der Anzahl der Saescharen (>= 0)
	 */
	@Autor("Martin")
	public int getSaeschare_anzahl() {
		return saeschare_anzahl;
	}
}
