
abstract class Bediener
	extends Androide
{

	public boolean check()
	{
		return
			this.skin.isBeruehrungsSkin() // Bediener must have Beruehurung
			// Only Beschuetzer is allowed to have Panzer but this is implicitly checked in the check above
		;
	}
}
