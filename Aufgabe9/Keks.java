
public abstract class Keks {
	protected String teig;

	public String getTeig() {
		return teig;
	}

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);
}
