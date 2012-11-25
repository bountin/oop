
class ServiceTechniker
	extends Schwerarbeiter
{
	public ServiceTechniker(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromServiceTechniker(this);
	}
}
