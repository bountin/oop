import java.util.ArrayList;
import java.util.Date;

class MusikstueckContainer {
    private ArrayList<Musikstueck> list;

    public MusikstueckContainer() {
        this.list = new ArrayList<Musikstueck>();
    }

    public void addElement(Musikstueck element, Date eintragung) {
        list.add(element);
        element.setEintragung(eintragung);
    }

    public void removeElement(Musikstueck element, Date austragung) {
        element.setAustragung(austragung);
    }

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
