
public abstract class Keks {
	protected Teig teig;

	public Teig getTeig() {
		return teig;
	}

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);
}
