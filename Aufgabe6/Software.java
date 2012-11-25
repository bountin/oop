

abstract class Software
{
	private int sicherheitsstufe;

	/*
	 * CONSTRAINT: Precondition
	 * stufe (and by extension sicherheitsstufe) is only valid for values x 
	 * where 1<=x<=5. However, the actual validity depends on the particular
	 * Software in question
	 */
	public Software(int stufe)
	{
		this.sicherheitsstufe = stufe;
	}

	public int getSicherheitsstufe() {
		return sicherheitsstufe;
	}

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
}
