

abstract class Software
{
	private String serial;
	private Sicherheitsstufe sicherheitsstufe;

	public Software(Sicherheitsstufe stufe)
	{
		this.sicherheitsstufe = stufe;
	}

	public Sicherheitsstufe getSicherheitsstufe() {
		return sicherheitsstufe;
	}

	public boolean checkFromBauarbeiter(Bauarbeiter bau)
	{
		return false;
	}

	public boolean checkFromGesellschafter(Gesellschafter bau)
	{
		return false;
	}

	public boolean checkFromHilfskraft(Hilfskraft bau)
	{
		return false;
	}

	public boolean checkFromKaempfer(Kaempfer bau)
	{
		return false;
	}

	public boolean checkFromLeibwaechter(Leibwaechter bau)
	{
		return false;
	}

	public boolean checkFromObjektbewacher(Objektbewacher bau)
	{
		return false;
	}

	public boolean checkFromServiceTechniker(ServiceTechniker bau)
	{
		return false;
	}

	public boolean checkFromTransportarbeiter(Transportarbeiter bau)
	{
		return false;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

    @Override
    public String toString() {
        return "{" + "serial=" + serial + ", sicherheitsstufe=" + sicherheitsstufe + '}';
    }  
}
