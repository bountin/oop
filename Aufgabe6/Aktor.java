
public class Aktor extends UmweltKomponente{

	public Aktor(String name, double leistung) {
		super(name, leistung);
	}

	@Override
	public double getLeistungForLimit() {
		return getLeistung();
	}
    @Override
    public String toString() {
        return "Aktor"+ super.toString();
    }
}
