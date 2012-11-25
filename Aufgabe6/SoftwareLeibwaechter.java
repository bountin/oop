
class SoftwareLeibwaechter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for value 4. Is checked in checkFromLeibwaechter
	 */
	public SoftwareLeibwaechter(int stufe)
	{
		super(stufe);
	}

	public boolean checkFromLeibwaechter(Leibwaechter bau)
	{
		return getSicherheitsstufe()==4;
	}
}
