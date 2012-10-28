package Buchung;

import java.util.Date;

abstract public class Kosten
    extends AbstractBuchung
{

	/**
	 * Precondition: Wert muss positiv sein, da Kosten absolut angegeben werden. Sie werden allerdings durch den Konstruktor negiert
	 * Precondition: datum muss != null sein
	 * Invariantion: Wert im Objekt ist negativ (oder 0)
	 */
	protected Kosten(float wert, Date datum) {
		super(-wert, datum);
	}
}
