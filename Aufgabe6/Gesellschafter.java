
class Gesellschafter
	extends Bediener
{
	public Gesellschafter(String serial, Skin skin, Software software,SensorenAktorenKit kit)
	{
		super(serial, skin, software,kit);
	}

	protected boolean checkSoftware()
	{
		return software.checkFromGesellschafter(this)&& software.getSicherheitsstufe().checkFromGesellschafter(this);
	}

    @Override
    public String toString() {
        return "Gesellschafter" + super.toString();
    }
    
}
