
@Autor("Undefined")
public class Bauernhof {

	private String name;

	@Autor("Martin  ")
	Bauernhof(String name) {
		this.name = name;
	}

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
