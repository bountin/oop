package Buchung;

import java.util.Date;

public class Steuer extends Kosten {

	/**
	 * Alle vererbt von Kosten:
	 * Precondition: Wert muss positiv sein, da Kosten absolut angegeben werden. Sie werden allerdings durch den Konstruktor negiert
	 * Precondition: datum muss != null sein
	 * Invariantion: Wert im Objekt ist negativ (oder 0)
	 */
	public Steuer(float wert, Date datum) {
		super(wert, datum);
	}
}
