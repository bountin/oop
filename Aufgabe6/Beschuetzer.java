
abstract class Beschuetzer
	extends Androide
{
	public Beschuetzer(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	public boolean check()
	{
		return
			super.check() &&
			true // Beschuetzer are allowed to have any skin
		;
	}
}
