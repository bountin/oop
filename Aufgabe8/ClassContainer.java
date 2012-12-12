import java.lang.reflect.Method;

@Autor("Martin")
public class ClassContainer {
	@Autor("Martin")
	private class Box {
		// KlassenObjekt der Box
		Class c;

		// Einfach verkettete Liste, Nachfolger
		// Null bedeutet Listenende
		Box next;

		// next muss Box sein oder null
		public void setNext(Box next) {
			this.next = next;
		}

		// Rueckgabe von Nachfolger, oder null falls kein Nachfolger gesetzt
		public Box getNext() {
			return next;
		}

		// c muss ein Class Objekt sein und nicht null
		private Box(Class c) {
			this.c = c;
		}

		// Rueckgabe des Class Objektes (!= null)
		public Class getClassElement() {
			return c;
		}
	}

	/*
	* Null falls leere Liste
	* Andernfalls erstes Element der Liste
	*/
	Box first;

	/**
	 * Null falls leere Liste
	 * Andernfalls letztes Element der Liste
	 * Falls nur ein Listenelement existiert gilt first == last
	 */
	Box last;

	/**
	 * c wird in Liste aufgenommen, first und last entsprechend angepasst
	 */
	public void add(Class c) {
		Box new_box = new Box(c);
		if (first == null) {
			first = new_box;
		}
		if (last != null) {
			last.setNext(new_box);
		}
		last = new_box;
	}

	// Ausgabe der Autoren der Class Objekte auf stdout
	public void output() {
		for (Box box = first; box != null; box = box.getNext()) {
			Class<?> c = box.getClassElement();
			if (c == null) {
				continue;
			}
			System.out.print(c.getName() + ": ");
			Autor class_autor = c.getAnnotation(Autor.class);
			if (class_autor == null) {
				System.out.println("Nicht definiert");
				continue;
			}

			System.out.println(class_autor.value());
			System.out.println("  Methoden:");

			for (Method m: c.getMethods()) {
				System.out.print("\t" + m.getName() + ": ");
				Autor method_autor = m.getAnnotation(Autor.class);
				if (method_autor == null) {
					System.out.println("Nicht definiert");
					continue;
				}

				System.out.println(method_autor.value());
			}
			System.out.println();
		}
	}
}
