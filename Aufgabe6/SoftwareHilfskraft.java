
class SoftwareHilfskraft
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for values 1 or 2. Is checked in checkFromHilfskraft
	 */
	public SoftwareHilfskraft(int stufe)
	{
		super(stufe);
	}

	public boolean checkFromHilfskraft(Hilfskraft bau)
	{
		return getSicherheitsstufe()==1||getSicherheitsstufe()==2;
	}
}
