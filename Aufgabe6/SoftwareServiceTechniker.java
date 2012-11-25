
class SoftwareServiceTechniker
	extends Software
{
	public SoftwareServiceTechniker(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromServiceTechniker(ServiceTechniker bau)
	{
		return true;
	}
}
