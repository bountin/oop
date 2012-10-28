package Buchung.Filter;

import Buchung.AbstractBuchung;

import java.util.ArrayList;

public class TypFilter extends AbstractFilter {

	private ArrayList<String> classList;

	public TypFilter() {
		this.classList = new ArrayList<String>();
	}

	/**
	 * Precondition: className != null und der className muss mit einer Klasse übereinstimmen, die von der Klasse AbstractBuchung ableitet
	 * Postcondition: In der internen Klassenliste ist der neue Klassenname enthalten
	 *
	 * GUT: Durch die Klassenhierachie kann ueberprueft werden ob die Klasse erlaubt ist. Ausserdem muss der Filter bei neuen Buchungsklassen nicht veraendert werden.
	 */
	public void addAllowedClass(String className) throws Exception {
		if (! AbstractBuchung.class.isAssignableFrom(Class.forName(className)) ) {
			throw new Exception("Not implemented AbstractBuchung");
		}

		classList.add(className);
	}

	/**
	 * Precondition: Buchung != null
	 * Postcondition: Wahrheitswert ob Buchung auf den Filter matcht (durch Oberklasse)
	 * Postcondition: Überprüfung ob die Klasse der Buchung in der Liste der erlaubten Klassen ist
	 *
	 * ERROR: Eigentlich sollten auch Obertypen von konkreten Klassen, wie zum Beispiel alle Einnahmen moeglich sein. Dieser Fall ist leider nicht getestet und auf ihn wurde vergessen.
	 */
	public boolean isOK(AbstractBuchung buchung) {
		return this.classList.contains(buchung.getClass().getName());
	}
}
