
abstract class Skin
{

	private String serial;
	
	public boolean isFesterSkin()
	{
		return false;
	}

	public boolean isBeruehrungsSkin()
	{
		return false;
	}

	public boolean isPanzerSkin()
	{
		return false;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
}
