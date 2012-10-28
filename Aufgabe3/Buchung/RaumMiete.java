package Buchung;

import java.util.Date;

public class RaumMiete extends Kosten {

	/**
	 * Alle vererbt von Kosten:
	 * Precondition: Wert muss positiv sein, da Kosten absolut angegeben werden. Sie werden allerdings durch den Konstruktor negiert
	 * Precondition: datum muss != null sein
	 * Invariantion: Wert im Objekt ist negativ (oder 0)
	 */
	public RaumMiete(float wert, Date datum) {
		super(wert, datum);
	}
}
