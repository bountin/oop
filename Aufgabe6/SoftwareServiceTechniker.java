
class SoftwareServiceTechniker
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for levels 3 or 4. Is checked in checkFromServiceTechniker
	 */
	public SoftwareServiceTechniker(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromServiceTechniker(ServiceTechniker bau)
	{
		return getSicherheitsstufe().checkFromServiceTechniker(bau);
	}
}
