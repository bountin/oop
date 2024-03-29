
class Bauarbeiter
	extends Schwerarbeiter
{
	public Bauarbeiter(String serial, Skin skin, Software software, SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromBauarbeiter(this)&& software.getSicherheitsstufe().checkFromBauarbeiter(this);
	}

    @Override
    public String toString() {
        return "Bauarbeiter" + super.toString();
    }
    
    
}
