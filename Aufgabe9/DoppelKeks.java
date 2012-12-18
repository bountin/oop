
public abstract class DoppelKeks extends Keks{
	protected String fuellung;
	
	@Override
	public String toString(){
		return this.getClass().getName() + " Teig: "+ this.teig + 
				" Fuellung:"+this.fuellung;
	}
}
