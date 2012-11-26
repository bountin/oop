
abstract class Schwerarbeiter
	extends Androide
{
	public Schwerarbeiter(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	public boolean check()
	{
		return
			super.check() &&
			!this.skin.isPanzerSkin() // Panzer is only allowed for Beschuetzer
		;
	}
}
