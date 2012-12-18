
public class Rundmaschine extends Formmaschine{
	
	@Override
	public Keks backe(String teig) {
		return new EinzelRundKeks(teig);
	}

}
