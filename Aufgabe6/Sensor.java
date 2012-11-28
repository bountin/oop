
public class Sensor extends UmweltKomponente{

	public Sensor(String name, double leistung) {
		super(name, leistung);
	}

	@Override
	public double getLeistungForLimit() {
		return 0;
	}

    @Override
    public String toString() {
        return "Sensor"+ super.toString();
    }
    
}
