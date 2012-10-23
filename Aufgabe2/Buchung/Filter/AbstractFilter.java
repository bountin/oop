package Buchung.Filter;

import Buchung.AbstractBuchung;

abstract public class AbstractFilter
{
	abstract public boolean isOK(AbstractBuchung buchung);
}
