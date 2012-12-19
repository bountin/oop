
public class Weihnachtsmannmaschine extends Formmaschine{

	@Override
	public Keks backe(Teig teig) {
		return new EinzelWeihnachtsmannKeks(teig);
	}

}
