package Buchung;

import java.util.Date;

abstract public class Einnahme
    extends AbstractBuchung
{
	/**
	 * Precondition & Invariante: Wert muss positiv sein
	 * Precondition: datum muss != null sein
	 */
	public Einnahme(float wert, Date datum) {
		super(wert, datum);
		assert wert >= 0 : "Einnahmen muessen positiv sein";
	}
}
