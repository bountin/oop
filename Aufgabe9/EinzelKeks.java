
public abstract class EinzelKeks extends Keks{
	
	@Override
	public String toString(){
		return this.getClass().getName() + " Teig: "+ this.teig;
	}
}
