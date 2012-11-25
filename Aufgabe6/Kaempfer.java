
class Kaempfer
	extends Beschuetzer
{
	public Kaempfer(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromKaempfer(this);
	}
}
