
class Bauarbeiter
	extends Schwerarbeiter
{
	public Bauarbeiter(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromBauarbeiter(this);
	}
}
