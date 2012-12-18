
public class Doppelkeksmaschine {
	
	public Keks backe(Keks k, String fuellung){
		if(k instanceof DoppelKeks){
			return k;
		}else if(k instanceof EinzelRundKeks){
			return new DoppelRundKeks(k.getTeig(), fuellung);
		}else if(k instanceof EinzelMondKeks){
			return new DoppelMondKeks(k.getTeig(), fuellung);
		}else if(k instanceof EinzelWeihnachtsmannKeks){
			return new DoppelWeihnachtsmannKeks(k.getTeig(), fuellung);
		}else return null;
			
		
	}
}
