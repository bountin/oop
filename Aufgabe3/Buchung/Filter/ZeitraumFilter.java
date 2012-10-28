package Buchung.Filter;

import Buchung.AbstractBuchung;

import java.util.Date;

public class ZeitraumFilter
	extends AbstractFilter
{
	private Date startDate;
	private Date endDate;

	/**
	 * Precondition: Beide Datuemer duerfen nich null sein
	 */
	public ZeitraumFilter(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * Precondition: Buchung != null
	 * Postcondition: Wahrheitswert ob Buchung auf den Filter matcht (durch Oberklasse)
	 * Postcondition: Überprüfung die Buchung im erlaubten Zeitintervall liegt
	 */
	public boolean isOK(AbstractBuchung buchung) {
		Date buchungDate = buchung.getDatum();

		return (startDate.before(buchungDate) || startDate.equals(buchungDate)) &&
			(endDate.after(buchungDate) || endDate.equals(buchungDate));
	}
}
