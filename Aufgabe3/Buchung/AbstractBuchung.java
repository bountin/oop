package Buchung;

import java.util.Date;

abstract public class AbstractBuchung {
    private float wert;
	private Date datum;

	/**
	 * Precondition: datum darf nicht null sein
	 */
	protected AbstractBuchung(float wert, Date datum) {
		this.wert = wert;
		this.datum = datum;
	}

	public Date getDatum() {
		return datum;
	}

    public float getWert() {
        return wert;
    }
}
