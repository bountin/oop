
public class Position {

	private int anzahl;
	private String form;
	private String teig;
	private String fuellung;
	
	public Position(int anzahl, String form, String teig, String fuellung) {
		this.anzahl = anzahl;
		this.form = form;
		this.teig = teig;
		this.fuellung = fuellung;
	}
	
	public int getAnzahl() {
		return anzahl;
	}

	public String getForm() {
		return form;
	}

	public String getTeig() {
		return teig;
	}

	public String getFuellung() {
		return fuellung;
	}

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
