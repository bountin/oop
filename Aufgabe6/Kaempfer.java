
class Kaempfer
	extends Beschuetzer
{
	public Kaempfer(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromKaempfer(this) && software.getSicherheitsstufe().checkFromKaempfer(this);
	}

    @Override
    public String toString() {
        return "Kaempfer" + super.toString();
    }
    
}
