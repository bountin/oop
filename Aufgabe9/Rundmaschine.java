
public class Rundmaschine extends Formmaschine{
	
	@Override
	public Keks backe(Teig teig) {
		return new EinzelRundKeks(teig);
	}

}
