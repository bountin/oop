package Buchung.Filter;

import Buchung.AbstractBuchung;

import java.util.ArrayList;

public class TypFilter extends AbstractFilter {

	private ArrayList<String> classList;

	public TypFilter() {
		this.classList = new ArrayList<String>();
	}

	/**
	 * @param className
	 */
	public void addAllowedClass(String className) throws Exception {
		if (! AbstractBuchung.class.isAssignableFrom(Class.forName(className)) ) {
			throw new Exception("Not implemented AbstractBuchung");
		}

		classList.add(className);
	}

	@Override
	public boolean isOK(AbstractBuchung buchung) {
		return this.classList.contains(buchung.getClass().getName());
	}
}
