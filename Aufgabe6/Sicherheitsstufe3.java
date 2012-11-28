
public class Sicherheitsstufe3 extends Sicherheitsstufe{


	public boolean checkFromBauarbeiter(Bauarbeiter bau)
	{
		return true;
	}

	public boolean checkFromServiceTechniker(ServiceTechniker bau)
	{
		return true;
	}

	public boolean checkFromTransportarbeiter(Transportarbeiter bau)
	{
		return true;
	}

	@Override
	public boolean checkLimit(double leistung) {
		return leistung<=5;
	}

    @Override
    public String toString() {
        return "3";
    }
    
    

}
