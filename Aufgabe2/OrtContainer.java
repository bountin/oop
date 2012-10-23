
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class OrtContainer {
    private ArrayList<Ort> orte;

    /**
     * Erzeugt einen neuen (leeren) Ortscontainer.
     */
    public OrtContainer() {
        this.orte = new ArrayList<Ort>();
    }
    
    /**
     * Speichert einen Ort im Container
     * @param ort Ort
     */
    public void addOrt(Ort ort) {
        orte.add(ort);
    }
    
    /**
     * @return Kopie der Liste aller Orte
     */
    public ArrayList<Ort> getAlleOrte() {
        return (ArrayList<Ort>)orte.clone();
    }
    
    /** Returnt Orte mit dem übergebenen Namen.
     * @param name Name
     * @return Liste mit Orten
     */
    public ArrayList<Ort> getOrtbyName(String name) {
        ArrayList<Ort> l = new ArrayList<Ort>();
        for(Ort o : orte) {
            if(o.getName().equals(name)) {
                l.add(o);
            }
        }
        return l;
    }
    
}
