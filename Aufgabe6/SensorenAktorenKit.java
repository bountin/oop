import java.util.LinkedList;


public class SensorenAktorenKit {

	private String serial;
	private LinkedList<UmweltKomponente> komponenten;
	
	public SensorenAktorenKit(LinkedList<UmweltKomponente> komponenten) {
		this.komponenten = komponenten;
	}
	
	public boolean isUnderLimit(Sicherheitsstufe stufe){
		double leistung = 0;
		for(UmweltKomponente k: komponenten){
			leistung +=k.getLeistungForLimit();
		}
		
		return stufe.checkLimit(leistung);
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
		for(UmweltKomponente k: komponenten){
			k.setSerial(serial);
		}
	}

    @Override
    public String toString() {
        return "{" + "serial=" + serial + ", komponenten=" + komponenten + '}';
    }
    
}
