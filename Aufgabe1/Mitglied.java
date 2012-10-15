import java.util.Date;

/**
 * <p>Eine Entity Klasse zum verstauen der Information eines Bandmitglieds</p>
 *
 * @author Shahin
 *
 */
public class Mitglied {
	private String name;
	private long telnum;
	private String instrument;
	private Date beitritt;
	private Date austritt;

	/**
	 * <p> Der Konstruktor der Mitglied Klasse </p>
	 *
	 * <p> Name, Telefonnummer und Instrument können angegeben werden.
	 * Das Datum des Beitritts wird automatisch als der Zeitpunkt der
	 * Erstellung der Klasse festgesetzt. Das Datum des Austritts bleibt frei</p>
	 *
	 * @param String name
	 * @param long telnum
	 * @param String instrument
	 */
	public Mitglied(String name, long telnum, String instrument){
		this.name = name;
		this.telnum = telnum;
		this.instrument = instrument;
		//Nimmt die momentane Systemzeit beim Zeitpunkt der Erstellung
		this.beitritt = new Date();
		this.austritt = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTelnum() {
		return telnum;
	}

	public void setTelnum(long telnum) {
		this.telnum = telnum;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public Date getBeitritt() {
		return beitritt;
	}

	public void setBeitritt(Date beitritt) {
		this.beitritt = beitritt;
	}

	public Date getAustritt() {
		return austritt;
	}

	public void setAustritt(Date austritt) {
		this.austritt = austritt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((austritt == null) ? 0 : austritt.hashCode());
		result = prime * result
				+ ((beitritt == null) ? 0 : beitritt.hashCode());
		result = prime * result
				+ ((instrument == null) ? 0 : instrument.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (telnum ^ (telnum >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mitglied other = (Mitglied) obj;
		if (austritt == null) {
			if (other.austritt != null)
				return false;
		} else if (!austritt.equals(other.austritt))
			return false;
		if (beitritt == null) {
			if (other.beitritt != null)
				return false;
		} else if (!beitritt.equals(other.beitritt))
			return false;
		if (instrument == null) {
			if (other.instrument != null)
				return false;
		} else if (!instrument.equals(other.instrument))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telnum != other.telnum)
			return false;
		return true;
	}
}
