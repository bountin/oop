
class SoftwareLeibwaechter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for level 4. Is checked in checkFromLeibwaechter
	 */
	public SoftwareLeibwaechter(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromLeibwaechter(Leibwaechter bau)
	{
		return getSicherheitsstufe().checkFromLeibwaechter(bau);
	}

    @Override
    public String toString() {
        return "SoftwareLeibwaechter" + super.toString();
    }
    
}
