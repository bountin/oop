
abstract class Beschuetzer
	extends Androide
{
	public Beschuetzer(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	public boolean check()
	{
		return
			super.check() &&
			true // Beschuetzer are allowed to have any skin
		;
	}
}
