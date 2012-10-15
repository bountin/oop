import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Termincontainer {

    private ArrayList<Termin> terminlist;

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
        List<Probe> l = new ArrayList<Probe>();
        for (Termin t : terminlist) {
            if (t instanceof Probe
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) {
                l.add((Probe)t);
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
        List<Auftritt> l = new ArrayList<Auftritt>();
        for (Termin t : terminlist) {
            if (t instanceof Auftritt
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) {
                l.add((Auftritt)t);
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
        List<Termin> l = new ArrayList<Termin>();
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
