
class SoftwareHilfskraft
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for levels 1 or 2. Is checked in checkFromHilfskraft
	 */
	public SoftwareHilfskraft(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromHilfskraft(Hilfskraft bau)
	{
		return getSicherheitsstufe().checkFromHilfskraft(bau);
	}

    @Override
    public String toString() {
        return "SoftwareHilfskraft" + super.toString();
    }
    
}
