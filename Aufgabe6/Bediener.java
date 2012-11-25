
abstract class Bediener
	extends Androide
{
	public Bediener(String serial, Skin skin, Software software)
	{
		super(serial, skin, software);
	}

	public boolean check()
	{
		return
			super.check() &&
			this.skin.isBeruehrungsSkin() // Bediener must have Beruehurung
			// Only Beschuetzer is allowed to have Panzer but this is implicitly checked in the check above
		;
	}
}
