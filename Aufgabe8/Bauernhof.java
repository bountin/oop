
@Autor("Shahin")
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

	@Autor("Shahin")
	public void insertTraktor(Traktor traktor) {
		traktoren.add(traktor);
	}

	@Autor("Shahin")
	public Traktor getTraktor(int nummer){
		return (Traktor)traktoren.get(nummer);
	}
	@Autor("Shahin")
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

	@Autor("Shahin")
	public void outputStats() {
	  System.out.println("NAME: " + getName());
	  System.out.println("Betriebszeit per Assignment:");
	  traktoren.avgWorktimePerAssignment();
	  System.out.println("Betriebszeit per Motor:");
	  traktoren.avgWorktimePerEngine();
	  System.out.println("Dieselverbrauch per Assignment:");
	  traktoren.avgDieselConsuptionPerAssignment();
	  System.out.println("Biogasverbrauch per Assignment:");
	  traktoren.avgBiogasConsuptionPerAssignment();
	  System.out.println("Saescharen per Motor:");
	  traktoren.minMaxSowingCoulters();
	  System.out.println("Duengerkapazitaet per Motor:");
	  traktoren.avgFertilizerCapacity();
	  System.out.println();
	}
}
