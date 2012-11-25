
class Transportarbeiter
	extends Schwerarbeiter
{
	public Transportarbeiter(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromTransportarbeiter(this);
	}
}
