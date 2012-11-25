import java.lang.String;
import java.util.HashMap;

class AndroideList
{
	private HashMap<String, Androide> list;

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

		if (list.containsKey(androide.getSerial())) {
			// Alter the saved Androide
			list.get(androide.getSerial()).alter(androide);
		} else {
			// Insert the new androide
			list.put(androide.getSerial(), androide);
		}

		return androide;
	}
}
