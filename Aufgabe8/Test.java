import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {

	    System.out.println("*******************");
	    System.out.println("***** Autoren *****");
	    System.out.println("*******************");

	    ClassContainer classes = new ClassContainer();

	    classes.add(Ausruestung.class);
	    classes.add(Autor.class);
	    classes.add(Bauernhof.class);
	    classes.add(BauernhofContainer.class);
	    classes.add(DieselTraktor.class);
	    classes.add(DrillAusruestung.class);
	    classes.add(DuengeAusruestung.class);
	    classes.add(GasTraktor.class);
	    classes.add(GenericContainer.class);
	    classes.add(HofIdentifiable.class);
	    classes.add(Traktor.class);
	    classes.add(TraktorContainer.class);

	    classes.output();
    }
}
