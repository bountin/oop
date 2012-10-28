
public class Stueckvariante extends Musikstueck {
	
	private String variantenName;

	//POSTCONDITION: Ein den Parametern entsprechendes Objekt wurde erzeugt
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
	
	//POSTCONDITION: eine Implementierung der equals Methode, die Ein- und Austritt ignoriert 
	public boolean equalsIgnoreDates(Musikstueck other) {
        return this.getClass().equals(other.getClass())
        	&& this.getName().equals(other.getName())
            && this.getLaenge() == other.getLaenge()
            && this.getVariantenName().equals(((Stueckvariante) other).getVariantenName());
	}
	
	public String toString(){
    	return "Stueckvariante{ Name= " + getName() 
    			+ " Variantenname= " + variantenName
    			+ ", Laenge=" + getLaenge()
				+ " Eintragung=" + getEintragung()
				+ ", Austragung=" + getAustragung() + "}";
    }
}
