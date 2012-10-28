package Buchung.Filter;

import Buchung.AbstractBuchung;

abstract public class AbstractFilter
{
	/**
	 * Precondition: Buchung != null
	 * Postcondition: Wahrheitswert ob Buchung auf den Filter matcht
	 */
	abstract public boolean isOK(AbstractBuchung buchung);
}
