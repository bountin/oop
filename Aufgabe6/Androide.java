import java.lang.String;

abstract class Androide
{
	protected String serial;
	protected Skin skin;
	protected Software software;
	protected SensorenAktorenKit kit;

	public Androide(String serial, Skin skin, Software software, SensorenAktorenKit kit)
	{
		this.serial = serial;
		this.software = software;
		this.skin = skin;
		this.kit = kit;
	}

	public boolean check()
	{
		return this.checkSoftware();
	}

	abstract protected boolean checkSoftware();
//	{
//		return software.check(this);
//	}

	public String getSerial() {
		return serial;
	}
}
