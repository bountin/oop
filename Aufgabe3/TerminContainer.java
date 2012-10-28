
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
     * Preconditon: t != null
     * Postcondition: Fügt Termin t zum Container
     */
    public void addTermin(Termin t) {
        terminlist.add(t);
    }

    /**
     * Preconditon: t != null
     * Postcondition: Entfernt Termin aus Container (falls vorhanden). Falls
     * der Termin vorhanden war wird er auf den removed Stack gepusht.
     */
    public void removeTermin(Termin t) {
        if (terminlist.remove(t)) {
            removed.push(t);
        }
    }

    /**
     * Postcondition: Gibt eine Kopie des Stacks mit allen bisher gelöschten
     * Terminen zurück
     */
    public Stack<Termin> getRemoved() {
        return (Stack<Termin>) removed.clone();
    }

    /**
     * Preconditon: from != null, to != null, to ist nach from
     * Postcondition: Gibt eine Liste mit allen Proben im entsprechenden Zeitraum
     * zurück
     */
    public List<Probe> getProben(Date from, Date to) {
        List<Probe> l = new ArrayList<Probe>();
        for (Termin t : terminlist) {
            if (t instanceof Probe
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) {
                l.add((Probe) t);
            }
        }
        return l;
    }

    /**
     * Preconditon: from != null, to != null, to ist nach from
     * Postcondition: Gibt eine Liste mit allen Auftritten im entsprechenden Zeitraum
     * zurück
     */
    public List<Auftritt> getAuftritte(Date from, Date to) {
        List<Auftritt> l = new ArrayList<Auftritt>();
        for (Termin t : terminlist) {
            if (t instanceof Auftritt
                    && t.getDatum().after(from)
                    && t.getDatum().before(to)) {
                l.add((Auftritt) t);
            }
        }
        return l;
    }

    /**
     * Preconditon: from != null, to != null, to ist nach from
     * Postcondition: Gibt eine Liste mit allen Terminen im entsprechenden Zeitraum
     * zurück
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
     * Preconditon: from != null, to != null, to ist nach from
     * Postcondition: gibt die Summe aller Mieten im entsprechenden Zeitraum
     * zurück
     * PostConfition: Rueckgabewert ist <= 0, da Mieten nur Ausgaben sind.
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
     * Preconditon: from != null, to != null, to ist nach from
     * Postcondition: gibt die Summe aller Gagen im entsprechenden Zeitraum
     * zurück
     * PostConfition: Rueckgabewert ist >= 0, da Gagen nur Einnahmen sind.
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
     * Preconditon: from != null, to != null, to ist nach from
     * Postcondition: Liefert Saldo (Gage - Miete) im angegeben Zeitraum
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

	/**
	 * Precondition: Eine Liste von Filtern muss uebergeben werden. Die Liste kann auch leer sein.
	 * Postcondition: Liefert den Saldo der Buchungen unter beruecksichtigung der gegebenen Filter
	 */
    public float getSaldo(List<AbstractFilter> filters) {
        float summe = 0;
        for (Termin t : terminlist) {
            summe += t.getBuchungContainer().summe(filters);
        }
        return summe;
    }
}
