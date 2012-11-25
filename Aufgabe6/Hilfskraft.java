
class Hilfskraft
	extends Bediener
{
	public Hilfskraft(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromHilfskraft(this);
	}
}
