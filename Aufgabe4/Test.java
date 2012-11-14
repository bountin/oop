import sun.java2d.loops.ScaledBlit;

import java.lang.System;

/**
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */


/**
 * Alle Klassen sind direkt oder transitiv Untertypen von Pict
 *
 * ClearBox ist ein Untertyp von Box, da das inhaltliche Constraint genauer wird und die Klassen ansonsten identisch sind
 * Box ist kein Untertyp von ClearBox, da das inhaltliche Constraint nschaerfer werden wuerde
 *
 * DarkBox ist ein Untertyp von Box, da das inhaltliche Constraint liberaler wird und DarkBox die sonstigen Elemente von Box uebernimmt
 * Das gleiche gilt auch fuer FreeBox, also ist DarkBox auch ein Untertyp von FreeBox
 *  - Java unterstuetzt keine Mehrfachvererbung von konkreten Klassen, deshalb wurde nur von Box abgeleitet
 * Da DarkBox eine zusaetliche Methode implementiert, kann weder Box noch FreeBox ein Untertyp von DarkBox sein.
 *
 * Alle moeglichen Varianten von Repeated<P> (also P Element aus {P universell, Pict, Char, Box etc.} sind Untertypen von Freebox
 * FreeBox ist ein Untertyp von allen moeglichen Repeated<P>
 *
 *
 */

public class Test {

    public static void main(String[] args) {

        /* BOX */

        System.out.println("Tests fuer BOX");
        System.out.println("-Tests der Grundlegenden Funktionalitaet von BOX");
        System.out.println("--Test der Einhaltung der Eingabeconstraints durch ersetzen");
        System.out.println("--Erwartung: .");

        Box box = new Box(' ', 'x', 0, 0);
        System.out.println(box.toString());

        System.out.println("--Test des korrekten Skalierens");
        System.out.println("--Erwartung: eine 4x8 Box");
        box = new Box('s', 'm', 1, 2);
        box.scale(3.1);
        System.out.println(box.toString());

        System.out.println("-Test der Ersetzbarkeit Boxes fuer Pict");
        System.out.println("-Erwartung: eine 2x2 Box");
        Pict box2 = new Box('/', '\\', 1, 1);
        box2.scale(2.0);
        System.out.println(box2.toString());

        /*CLEARBOX*/

        System.out.println("Tests fuer ClearBox");
        System.out.println("-Test der Einhaltung der Character Beschraenkung");
        System.out.println("-Erwartung: ***");
        ClearBox cbox = new ClearBox(3, 1);
        System.out.println(cbox.toString());

        System.out.println("-Test der korrekten Funktion von getRatio()");
        System.out.println("-Erwartung: 3");
        cbox = new ClearBox(4.5, 1.5);
        System.out.println(cbox.getRatio());

        System.out.println("-Test der Ersetzbarkeit ClearBoxes fuer Box");
        System.out.println("-Erwartung: eine 3x5 Box");
        Box b = new ClearBox(3, 5);
        System.out.println(b.toString());

        /*REPEATED*/
        System.out.println("Tests fuer Repeated");
        System.out.println("-Erzeuge ein 4x2 Repeated<Integer>");
        System.out.println("-Erwartung: eine 4x2 Box mit Zahlen von 1 bis 8");
        Integer[][] ifield = {{1, 2, 3, 4},
            {5, 6, 7, 8}};
        Repeated<Integer> irep = new Repeated<Integer>(ifield);
        System.out.println(irep);

        System.out.println("--Test von scale() mit 1.5");
        System.out.println("--Erwartung: eine 6x3 Box mit wiederholenden Zahlen");
        irep.scale(1.5);
        System.out.println(irep);

        System.out.println("--Test von scale() mit 0.1");
        System.out.println("--Erwartung: eine 1x1 Box mit Inhalt '1'");
        irep.scale(0.1);
        System.out.println(irep);

        System.out.println("-Erzeugt ein 3x2 Repeated<String> mit unterschiedlich langen Strings");
        System.out.println("-Erwartung: eine 30x4 Box mit unterschiedlichen Inhalten die mit Leerzeichen aufgeüllt sind");
        String[][] sfield = {{"hallo welt", "test", "123\n456"},
            {"###\n####", "", "abcdefghij"}};
        Repeated<String> srep = new Repeated<String>(sfield);
        System.out.println(srep);

        System.out.println("--Test von scale() mit 2.0");
        System.out.println("--Erwartung: eine 90x12 Box die die Inhalte wiederholt");
        srep.scale(3.0);
        System.out.println(srep);

        System.out.println("--Test von scale() mit 0.5");
        System.out.println("--Erwartung: eine 50x6 Box die die Inhalte wiederholt");
        srep.scale(0.5);
        System.out.println(srep);

        /*FREEBOX*/
        System.out.println("Tests fuer FreeBox");
        System.out.println("-Erzeuge ein 4x2 FreeBox");
        System.out.println("-Erwartung: eine 4x2 Box mit den Zeichen a bis h");
        char[][] cfield = {{'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'}};
        FreeBox cfreebox = new FreeBox(cfield);
        System.out.println(cfreebox);

        System.out.println("--Test von scale() mit 1.5");
        System.out.println("--Erwartung: eine 6x3 Box mit wiederholenden Buchstaben");
        cfreebox.scale(1.5);
        System.out.println(cfreebox);

        System.out.println("--Test von scale() mit 0.1");
        System.out.println("--Erwartung: eine 1x1 Box mit Inhalt 'a'");
        cfreebox.scale(0.1);
        System.out.println(cfreebox);

        /*DARKBOX*/
        System.out.println("Tests fuer DarkBox");
        System.out.println("-Erzeuge ein 2x4 DarkBox");
        System.out.println("-Erwartung: eine 2x4 Box mit den Zeichen '#'");
        DarkBox dbox = new DarkBox('#', 2, 4);
        System.out.println(dbox);
        System.out.println("--Test von scale() mit 0.3");
        System.out.println("--Erwartung: eine 1x2 Box mit den Zeichen '#'");
        dbox.scale(0.3);
        System.out.println(dbox);
        System.out.println("--Test von setCharacter() mit '*'");
        System.out.println("--Erwartung: eine 1x2 Box mit den Zeichen '*'");
        dbox.setCharacter('*');
        System.out.println(dbox);

	    /*************
	     *** SCALED **
	     ************/
	    System.out.println("Tests fuer Scaled");
	    System.out.println("-Erwartung: Zwei X untereinander, zwei @ untereinander; nächste Zeile: 3x3 # und ein Minuszeichen");
	    DarkBox[][] scaled_param = new DarkBox[2][2];
	    scaled_param[0][0] = new DarkBox('X', 1, 2);
	    scaled_param[0][1] = new DarkBox('@', 2, 1);
	    scaled_param[1][0] = new DarkBox('#', 3, 3);
	    scaled_param[1][1] = new DarkBox('-', 1, 1);
	    Scaled<Pict> scaled = new Scaled<Pict>(scaled_param);
	    System.out.println(scaled.toString());

	    System.out.println("-Erwartung: 2x4 X, 2x4 @; nächste Zeile: 6x6 # und 2x2 Minuszeichen (scaled von vorhin mit 2)");
	    scaled.scale(2);
	    System.out.println(scaled.toString());

	    System.out.println("-Erwartung: X@, nächste Zeile: #- (scaled von vorhin mit 0.1)");
	    scaled.scale(0.1);
	    System.out.println(scaled.toString());
    }
}
