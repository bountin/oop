package Buchung;

import java.util.Date;

abstract public class Einnahme
    extends AbstractBuchung
{
	public Einnahme(float wert, Date datum) {
		super(wert, datum);
		assert wert >= 0 : "Einnahmen müssen positiv sein";
	}
}
