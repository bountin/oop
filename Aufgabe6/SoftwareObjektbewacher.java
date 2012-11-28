
class SoftwareObjektbewacher
	extends Software
{
	/*
	 * CONSTRAINT: Precondition
	 * Stufe is only valid for level 4. Is checked in checkFromObjektbewacher
	 */
	public SoftwareObjektbewacher(Sicherheitsstufe stufe)
	{
		super(stufe);
	}

	public boolean checkFromObjektbewacher(Objektbewacher bau)
	{
		return getSicherheitsstufe().checkFromObjektbewacher(bau);
	}

    @Override
    public String toString() {
        return "SoftwareObjektbewacher" + super.toString();
    }
    
}
