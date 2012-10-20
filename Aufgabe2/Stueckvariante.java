
public class Stueckvariante extends Musikstueck {
	
	private String variantenName;

	public Stueckvariante(String name, String variantenName, int laenge) {
		 super(name, laenge);
		 this.variantenName = variantenName;
	}

	public String getVariantenName(){
		return variantenName;
	}
	
	public boolean equals(Musikstueck other) {
        return this.getClass().equals(other.getClass())
        	&& this.getName().equals(other.getName())
            && this.getLaenge() == other.getLaenge()
            && this.getEintragung() == other.getEintragung()
            && this.getAustragung() == other.getAustragung()
        	&& this.getVariantenName().equals(getVariantenName());
	}    
}
