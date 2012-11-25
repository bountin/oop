
class SoftwareBauarbeiter
	extends Software
{
	public SoftwareBauarbeiter  (Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromBauarbeiter(Bauarbeiter bau)
	{
		return true;
	}
}
