
class Transportarbeiter
	extends Schwerarbeiter
{
	public Transportarbeiter(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromTransportarbeiter(this)&& software.getSicherheitsstufe().checkFromTransportarbeiter(this);
	}

    @Override
    public String toString() {
        return "Transportarbeiter" + super.toString();
    }

    
}
