import java.util.ArrayList;
import java.util.Date;

class MusikstueckContainer {
    private ArrayList<Musikstueck> list;

    public MusikstueckContainer() {
        this.list = new ArrayList<Musikstueck>();
    }

    public void addElement(Musikstueck element) {
        list.add(element);
    }

    public void removeElement(Musikstueck element) {
        list.remove(element);
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
