
class SoftwareKaempfer
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for level 5. Is checked in checkFromKaempfer
	 */
	public SoftwareKaempfer(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromKaempfer(Kaempfer bau)
	{
		return getSicherheitsstufe().checkFromKaempfer(bau);
	}
}
