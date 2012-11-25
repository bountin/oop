
class Gesellschafter
	extends Bediener
{
	public Gesellschafter(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromGesellschafter(this);
	}
}
