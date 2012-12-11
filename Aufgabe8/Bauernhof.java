
@Autor("Undefined")
public class Bauernhof {

	// Identifizierender Name des Bauernhofes
	private String name;

	/**
	 * name muss ein gueltiger String sein
	 */
	@Autor("Martin")
	Bauernhof(String name) {
		this.name = name;
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
		// XXX Implement
	}

	@Autor("Undefined")
	public void removeTraktorViaNummer(int nummer) {
		// XXX Implement
	}

	// XXX Implement Statistik Methods
}
