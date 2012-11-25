
class SoftwareServiceTechniker
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for values 3 or 4. Is checked in checkFromServiceTechniker
	 */
	public SoftwareServiceTechniker(int stufe)
	{
		super(stufe);
	}

	public boolean checkFromServiceTechniker(ServiceTechniker bau)
	{
		return getSicherheitsstufe()==3||getSicherheitsstufe()==4;
	}
}
