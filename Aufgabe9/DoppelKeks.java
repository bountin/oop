
public abstract class DoppelKeks extends Keks{
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 0;
		result = prime * result
				+ ((fuellung == null) ? 0 : fuellung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoppelKeks other = (DoppelKeks) obj;
		if (fuellung == null) {
			if (other.fuellung != null)
				return false;
		} else if (!fuellung.equals(other.fuellung))
			return false;
		if (this.teig == null) {
			if (other.teig != null)
				return false;
		} else if (!this.teig.equals(other.teig))
			return false;
		return true;
	}

	protected String fuellung;
	
	@Override
	public String toString(){
		return this.getClass().getName() + " Teig: "+ this.teig + 
				" Fuellung: "+this.fuellung;
	}
}
