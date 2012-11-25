
class SoftwareLeibwaechter
	extends Software
{
	public SoftwareLeibwaechter(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromLeibwaechter(Leibwaechter bau)
	{
		return true;
	}
}
