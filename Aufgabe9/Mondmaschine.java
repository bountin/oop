
public class Mondmaschine extends Formmaschine{
	
	@Override
	public Keks backe(String teig) {
		return new EinzelMondKeks(teig);
	}

}
