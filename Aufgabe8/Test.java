import java.lang.reflect.Method;

@Autor("Martin")
public class Test {

	@Autor("Martin")
	public static void main(String[] args) {

		System.out.println("Erstelle drei Bauernhoefe und fuege sie zu Container hinzu");

		BauernhofContainer bauernhoefe = new BauernhofContainer();

		Bauernhof b1 = new Bauernhof("Bauernhof 1");
		Bauernhof b2 = new Bauernhof("Bauernhof 2");
		Bauernhof b3 = new Bauernhof("Bauernhof 3");

		bauernhoefe.add(b1);
		bauernhoefe.add(b2);
		bauernhoefe.add(b3);

		println("Bauernhof 1 vorhanden: " + (bauernhoefe.get("Bauernhof 1") == b1));
		println("Bauernhof 2 vorhanden: " + (bauernhoefe.get("Bauernhof 2") == b2));
		println("Bauernhof 3 vorhanden: " + (bauernhoefe.get("Bauernhof 3") == b3));

		println(""); /**************************************/

		println("Fuege einen weiteren Bauernhof mit gleichem Namen hinzu (Sollte nicht aufgenommen werden)");
		Bauernhof b3_2 = new Bauernhof("Bauernhof 3");
		bauernhoefe.add(b3_2);

		println("Neuer Bauernhof 3 ist nicht vorhanden: " + (bauernhoefe.get("Bauernhof 3") != b3_2));
		println("Alter Bauernhof 3 ist noch vorhanden: " + (bauernhoefe.get("Bauernhof 3") == b3));

		println(""); /**************************************/

		println("Generieren einiger Traktoren und hinzufuegen zu Bauernhoefen");

		GasTraktor t1 = new GasTraktor(1, new DrillAusruestung(5));
		GasTraktor t2 = new GasTraktor(2, new DuengeAusruestung(3.14));
		DieselTraktor t3 = new DieselTraktor(3, new DrillAusruestung(20));
		DieselTraktor t4 = new DieselTraktor(4, new DuengeAusruestung(42.12));

		b2.insertTraktor(t1);
		b2.insertTraktor(t2);
		b2.insertTraktor(t3);

		b3.insertTraktor(t2);
		b3.insertTraktor(t4);

		println("Traktor 1 in B2 vorhanden: " + (b2.getTraktor(1) == t1));
		println("Traktor 2 in B2 vorhanden: " + (b2.getTraktor(2) == t2));
		println("Traktor 3 in B2 vorhanden: " + (b2.getTraktor(3) == t3));
		println("Traktor 4 nicht in B2 vorhanden: " + (b2.getTraktor(4) == null));

		println("Traktor 1 nicht in B3 vorhanden: " + (b3.getTraktor(1) == null));
		println("Traktor 2 in B3 vorhanden: " + (b3.getTraktor(2) == t2));
		println("Traktor 3 nicht in B3 vorhanden: " + (b3.getTraktor(3) == null));
		println("Traktor 4 in B3 vorhanden: " + (b3.getTraktor(4) == t4));

		println("T1 hat DrillAusruestung: " + (t1.getAusruestung() instanceof DrillAusruestung));
		println("T3 hat DrillAusruestung: " + (t3.getAusruestung() instanceof DrillAusruestung));
		println("T1 Saeschere: " + (((DrillAusruestung)t1.getAusruestung()).getSaeschare_anzahl() == 5));
		println("T3 Saeschere: " + (((DrillAusruestung)t3.getAusruestung()).getSaeschare_anzahl() == 20));

		println("T2 hat DuengeAusruestung: " + (t2.getAusruestung() instanceof DuengeAusruestung));
		println("T4 hat DuengeAusruestung: " + (t4.getAusruestung() instanceof DuengeAusruestung));
		println("T2 Duengekapazitaet: " + (((DuengeAusruestung)t2.getAusruestung()).getKapazitaet() == 3.14));
		println("T4 Duengekapazitaet: " + (((DuengeAusruestung)t4.getAusruestung()).getKapazitaet() == 42.12));

		println(""); /**************************************/

		println("Hinzufuegen und entfernen einiger Traktoren in B1");

		b1.insertTraktor(t1);
		println("T1 ist in B1: " + (b1.getTraktor(1) == t1));

		b1.removeTraktorViaNummer(1);
		println("T1 ist nicht mehr in B1: " + (b1.getTraktor(1) == null));

		println(""); /**************************************/

		println("Betriebsstunden eines Traktors ueberpruefen");

		println("T1 hat noch keine Betriebsstunden: " + (t1.getBetriebsdauer() == 0));
		t1.erhoehe_betriebsdauer(5);
		println("T1 hat erhoehte Betriebsstunden 1: " + (t1.getBetriebsdauer() == 5));
		t1.erhoehe_betriebsdauer(10);
		println("T1 hat erhoehte Betriebsstunden 2: " + (t1.getBetriebsdauer() == 15));

		println("T2 hat immer noch keine Betriebststunden: " + (t2.getBetriebsdauer() == 0));

		println(""); /**************************************/

		println("Erhoehe Verbrauch von Dieseltraktoren um 5 und von Gastraktoren um 3.14 von Bauernhof 2");
		Traktor tx1 = ((Bauernhof) bauernhoefe.get("Bauernhof 2")).getTraktor(1);
		Traktor tx2 = ((Bauernhof) bauernhoefe.get("Bauernhof 2")).getTraktor(2);
		Traktor tx3 = ((Bauernhof) bauernhoefe.get("Bauernhof 2")).getTraktor(3);
		Traktor tx4 = ((Bauernhof) bauernhoefe.get("Bauernhof 2")).getTraktor(4);

		erhoeheVerbrauchFuerTest(tx1);
		erhoeheVerbrauchFuerTest(tx2);
		erhoeheVerbrauchFuerTest(tx3);
		erhoeheVerbrauchFuerTest(tx4);

		println("T1 hat Verbrauch von 3.14: " + (t1.getVerbrauch() == 3.14));
		println("T2 hat Verbrauch von 3.14: " + (t2.getVerbrauch() == 3.14));
		println("T3 hat Verbrauch von 5: " + (t3.getVerbrauch() == 5));
		println("T4 hat Verbrauch von 0: " + (t4.getVerbrauch() == 0));

		println(""); /**************************************/

		println("Aenderung der Einsatzart");

		println("T3 hat DrillAusruestung: " + (t3.getAusruestung() instanceof DrillAusruestung));
		println("T3 Saeschere: " + (((DrillAusruestung)t3.getAusruestung()).getSaeschare_anzahl() == 20));

		println("");
		println("T3 erhaelt DuengeAusruestung mit 55.55 Kapazitaet");
		t3.aendere_ausruestung(new DuengeAusruestung(55.55));

		println("T3 hat DuengeAusruestung: " + (t3.getAusruestung() instanceof DuengeAusruestung));
		println("T3 Kapazitaet: " + (((DuengeAusruestung)t3.getAusruestung()).getKapazitaet() == 55.55));

		println(""); /**************************************/
		println("***** Statistiken *****");

		((Bauernhof) bauernhoefe.get("Bauernhof 1")).outputStats();
		((Bauernhof) bauernhoefe.get("Bauernhof 2")).outputStats();
		((Bauernhof) bauernhoefe.get("Bauernhof 3")).outputStats();

		println(""); /**************************************/
		System.out.println("***** Autoren *****");

		ClassContainer classes = new ClassContainer();

		classes.add(Ausruestung.class);
		classes.add(Autor.class);
		classes.add(Bauernhof.class);
		classes.add(BauernhofContainer.class);
		classes.add(ClassContainer.class);
		classes.add(DieselTraktor.class);
		classes.add(DrillAusruestung.class);
		classes.add(DuengeAusruestung.class);
		classes.add(GasTraktor.class);
		classes.add(GenericContainer.class);
		classes.add(HofIdentifiable.class);
		classes.add(Test.class);
		classes.add(Traktor.class);
		classes.add(TraktorContainer.class);

		classes.output();
	}

	@Autor("Martin")
	private static void erhoeheVerbrauchFuerTest(Traktor t) {
		if (t instanceof GasTraktor) {
			((GasTraktor) t).incVerbrauch(3.14);
		} else if (t instanceof DieselTraktor) {
			((DieselTraktor) t).incVerbrauch(5);
		}
	}

	@Autor("Martin")
	private static void println(String str) {
		System.out.println(str);
	}
}
