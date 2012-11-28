
public abstract class Sicherheitsstufe {
	
	public boolean checkFromBauarbeiter(Bauarbeiter bau)
	{
		return false;
	}

	public boolean checkFromGesellschafter(Gesellschafter bau)
	{
		return false;
	}

	public boolean checkFromHilfskraft(Hilfskraft bau)
	{
		return false;
	}

	public boolean checkFromKaempfer(Kaempfer bau)
	{
		return false;
	}

	public boolean checkFromLeibwaechter(Leibwaechter bau)
	{
		return false;
	}

	public boolean checkFromObjektbewacher(Objektbewacher bau)
	{
		return false;
	}

	public boolean checkFromServiceTechniker(ServiceTechniker bau)
	{
		return false;
	}

	public boolean checkFromTransportarbeiter(Transportarbeiter bau)
	{
		return false;
	}

	public abstract boolean checkLimit(double leistung);
    
    
}
