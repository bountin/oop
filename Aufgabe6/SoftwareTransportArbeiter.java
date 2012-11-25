
class SoftwareTransportarbeiter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for values 3 or 4. Is checked in checkFromTransportarbeiter
	 */
	public SoftwareTransportarbeiter(int stufe)
	{
		super(stufe);
	}

	public boolean checkFromTransportarbeiter(Bauarbeiter bau)
	{
		return getSicherheitsstufe()==3||getSicherheitsstufe()==4;
	}
}
