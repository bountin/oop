import java.lang.reflect.Method;

@Autor("Martin")
public class ClassContainer {
	@Autor("Martin")
	private class Box {
		Class c;
		Box next;

		public void setNext(Box next) {
			this.next = next;
		}

		public Box getNext() {
			return next;
		}

		private Box(Class c) {
			this.c = c;
		}

		public Class getClassElement() {
			return c;
		}
	}


	Box first;
	Box last;

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
