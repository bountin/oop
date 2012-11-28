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

		encodeSerial();
	}

	public boolean check()
	{
		return this.checkSoftware() &&
				this.kit.isUnderLimit(software.getSicherheitsstufe());
	}

	abstract protected boolean checkSoftware();
//	{
//		return software.check(this);
//	}

	public String getSerial() {
		return serial;
	}

	private void encodeSerial(){
		if(software.getSerial()==null)
			software.setSerial(serial);
		if(skin.getSerial()==null)
			skin.setSerial(serial);
		if(kit.getSerial()==null)
			kit.setSerial(serial);
	}
}
