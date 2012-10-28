package Buchung;

import java.util.ArrayList;
import java.util.List;
import Buchung.Filter.AbstractFilter;

public class BuchungContainer {
	private ArrayList<AbstractBuchung> buchungen = new ArrayList<AbstractBuchung>();

	/**
	 * Precondition: Buchung != null
	 * Postcondition: Buchung ist in der Liste enthalten
	 */
	public void addBuchung(AbstractBuchung buchung) {
		this.buchungen.add(buchung);
	}

	/**
	 * Precondition: Buchung != null
	 * Postcondition: Buchung ist nicht mehr in der Liste enthalten, unabhaengig ob sie zuvor drinnen war oder nicht)
	 */
	public void removeBuchung(AbstractBuchung buchung) {
		this.buchungen.remove(buchung);
	}

	/**
	 * NOTE: Die filter werden mit UND verknueft, also muessen alle erfuellt werden, damit eine Buchung miteinflieszt
	 * Precondition: filter ist eine Liste von filter (und != null)
	 * Postcondition: Liefert einen Saldo der gefilterten Buchungen dieses Containers
	 */
	public int summe(List<AbstractFilter> filter) {
		int summe = 0;

		buchung_loop:
		for (AbstractBuchung b: buchungen) {
			for (AbstractFilter f: filter) {
				if (!f.isOK(b)) {
					continue buchung_loop;
				}
			}
			summe += b.getWert();
		}
		return summe;
	}
}
