
class Leibwaechter
	extends Beschuetzer
{
	public Leibwaechter(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromLeibwaechter(this);
	}
}
