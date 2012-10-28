
import java.util.ArrayList;

public class OrtContainer {

    private ArrayList<Ort> orte;

    /**
     * Postcondition: Erzeugt einen neuen (leeren) Ortscontainer.
     */
    public OrtContainer() {
        this.orte = new ArrayList<Ort>();
    }

    /**
     * Precondition: ort != null
     * Postcondition: Ort wird zum Container hinzugefügt
     */
    public void addOrt(Ort ort) {
        orte.add(ort);
    }

    public ArrayList<Ort> getAlleOrte() {
        return (ArrayList<Ort>) orte.clone();
    }

    /**
     * Precondition: Erwartet Namen mit gesuchtem Ort 
     * Postcondition: Liste mit allen Orten deren Name dem Übergebenen entspricht.
     */
    public ArrayList<Ort> getOrtbyName(String name) {
        ArrayList<Ort> l = new ArrayList<Ort>();
        for (Ort o : orte) {
            if (o.getName().equals(name)) {
                l.add(o);
            }
        }
        return l;
    }
}
