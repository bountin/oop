import java.lang.Iterable;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class AndroideList implements Iterable<Androide>
{
	private HashMap<String, Androide> list;
	private ArrayList<Androide> sortedList;

    public AndroideList() {
        this.list = new HashMap<String, Androide>();
        this.sortedList = new ArrayList<Androide>();
    }
    
    

	// Einfuegen des Androiden in Liste, wenn er der Verordnung entspricht
	// Aenderung des Androiden, wenn er bereits in der Liste existiert
	// -
	// Rueckgabe des Androiden, wenn Einfuege- oder Aenderungsoperation erfolgreich
	// Null andernfalls (wenn die Verordnung verletzt wurde)
	public Androide insert(Androide androide)
	{
		if (androide.check() == false) {
			return null;
		}

		Androide andr = list.get(androide.getSerial());

		if (andr != null) {
			// Alter the saved Androide
	//		Androide changed = list.get(androide.getSerial());
    //       changed.alter(androide);
		} else {
			// Insert the new androide
			list.put(androide.getSerial(), androide);
			sortedList.add(androide);
		}

		return androide;
	}

    @Override
	public Iterator<Androide> iterator()
	{
		return sortedList.iterator();
	}
    
    public String find (String serial) {
        Androide a = list.get(serial);
        if(a == null) {
            return null;
        }else {
          return a.toString();
        }   
    }
}
