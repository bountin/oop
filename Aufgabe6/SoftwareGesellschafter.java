
class SoftwareGesellschafter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for level 1. Is checked in checkFromGesellschafter
	 */
	public SoftwareGesellschafter(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromGesellschafter(Gesellschafter bau)
	{
		return getSicherheitsstufe().checkFromGesellschafter(bau);
	}
}
