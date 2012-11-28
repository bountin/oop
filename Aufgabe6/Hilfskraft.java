
class Hilfskraft
	extends Bediener
{
	public Hilfskraft(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromHilfskraft(this)&& software.getSicherheitsstufe().checkFromHilfskraft(this);
	}

    @Override
    public String toString() {
        return "Hilfskraft" + super.toString();
    }
    
}
