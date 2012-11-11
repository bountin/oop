
public class Test {

	public static void main(String[] args){
		
		/* BOX */
		
		System.out.println("Tests fuer BOX");
		System.out.println("-Tests der Grundlegenden Funktionalitaet von BOX");
		System.out.println("--Test der Einhaltung der Eingabeconstraints durch ersetzen");
		System.out.println("--Erwartung: .");
		
		Box box = new Box(' ', 'x', 0, 0);
		System.out.println(box.toString());
		
		System.out.println("--Test des korrekten Skalierens");
		System.out.println("--Erwartung: eine 4x8 Box");
		box = new Box('s','m',1,2);
		box.scale(3.1);
		System.out.println(box.toString());
		
		System.out.println("-Test der Ersetzbarkeit Boxes fuer Pict");
		System.out.println("-Erwartung: eine 2x2 Box");
		Pict box2 = new Box('/','\\',1,1);
		box2.scale(2.0);
		System.out.println(box2.toString());
		
		/*CLEARBOX*/
		
		System.out.println("Tests fuer ClearBox");
		System.out.println("-Test der Einhaltung der Character Beschraenkung");
		System.out.println("-Erwartung: ***");
		ClearBox cbox = new ClearBox(3,1);
		System.out.println(cbox.toString());
		
		System.out.println("-Test der korrekten Funktion von getRatio()");
		System.out.println("-Erwartung: 3");
		cbox = new ClearBox(4.5,1.5);
		System.out.println(cbox.getRatio());
		
		System.out.println("-Test der Ersetzbarkeit ClearBoxes fuer Box");
		System.out.println("-Erwartung: eine 3x5 Box");
		Box b = new ClearBox(3,5);
		System.out.println(b.toString());
	}
}
