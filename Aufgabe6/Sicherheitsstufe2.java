
public class Sicherheitsstufe2 extends Sicherheitsstufe{

	public boolean checkFromHilfskraft(Hilfskraft bau)
	{
		return true;
	}

	@Override
	public boolean checkLimit(double leistung) {
		return leistung<=1.0;
	}
}
