package Buchung;

import java.util.Date;

abstract public class AbstractBuchung {
    private int wert;
	private Date datum;

	protected AbstractBuchung(int wert, Date datum) {
		this.wert = wert;
		this.datum = datum;
	}

	public Date getDatum() {
		return datum;
	}

    public int getWert() {
        return wert;
    }
}
