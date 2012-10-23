package Buchung;

import java.util.ArrayList;
import java.util.List;
import Buchung.Filter.AbstractFilter;

public class BuchungContainer {
	private ArrayList<AbstractBuchung> buchungen = new ArrayList<AbstractBuchung>();

	public void addBuchung(AbstractBuchung buchung) {
		this.buchungen.add(buchung);
	}

	public void removeBuchung(AbstractBuchung buchung) {
		this.buchungen.remove(buchung);
	}

	public int summe(List<AbstractFilter> filter) {
		int summe = 0;
		// Iterate over all buchungen and check all filter
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
