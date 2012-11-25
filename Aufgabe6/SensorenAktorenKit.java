import java.util.LinkedList;


public class SensorenAktorenKit {

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
}
