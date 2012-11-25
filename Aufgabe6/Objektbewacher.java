
class Objektbewacher
	extends Beschuetzer
{
	public Objektbewacher(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromObjektbewacher(this);
	}
}
