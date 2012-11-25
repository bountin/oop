
abstract class Schwerarbeiter
	extends Androide
{
	public Schwerarbeiter(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	public boolean check()
	{
		return
			super.check() &&
			!this.skin.isPanzerSkin() // Panzer is only allowed for Beschuetzer
		;
	}
}
