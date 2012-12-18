
public class Weihnachtsmannmaschine extends Formmaschine{

	@Override
	public Keks backe(String teig) {
		return new EinzelWeihnachtsmannKeks(teig);
	}

}
