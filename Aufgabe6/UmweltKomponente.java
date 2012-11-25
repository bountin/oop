
public abstract class UmweltKomponente {
	
	private double leistung;
	private String name;
	
	/*CONSTRAINT: Precondition
	 * leistung has to be positive 
	 * */
	public UmweltKomponente(String name, double leistung){
		this.name = name;
		this.leistung = leistung;
	}

	public double getLeistung() {
		return leistung;
	}

	public String getName() {
		return name;
	}
	
	/*CONSTRAINT: Postcondition
	 *Returns leistung for Aktors, but 0 for Sensors
	 */
	public abstract double getLeistungForLimit();

}
