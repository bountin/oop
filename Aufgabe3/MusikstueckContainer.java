import java.util.ArrayList;
import java.util.Date;

public class MusikstueckContainer {
    private ArrayList<Musikstueck> list;

    public MusikstueckContainer() {
        this.list = new ArrayList<Musikstueck>();
    }

	/**
	 * Precondition: element und eintragung duerfen nicht null sein
	 * Postcondition: element ist in der internen Liste eingetragen
	 * Postcondition: eintragung ist im element vermerkt
	 */
    public void addElement(Musikstueck element, Date eintragung) {
        list.add(element);
        element.setEintragung(eintragung);
    }

	/**
	 * Precondition: element und austragung duerfen nicht null sein
	 * Postcondition: element ist immer noch in der internen Liste eingetragen
	 * Postcondition: austragung ist im element vermerkt
	 */
    public void removeElement(Musikstueck element, Date austragung) {
        element.setAustragung(austragung);
    }

	/**
	 * Precondition: datum darf nicht null sein
	 * Postcondition: Eine Liste der am gegebenen Datum aktiven Musikstuecke wird zurueck gegeben in einer neu erstellten Liste
	 */
    public ArrayList<Musikstueck> getList(Date datum) {
        ArrayList<Musikstueck> returnedList = new ArrayList<Musikstueck>();
        for (Musikstueck element: list) {
            if (element.isActive(datum)) {
                returnedList.add(element);
            }
        }

        return returnedList;
    }
}
