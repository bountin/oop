
public class Sicherheitsstufe5 extends Sicherheitsstufe{

	public boolean checkFromKaempfer(Kaempfer bau)
	{
		return true;
	}

	@Override
	public boolean checkLimit(double leistung) {
		return true;
	}

    @Override
    public String toString() {
        return "5";
    }

    
}
