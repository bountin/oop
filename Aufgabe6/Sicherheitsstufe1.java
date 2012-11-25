
public class Sicherheitsstufe1 extends Sicherheitsstufe{

	public boolean checkFromGesellschafter(Gesellschafter bau)
	{
		return true;
	}
	
	public boolean checkFromHilfskraft(Hilfskraft bau)
	{
		return true;
	}

	@Override
	public boolean checkLimit(double leistung) {
		return leistung<=1.0;
	}
}
