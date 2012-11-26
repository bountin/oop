
class ServiceTechniker
	extends Schwerarbeiter
{
	public ServiceTechniker(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromServiceTechniker(this);
	}
}
