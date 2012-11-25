
class SoftwareObjektbewacher
	extends Software
{
	public SoftwareObjektbewacher(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromObjektbewacher(Objektbewacher bau)
	{
		return true;
	}
}
