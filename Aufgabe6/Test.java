
import java.lang.String;
import java.lang.System;
import java.util.LinkedList;

class Test {

    public static void main(String[] args) {
        System.out.println("------ TESTS fuer INSERT und FIND ------");
        AndroideList al = new AndroideList();

        LinkedList<UmweltKomponente> kitlist1 = new LinkedList<UmweltKomponente>();
        kitlist1.add(new Sensor("Auge", 0));
        kitlist1.add(new Aktor("Arm", 10));
        SensorenAktorenKit kit1 = new SensorenAktorenKit(kitlist1);

        System.out.println("- Fuege Bauarbeiter mit Serial 1 ein. Gib mit Androide mit Serial 1 aus:");
        System.out.println(" - Erwartet: Ausgabe von Bauarbeiter 1");
        al.insert(new Bauarbeiter("1", new FesterSkin(), new SoftwareBauarbeiter(new Sicherheitsstufe4()), kit1));
        System.out.println(al.find("1"));

        LinkedList<UmweltKomponente> kitlist2 = new LinkedList<UmweltKomponente>();
        kitlist2.add(new Sensor("Auge", 0));
        kitlist2.add(new Aktor("Arm", 10));
        SensorenAktorenKit kit2 = new SensorenAktorenKit(kitlist2);

        System.out.println("- Fuege Bauarbeiter mit Serial 2 ein. Gib mit Androide mit Serial 2 aus:");
        System.out.println(" - Erwartet: null (Bauarbeiter 2 hat nicht die noetige Sicherheitsstufe)");
        al.insert(new Bauarbeiter("2", new FesterSkin(), new SoftwareBauarbeiter(new Sicherheitsstufe2()), kit2));
        System.out.println(al.find("2"));

        LinkedList<UmweltKomponente> kitlist3 = new LinkedList<UmweltKomponente>();
        kitlist3.add(new Sensor("Laser", 0));
        kitlist3.add(new Aktor("Waffe", 9));
        SensorenAktorenKit kit3 = new SensorenAktorenKit(kitlist3);

        System.out.println("- Fuege Kaempfer mit Serial 3 ein. Gib mit Androide mit Serial 3 aus:");
        System.out.println(" - Erwartet: Ausgabe von Beschutzer 3");
        al.insert(new Kaempfer("3", new PanzerSkin(), new SoftwareKaempfer(new Sicherheitsstufe5()), kit3));
        System.out.println(al.find("3"));

        LinkedList<UmweltKomponente> kitlist4 = new LinkedList<UmweltKomponente>();
        kitlist4.add(new Sensor("Laser", 0));
        kitlist4.add(new Aktor("Waffe", 99));
        SensorenAktorenKit kit4 = new SensorenAktorenKit(kitlist4);

        System.out.println("- Fuege Leibwaechter mit Serial 4 ein. Gib mit Androide mit Serial 4 aus:");
        System.out.println(" - Erwartet: null (nicht die richtige Sicherheitstufe)");
        al.insert(new Leibwaechter("4", new FesterSkin(), new SoftwareLeibwaechter(new Sicherheitsstufe5()), kit4));
        System.out.println(al.find("4"));

        LinkedList<UmweltKomponente> kitlist5 = new LinkedList<UmweltKomponente>();
        kitlist5.add(new Sensor("Ohr", 0));
        kitlist5.add(new Aktor("Finger", 0.5));
        SensorenAktorenKit kit5 = new SensorenAktorenKit(kitlist5);

        System.out.println("- Fuege Gesellschafter mit Serial 5 ein. Gib mit Androide mit Serial 5 aus:");
        System.out.println(" - Erwartet: Gessellschafter mit Serial 5");
        al.insert(new Gesellschafter("5", new BeruehrungsSkin(), new SoftwareGesellschafter(new Sicherheitsstufe1()), kit5));
        System.out.println(al.find("5"));

        System.out.println("- Fuege Hilfskraft mit Serial 6 ein. Gib mit Androide mit Serial 6 aus:");
        System.out.println(" - Erwartet: null (Nicht der richtige Skin)");
        al.insert(new Hilfskraft("6", new FesterSkin(), new SoftwareHilfskraft(new Sicherheitsstufe1()), kit5));
        System.out.println(al.find("6"));

        LinkedList<UmweltKomponente> kitlist7 = new LinkedList<UmweltKomponente>();
        kitlist7.add(new Aktor("Bagger", 4));
        kitlist7.add(new Aktor("Foerderband", 3));
        SensorenAktorenKit kit7 = new SensorenAktorenKit(kitlist7);

        System.out.println("- Fuege Transportarbeiter mit Serial 7 ein. Gib mit Androide mit Serial 7 aus:");
        System.out.println(" - Erwartet: null (zu hohe Energie bei den Aktoren)");
        al.insert(new Transportarbeiter("7", new FesterSkin(), new SoftwareTransportarbeiter(new Sicherheitsstufe3()), kit7));
        System.out.println(al.find("7"));

        System.out.println("TESTS fuer ITERATOR");
        System.out.println(" - Erwartet: Liste aller eingefuegten Androiden");
        for(Androide a : al) {
            System.out.println(a);
        }
    }
}
