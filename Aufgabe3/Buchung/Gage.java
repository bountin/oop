package Buchung;

import java.util.Date;

public class Gage extends Einnahme {

	/**
	 * Precondition & Invariante: Wert muss positiv sein (vererbt von Einnahme)
	 * Precondition: datum muss != null sein
	 */
	public Gage(float wert, Date datum) {
		super(wert, datum);
	}
}
