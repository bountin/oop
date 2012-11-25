
class SoftwareObjektbewacher
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for value 4. Is checked in checkFromObjektbewacher
	 */
	public SoftwareObjektbewacher(int stufe)
	{
		super(stufe);
	}

	public boolean checkFromObjektbewacher(Objektbewacher bau)
	{
		return getSicherheitsstufe()==4;
	}
}
