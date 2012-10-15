/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aufgabe1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Termincontainer {

    private List<Termin> terminlist;

    public Termincontainer() {
        terminlist = new ArrayList<Termin>();
    }

    /**
     * Fügt einen neuen Termin hinzu
     * @param t Termin
     */
    public void addTermin(Termin t) {
        terminlist.add(t);
    }    
    
    /**
     * Returnt eine Liste aller Proben im Zeitraum zwischen from und to.
     * @param from 
     * @param to
     * @return List von Proben
     */
    public List<Probe> getProben(Date from, Date to) {
        List l = new ArrayList();
        for (Termin t : terminlist) {
            if (t instanceof Probe
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) {
                l.add(t);
            }
        }
        return l;
    }

    /**
     * Returnt eine Liste aller Auftritte im Zeitraum zwischen from und to.
     * @param from
     * @param to
     * @return Liste von Auftritten
     */
    public List<Auftritt> getAuftritte(Date from, Date to) {
        List l = new ArrayList();
        for (Termin t : terminlist) {
            if (t instanceof Auftritt
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) {
                l.add(t);
            }
        }
        return l;
    }

    /**
     * Returnt eine Liste aller Termine im Zeitraum zwischen from und to.
     * @param from
     * @param to
     * @return List von Terminen
     */
    public List<Termin> getTermine(Date from, Date to) {
        List l = new ArrayList();
        for (Termin t : terminlist) {
            if (t.getDatum().after(from)
                    && t.getDatum().before(to)) {
                l.add(t);
            }
        }
        return l;
    }
    
    /**
     * Liefert Miete im angegeben Zeitraum
     * @param from
     * @param to
     * @return Miete
     */
    public float getMiete(Date from, Date to) {
        float sum = 0;   
        for (Termin t : terminlist) {
            if (t instanceof Probe
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) { 
                sum += ((Probe)t).getRaummiete();
            }
        }
        return sum;
    }

    /**
     * Liefert Gage im angegeben Zeitraum
     * @param from
     * @param to
     * @return Gage
     */
    public float getGage(Date from, Date to) {
        float sum = 0;   
        for (Termin t : terminlist) {
            if (t instanceof Auftritt
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) { 
                sum += ((Auftritt)t).getGage();
            }
        }
        return sum;        
    }    
    
    /**
     * Liefert Saldo (Gage - Miete) im angegeben Zeitraum
     * @param from
     * @param to
     * @return Saldo
     */
    public float getSaldo(Date from, Date to) {
        return getGage(from, to) - getMiete(from, to);
    }
}
