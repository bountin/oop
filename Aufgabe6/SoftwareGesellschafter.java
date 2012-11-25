
class SoftwareGesellschafter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for value 1. Is checked in checkFromGesellschafter
	 */
	public SoftwareGesellschafter(int stufe)
	{
		super(stufe);
	}

	public boolean checkFromGesellschafter(Gesellschafter bau)
	{
		return getSicherheitsstufe()==1;
	}
}
