
public class Sicherheitsstufe4 extends Sicherheitsstufe{
	
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
	
	public boolean checkFromLeibwaechter(Leibwaechter bau)
	{
		return true;
	}

	public boolean checkFromObjektbewacher(Objektbewacher bau)
	{
		return true;
	}

}
