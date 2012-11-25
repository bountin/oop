
class SoftwareKaempfer
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for value 5. Is checked in checkFromKaempfer
	 */
	public SoftwareKaempfer(int stufe)
	{
		super(stufe);
	}

	public boolean checkFromSoftwareKaempfer(SoftwareKaempfer bau)
	{
		return getSicherheitsstufe()==5;
	}
}
