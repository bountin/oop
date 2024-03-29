import Buchung.Filter.AbstractFilter;
import Buchung.Filter.TypFilter;
import Buchung.Filter.ZeitraumFilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class TerminContainer {

    private ArrayList<Termin> terminlist;
    private Stack<Termin> removed;

    public TerminContainer() {
        terminlist = new ArrayList<Termin>();
        removed = new Stack<Termin>();
    }

    /**
     * Fügt einen neuen Termin hinzu
     * @param t Termin
     */
    public void addTermin(Termin t) {
        terminlist.add(t);
    }

    /**
     * Entfernt Termin
     * @param t Termin
     */
    public void removeTermin(Termin t) {
        if(terminlist.remove(t)) {
            removed.push(t);
        }
    }


    /**
     * Gibt ein Kopie des Stacks mit den gelöschten Terminen zurück
     * @return Stack mit Terminen
     */
    public Stack<Termin> getRemoved() {
        return (Stack<Termin>)removed.clone();
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
     * @deprecated
     * @param from
     * @param to
     * @return Miete
     */
    public float getMiete(Date from, Date to) throws Exception {
	    ArrayList<AbstractFilter> filters = new ArrayList<AbstractFilter>();
	    filters.add(new ZeitraumFilter(from, to));
	    TypFilter typFiler = new TypFilter();
	    typFiler.addAllowedClass("Buchung.RaumMiete");
	    filters.add(typFiler);
	    return this.getSaldo(filters);
    }

    /**
     * Liefert Gage im angegeben Zeitraum
     * @deprecated
     * @param from
     * @param to
     * @return Gage
     */
    public float getGage(Date from, Date to) throws Exception {
	    ArrayList<AbstractFilter> filters = new ArrayList<AbstractFilter>();
	    filters.add(new ZeitraumFilter(from, to));
	    TypFilter typFiler = new TypFilter();
	    typFiler.addAllowedClass("Buchung.Gage");
	    filters.add(typFiler);
	    return this.getSaldo(filters);
    }

    /**
     * Liefert Saldo (Gage - Miete) im angegeben Zeitraum
     * @deprecated
     * @param from
     * @param to
     * @return Saldo
     */
    public float getSaldo(Date from, Date to) throws Exception {
	    ArrayList<AbstractFilter> filters = new ArrayList<AbstractFilter>();
	    filters.add(new ZeitraumFilter(from, to));
	    TypFilter typFiler = new TypFilter();
	    typFiler.addAllowedClass("Buchung.RaumMiete");
	    typFiler.addAllowedClass("Buchung.Gage");
	    filters.add(typFiler);
	    return this.getSaldo(filters);
    }

	public float getSaldo(List<AbstractFilter> filters) {
		float summe = 0;
		for (Termin t: terminlist) {
			summe += t.getBuchungContainer().summe(filters);
		}
		return summe;
	}
}
