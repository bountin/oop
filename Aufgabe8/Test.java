import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {

	    System.out.println("*******************");
	    System.out.println("***** Autoren *****");
	    System.out.println("*******************");

	    int i = 0;

	    Class[] classes = new Class[100];
	    classes[i++] = Ausruestung.class;
	    classes[i++] = Autor.class;
	    classes[i++] = Bauernhof.class;
	    classes[i++] = BauernhofContainer.class;
	    classes[i++] = DieselTraktor.class;
	    classes[i++] = DrillAusruestung.class;
	    classes[i++] = DuengeAusruestung.class;
	    classes[i++] = GasTraktor.class;
	    classes[i++] = GenericContainer.class;
	    classes[i++] = HofIdentifiable.class;
	    classes[i++] = Traktor.class;
	    classes[i++] = TraktorContainer.class;

	    for (Class<?> c: classes) {
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
