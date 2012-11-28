
public abstract class UmweltKomponente {
	
	private String serial;
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

    @Override
    public String toString() {
        return "{" + "serial=" + serial + ", leistung=" + leistung + ", name=" + name + '}';
    }

    
}
