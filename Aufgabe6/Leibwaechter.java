
class Leibwaechter
	extends Beschuetzer
{
	public Leibwaechter(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromLeibwaechter(this)&& software.getSicherheitsstufe().checkFromLeibwaechter(this);
	}
}
