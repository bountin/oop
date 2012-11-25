
class SoftwareBauarbeiter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for values 3 or 4. Is checked in checkFromBauabeiter
	 */
	public SoftwareBauarbeiter  (int stufe)
	{
		super(stufe);
	}

	public boolean checkFromBauarbeiter(Bauarbeiter bau)
	{
		return getSicherheitsstufe()==3 || getSicherheitsstufe()==4;
	}
}
