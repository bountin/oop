
class SoftwareBauarbeiter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for levels 3 or 4. Is checked in checkFromBauabeiter
	 */
	public SoftwareBauarbeiter  (Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromBauarbeiter(Bauarbeiter bau)
	{
		return getSicherheitsstufe().checkFromBauarbeiter(bau);
	}

    @Override
    public String toString() {
        return "SoftwareBauarbeiter" + super.toString();
    }
    
}
