
@Autor("Undefined")
public class Bauernhof implements HofIdentifiable{

	// Identifizierender Name des Bauernhofes
	private String name;
	
	// Container aller Traktoren
	private TraktorContainer traktoren;

	/**
	 * name muss ein gueltiger String sein
	 */
	@Autor("Martin")
	Bauernhof(String name) {
		this.name = name;
		this.traktoren = new TraktorContainer();
	}

	/**
	 * Rueckgabe des eindeutigen Namen des Bauernhofes
	 */
	@Autor("Martin")
	public String getName(){
		return this.name;
	}

	@Autor("Undefined")
	public void insertTraktor(Traktor traktor) {
		traktoren.add(traktor);
	}

	@Autor("Undefined")
	public Traktor getTraktor(int nummer){
		return (Traktor)traktoren.get(nummer);
	}
	@Autor("Undefined")
	public void removeTraktorViaNummer(int nummer) {
		traktoren.remove(nummer);
	}

	/*
	 * (non-Javadoc)
	 * @see HofIdentifiable#getIdentifier()
	 */
	@Autor("Shahin")
	@Override
	public Object getIdentifier() {
		return getName();
	}

	// XXX Implement Statistik Methods
}
