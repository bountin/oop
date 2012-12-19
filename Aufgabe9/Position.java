
public class Position {

	private int anzahl;
	private Form form;
	private Teig teig;
	private Fuellung fuellung;
	
	public Position(int anzahl, Form form, Teig teig, Fuellung fuellung) {
		this.anzahl = anzahl;
		this.form = form;
		this.teig = teig;
		this.fuellung = fuellung;
	}
	
	public int getAnzahl() {
		return anzahl;
	}

	public Form getForm() {
		return form;
	}

	public Teig getTeig() {
		return teig;
	}

	public Fuellung getFuellung() {
		return fuellung;
	}

    @Override
	public String toString(){
		if(fuellung == null){
			return (anzahl+" Einzelkekse der Form: "+ form +" aus Teig des Typs: "+
					teig);
		}else{
			return (anzahl+" Doppelkekse der Form: "+ form +" aus Teig des Typs: "+
					teig + " mit Fuellung des Typs: " + fuellung);
		}
		
	}

}
