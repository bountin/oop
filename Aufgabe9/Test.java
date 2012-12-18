
public class Test {

	public static void main(String args[]){
		String r = "rund";
		String m = "mond";
		String w = "weihnachtsmann";
		
		String mu = "muerb";
		String zi = "zimtstern";
		String sc = "schokolade";
		
		String mar = "marmelade";
		String sch = "schokolade";
		
		Position p1 = new Position(11, r, mu, null);
		Position p2 = new Position(5, r, zi, sch);
		Position p3 = new Position(3, w, sc, sch);
		Position p4 = new Position(7, w, zi, null);
		Position p5 = new Position(9, m, zi, null);
		Position p6 = new Position(1, m, sc, mar);
		Position p7 = new Position(4, r, zi, null);
		Position p8 = new Position(3, r, sc, sch);
		Position p9 = new Position(1, w, zi, mar);
		Position p10 = new Position(6, m, mu, null);
		Position p11 = new Position(22, w, sc, mar);
		Position p12 = new Position(4, r, mu, null);
		
		Bestellung b1 = new Bestellung();
		b1.addPosition(p1);
		b1.addPosition(p2);
		b1.addPosition(p3);
		b1.addPosition(p4);
		b1.addPosition(p5);
		
		Bestellung b2 = new Bestellung();
		b2.addPosition(p3);
		b2.addPosition(p3);
		b2.addPosition(p3);
		b2.addPosition(p3);
		b2.addPosition(p3);
		
		Bestellung b3 = new Bestellung();
		b3.addPosition(p12);
		b3.addPosition(p11);
		b3.addPosition(p10);
		b3.addPosition(p9);
		b3.addPosition(p8);
		
		Baeckerei back = new Baeckerei();
		
		System.out.println("=====TEST1====");
		b1.drucke();
		Keksdose kd = back.bestellungBearbeiten(b1);
		System.out.println("=========");
		kd.inhalt();
		System.out.println("=====TEST2====");
		b2.drucke();
		kd = back.bestellungBearbeiten(b2);
		System.out.println("=========");
		kd.inhalt();
		System.out.println("=====TEST3====");
		b3.drucke();
		kd = back.bestellungBearbeiten(b3);
		System.out.println("=========");
		kd.inhalt();
	}

}
