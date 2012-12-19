
public class Mondmaschine extends Formmaschine{
	
	@Override
	public Keks backe(Teig teig) {
		return new EinzelMondKeks(teig);
	}

}
