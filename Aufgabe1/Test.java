package Aufgabe1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws ParseException {
        Musikgruppe m = new Musikgruppe("MyMusikGroup", "Blub");  // denkt euch nen Namen und eine Richtung aus ;)
        System.out.println("Musikguppe: " + m);

        // Termin Test
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

        Probe p1 = new Probe(15.0f, "Garage", sdf.parse("17.11.2012 19:00"), 120);
        Probe p2 = new Probe(20.0f, "Garage", sdf.parse("24.11.2012 18:30"), 90);
        Auftritt a1 = new Auftritt(150.0f, "Saal", sdf.parse("24.12.2012 21:00"), 60);
        Auftritt a2 = new Auftritt(135.0f, "Halle", sdf.parse("3.9.2012 14:30"), 120);

        m.getTermincontainer().addTermin(p1);
        System.out.println("Add: " + p1);
        m.getTermincontainer().addTermin(p2);
        System.out.println("Add: " + p2);
        m.getTermincontainer().addTermin(a1);
        System.out.println("Add: " + a1);
        m.getTermincontainer().addTermin(a2);
        System.out.println("Add: " + a2);


        float gage = m.getTermincontainer().getGage(sdf.parse("1.12.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Gage von 1.12.2012 00:00 bis 1.1.2013 00:00 : " + gage);

        float miete = m.getTermincontainer().getMiete(sdf.parse("1.11.2012 00:00"), sdf.parse("1.12.2012 00:00"));
        System.out.println("Gage von 1.11.2012 00:00 bis 1.12.2012 00:00 : " + miete);

        float saldo = m.getTermincontainer().getSaldo(sdf.parse("1.1.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Saldo von 1.1.2012 00:00 bis 1.1.2013 00:00 : " + saldo);

        List<Probe> lp = m.getTermincontainer().getProben(sdf.parse("1.1.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Proben von 1.1.2012 00:00 bis 1.1.2013 00:00");
        for(Probe p : lp) {
            System.out.println(p);
        }

        List<Auftritt> la = m.getTermincontainer().getAuftritte(sdf.parse("1.6.2012 00:00"), sdf.parse("1.10.2012 00:00"));
        System.out.println("Proben von 1.6.2012 00:00 bis 1.10.2012 00:00");
        for(Auftritt a : la) {
            System.out.println(a);
        }

        List<Termin> lt = m.getTermincontainer().getTermine(sdf.parse("1.1.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Proben von 1.1.2012 00:00 bis 1.1.2013 00:00");
        for(Termin t : lt) {
            System.out.println(t);
        }

        /*
        * -----------------------------------------------------------
        * ANFANG: Tests für MitgliedContainer
        * -----------------------------------------------------------
        */

        System.out.println("\nMitgliedContainer TEST #1: Rückgabe des momentanigen Lineups bei leerem Lineup");
        System.out.println(" Erwartung: \"Es gibt im Moment keine aktiven Mitglieder!\"");
        m.printLineup();

        System.out.println("\nMitgliedContainer TEST #2: Rückgabe des aktiven Lineups eines früheren Datums bei leerem Lineup");
        System.out.println(" Erwartung: \"Es gab zu diesem Zeitpunkt keine aktiven Mitglieder!\"");
        m.printLineup(new Date());

        System.out.println("\nMitgliedContainer TEST #3: Hinzufügen von neuen Mitgliedern");
        System.out.println(" Erwartung: kein Crash ^^");
        m.addMitglied("Ian",0,"Bass");
        m.addMitglied("Rob",1,"Vocals");
        m.addMitglied("Glenn",2,"Guitar,Keyboard");
        m.addMitglied("Scott", 3, "Drums");
        m.addMitglied("Richie", 4, "Guitar");

        System.out.println("\nMitgliedContainer TEST #4: Rückgabe des aktiven Lineups bei nicht-leerem Lineup");
        System.out.println(" Erwartung: Ian, Rob, Glenn, Scott und Richie's Infos sollten angezeigt werden");
        m.printLineup();

        System.out.println("\nMitgliedContainer TEST #5: Hinzufügen eines Mitglieds, das bereits aktiv ist");
        System.out.println(" Erwartung: \"Rob ist bereits in der Gruppe!\"");
        m.addMitglied("Rob",1,"Vocals");

        System.out.println("\nMitgliedContainer TEST #6: Rückgabe des aktiven Lineups eines früheren Datums bei nicht-leerem Lineup");
        System.out.println(" Erwartung: Kenneth's Info sollte ausgegeben werden");
        m.addMitglied("Kenneth",5,"Guitar");
        Mitglied kk = m.getMitgliedcontainer().getMitglieder().get(5);
        try{
            kk.setBeitritt(sdf.parse("01.10.1970"));
            kk.setAustritt(sdf.parse("20.04.2011"));
            m.printLineup(sdf.parse("02.10.1970"));
        }catch(ParseException e){
            System.err.println("ERROR: PARSE ERROR IN TEST NUMBER 6");
        }

        System.out.println("\nMitgliedContainer TEST #7: Entfernen eines Mitglieds und anschließendes Ausgeben aller aktiver Mitglieder");
        System.out.println(" Erwartung: So wie Test#4, ohne Ian");
        m.removeMitglied("Ian");
        m.printLineup();

        System.out.println("\nMitgliedContainer TEST #8: Entfernen eines Mitglieds, das nicht aktiv ist");
        System.out.println(" Erwartung: \"Ian ist kein aktives Mitglied der Gruppe!\"");
        m.removeMitglied("Ian");

        /*
        * -----------------------------------------------------------
        * ENDE: Tests für MitgliedContainer
        * -----------------------------------------------------------
        */
    }
}