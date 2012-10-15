import java.util.Date;

public class Musikgruppe {
    private TerminContainer termincontainer;
    private MitgliedContainer mitgliedcontainer;
    // pirvate Musikstueckcontainer musikstueckcontainer;

    private String name;
    private String ausrichtung;

    public Musikgruppe(String name, String ausrichtung) {
        this.name = name;
        this.ausrichtung = ausrichtung;
        this.termincontainer = new TerminContainer();
        this.mitgliedcontainer = new MitgliedContainer();
        //this.musikstueckcontainer = new Musikstueckcontainer();
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

   /* public Musikstueckcontainer getMusikstueckcontainer() {
        return musikstueckcontainer;
    }*/

    @Override
    public String toString() {
        return "Musikgruppe{" + "name=" + name + ", ausrichtung=" + ausrichtung + '}';
    }

    /**
     * <p> Fügt ein aktives Mitglied hinzu, falls nicht bereits ein aktives Mitglied
     * mit diesem Namen existiert</p>
     *
     * <p> Gibt es bereits ein aktives Mitglied mit diesem Namen wird eine entsprechende
     * Meldung auf dem Standardoutput ausgegeben</p>
     *
     * @param String name
     * @param long telnum
     * @param String instrument
     */
    public void addMitglied(String name, long telnum, String instrument){
        mitgliedcontainer.addMitglied(name,telnum,instrument);
    }

    /**
     * <p>Gibt eine formattierte, unsortierte Liste aller aktueller Mitglieder auf dem
     * Standardoutput zurück</p>
     */
    public void printLineup(){
        System.out.println(mitgliedcontainer.printCurrentMitglieder());
    }

    /**
     * <p>Gibt eine formattierte, unsortierte Liste aller Mitglieder zum angegebenen Zeitpunkt
     * auf dem Standardoutput zurück</p>
     *
     * @param date das Datum, zu welchem die Mitglieder ausgegeben werden sollen
     */
    public void printLineup(Date date){
        System.out.println(mitgliedcontainer.printMitgliederAt(date));
    }

    /**
     * <p> Sucht nach einem aktiven Mitglied mit dem gegebenen Namen
     * und setzt das Austrittsdatum auf das aktuelle Datum</p>
     *
     * <p> Gibt es kein aktives Mitglied mit diesem Namen wird eine entsprechende
     * Meldung auf dem Standardoutput ausgegeben</p>
     *
     * @param String name: der Name des zu entfernenden Mitglieds
     */
    public void removeMitglied(String name){
        mitgliedcontainer.removeMitglied(name);
    }

}
