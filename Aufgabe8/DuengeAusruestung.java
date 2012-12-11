
@Autor("Martin")
public class DuengeAusruestung extends Ausruestung{
	private double kapazitaet;

	@Autor("Martin")
	public DuengeAusruestung(double kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	@Autor("Martin")
	public double getKapazitaet() {
		return kapazitaet;
	}
}
