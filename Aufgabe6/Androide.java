import java.lang.String;

abstract class Androide
{
	protected String serial;
	protected Skin skin;
	protected Software software;

	public Androide(String serial, Skin skin, Software software)
	{
		this.serial = serial;
		this.software = software;
		this.skin = skin;
	}

	abstract public boolean check();

	public String getSerial() {
		return serial;
	}
}
