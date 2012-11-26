
class Objektbewacher
	extends Beschuetzer
{
	public Objektbewacher(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromObjektbewacher(this)&& software.getSicherheitsstufe().checkFromObjektbewacher(this);
	}
}
