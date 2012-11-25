
class SoftwareKaempfer
	extends Software
{
	public SoftwareKaempfer(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromSoftwareKaempfer(SoftwareKaempfer bau)
	{
		return true;
	}
}
