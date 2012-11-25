
class SoftwareTransportarbeiter
	extends Software
{
	public SoftwareTransportarbeiter(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromTransportarbeiter(Bauarbeiter bau)
	{
		return true;
	}
}
