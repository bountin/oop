
abstract class Schwerarbeiter
	extends Androide
{
	public boolean check()
	{
		return
			!this.skin.isPanzer() // Panzer is only allowed for Beschuetzer
		;
	}
}
