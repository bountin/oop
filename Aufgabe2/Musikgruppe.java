public class Musikgruppe {
    private TerminContainer termincontainer;
    private MitgliedContainer mitgliedcontainer;
    private MusikstueckContainer musikstueckcontainer;

    private String name;
    private String ausrichtung;

    public Musikgruppe(String name, String ausrichtung) {
        this.name = name;
        this.ausrichtung = ausrichtung;
        this.termincontainer = new TerminContainer();
        this.mitgliedcontainer = new MitgliedContainer();
        this.musikstueckcontainer = new MusikstueckContainer();
    }

    public String getName() {
        return name;
    }

    public String getAusrichtung() {
        return ausrichtung;
    }

    public MitgliedContainer getMitgliedContainer() {
        return mitgliedcontainer;
    }

    public TerminContainer getTerminContainer() {
        return termincontainer;
    }

    public MusikstueckContainer getMusikstueckContainer() {
        return musikstueckcontainer;
    }

    @Override
    public String toString() {
        return "Musikgruppe{" + "name=" + name + ", ausrichtung=" + ausrichtung + '}';
    }
}
