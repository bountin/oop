
public abstract class EinzelKeks extends Keks{
	
	@Override
	public String toString(){
		return this.getClass().getName() + " Teig: "+ this.teig;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 0;
		result = prime * result
				+ ((this.teig == null) ? 0 : this.teig.hashCode());
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
		EinzelKeks other = (EinzelKeks) obj;
		if (this.teig == null) {
			if (other.teig!= null)
				return false;
		} else if (!this.teig.equals(other.teig))
			return false;
		return true;
	}
}
