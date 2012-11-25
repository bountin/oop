
class SoftwareGesellschafter
	extends Software
{
	public SoftwareGesellschafter(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromGesellschafter(Gesellschafter bau)
	{
		return true;
	}
}
