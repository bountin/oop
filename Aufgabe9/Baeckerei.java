import java.util.Iterator;


public class Baeckerei {

	private Doppelkeksmaschine dkm;
	private Formmaschine fm;
	
	public Baeckerei() {
		dkm = new Doppelkeksmaschine();
		fm = null;
	}
	
	private void set(Formmaschine fm){
		this.fm = fm;
	}
	
	private Keks einzelBacken(Form form, Teig teig){		
		setMaschine(form);
		return fm.backe(teig);
	}
	
	private Keks doppelBacken(Form form, Teig teig, Fuellung fuellung){
		return dkm.backe(einzelBacken(form, teig), fuellung);
	}
	
	private void setMaschine(Form form){
		if(form == Form.RUND){
			set(new Rundmaschine());
		}else if(form == Form.MOND){
			set(new Mondmaschine());
		}else if(form == Form.WEIHNACHTSMANN){
			set(new Weihnachtsmannmaschine());
		}
	}
	
	private boolean validate(Position p){
		if(p.getForm() == null || p.getTeig() == null || p.getAnzahl()<1) {
			return false;
		}
		return true;
	}
	
	public Keksdose bestellungBearbeiten(Bestellung bestellung){
		Keksdose kd = new Keksdose();
		Iterator<Position> i = bestellung.iterator();
		while(i.hasNext()){
			Position p = i.next();
			if(!validate(p)){
				System.out.println("Ungültige Eingabe in der letzten Bestellung!");
			}else{
				if(p.getFuellung() != null){
					for(int j = 0; j<p.getAnzahl(); j++){
						kd.add(doppelBacken(p.getForm(),p.getTeig(),p.getFuellung()));
					}
				}else{
					for(int j = 0; j<p.getAnzahl(); j++){
						kd.add(einzelBacken(p.getForm(),p.getTeig()));
					}
				}
			}
		}
		return kd;
	}
}
