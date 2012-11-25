
class SoftwareTransportarbeiter
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for levels 3 or 4. Is checked in checkFromTransportarbeiter
	 */
	public SoftwareTransportarbeiter(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromTransportarbeiter(Transportarbeiter bau)
	{
		return getSicherheitsstufe().checkFromTransportarbeiter(bau);
	}
}
