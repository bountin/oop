package Buchung;

import java.util.Date;

abstract public class Kosten
    extends AbstractBuchung
{
	protected Kosten(float wert, Date datum) {
		super(-wert, datum);
		assert wert >= 0 : "Kosten müssen positiv sein";
	}
}
