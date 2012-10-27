package Buchung.Filter;

import Buchung.AbstractBuchung;

import java.util.Date;

public class ZeitraumFilter
	extends AbstractFilter
{
	private Date startDate;
	private Date endDate;

	/**
	 * Filter um nur Buchungen in einem Zeitraum zu erhalten
	 * @param startDate
	 * @param endDate
	 */
	public ZeitraumFilter(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public boolean isOK(AbstractBuchung buchung) {
		Date buchungDate = buchung.getDatum();

		return (startDate.before(buchungDate) || startDate.equals(buchungDate)) &&
			(endDate.after(buchungDate) || endDate.equals(buchungDate));
	}
}
