import java.util.Date;

/**
 * <p>Eine Entity Klasse zum verstauen der Information eines Bandmitglieds</p>
 *
 * @author Shahin
 *
 */
public class Mitglied {
	private String name;
	private String telnum;
	private String instrument;
	private Date beitritt;
	private Date austritt;
	private MusikstueckContainer repertoire;

	/**
	 * <p> Der Konstruktor der Mitglied Klasse </p>
	 *
	 * <p> Ist das angegebene Beitrittsdatum nach dem aktuellen Datum wird 
	 * beitritt zu null.</p>
	 * <p> Austritt wird automatisch zu null falls beitritt null ist, falls
	 * austritt nach dem aktuellen Datum ist oder wenn austritt nach beitritt ist</p>
	 *
	 * @param String name
	 * @param String telnum
	 * @param String instrument
	 * @param Date beitritt
	 * @param Date austritt
	 */
	public Mitglied(String name, String telnum, String instrument, Date beitritt, Date austritt){
		this.name = name;
		this.telnum = telnum;
		this.instrument = instrument;
		
		if( beitritt == null || beitritt.after(new Date())){
			this.beitritt = new Date();
		}else{
			this.beitritt = beitritt;
		}
		if(austritt == null || austritt.after(new Date()) || this.beitritt == null || austritt.after(this.beitritt)){
			this.austritt = austritt;
		}
		
		this.repertoire = new MusikstueckContainer();
	}
	
	public String getName() {
		return name;
	}

	public String getTelnum() {
		return telnum;
	}

	public String getInstrument() {
		return instrument;
	}

	public Date getBeitritt() {
		return beitritt;
	}

	public Date getAustritt() {
		return austritt;
	}
	
	public void setAustritt(Date austritt) {
		this.austritt = austritt;
	}
	
	public MusikstueckContainer getRepertoire(){
		return repertoire;
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
		result = prime * result + ((telnum == null) ? 0 : telnum.hashCode());
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
			if (other.getAustritt() != null)
				return false;
		} else if (!austritt.equals(other.getAustritt()))
			return false;
		if (beitritt == null) {
			if (other.getBeitritt() != null)
				return false;
		} else if (!beitritt.equals(other.getBeitritt()))
			return false;
		if (instrument == null) {
			if (other.getInstrument() != null)
				return false;
		} else if (!instrument.equals(other.getInstrument()))
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (telnum == null) {
			if (other.getTelnum() != null)
				return false;
		} else if (!telnum.equals(other.getTelnum()))
			return false;
		if (repertoire == null){
			if (other.getRepertoire() != null )
				return false;
		} else if (!repertoire.equals(other.getRepertoire()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mitglied{ Name= " + name + ", Tel#=" + telnum
				+ ", Instrument=" + instrument + ", Beitritt=" + beitritt
				+ ", Austritt=" + austritt + "}";
	}
}
