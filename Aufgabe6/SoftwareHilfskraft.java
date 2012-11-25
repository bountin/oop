
class SoftwareHilfskraft
	extends Software
{
	public SoftwareHilfskraft(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromHilfskraft(Hilfskraft bau)
	{
		return true;
	}
}
