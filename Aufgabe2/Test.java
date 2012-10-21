import java.lang.Integer;
import java.lang.System;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws ParseException {
        Musikgruppe m = new Musikgruppe("MyMusikGroup", "Blub");  // denkt euch nen Namen und eine Richtung aus ;)
        System.out.println("Musikguppe: " + m);

        // Termin Test
        System.out.println("\n---Termin testen---\n");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

        Probe p1 = new Probe(15.0f, "Garage", sdf.parse("17.11.2012 19:00"), 120);
        Probe p2 = new Probe(20.0f, "Garage", sdf.parse("24.11.2012 18:30"), 90);
        Auftritt a1 = new Auftritt(150.0f, "Saal", sdf.parse("24.12.2012 21:00"), 60);
        Auftritt a2 = new Auftritt(135.0f, "Halle", sdf.parse("3.9.2012 14:30"), 120);

        m.getTerminContainer().addTermin(p1);
        System.out.println("Add: " + p1);
        m.getTerminContainer().addTermin(p2);
        System.out.println("Add: " + p2);
        m.getTerminContainer().addTermin(a1);
        System.out.println("Add: " + a1);
        m.getTerminContainer().addTermin(a2);
        System.out.println("Add: " + a2);


        float gage = m.getTerminContainer().getGage(sdf.parse("1.12.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Gage von 1.12.2012 00:00 bis 1.1.2013 00:00 : " + gage);

        float miete = m.getTerminContainer().getMiete(sdf.parse("1.11.2012 00:00"), sdf.parse("1.12.2012 00:00"));
        System.out.println("Gage von 1.11.2012 00:00 bis 1.12.2012 00:00 : " + miete);

        float saldo = m.getTerminContainer().getSaldo(sdf.parse("1.1.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Saldo von 1.1.2012 00:00 bis 1.1.2013 00:00 : " + saldo);

        List<Probe> lp = m.getTerminContainer().getProben(sdf.parse("1.1.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Proben von 1.1.2012 00:00 bis 1.1.2013 00:00");
        for(Probe p : lp) {
            System.out.println(p);
        }

        List<Auftritt> la = m.getTerminContainer().getAuftritte(sdf.parse("1.6.2012 00:00"), sdf.parse("1.10.2012 00:00"));
        System.out.println("Proben von 1.6.2012 00:00 bis 1.10.2012 00:00");
        for(Auftritt a : la) {
            System.out.println(a);
        }

        List<Termin> lt = m.getTerminContainer().getTermine(sdf.parse("1.1.2012 00:00"), sdf.parse("1.1.2013 00:00"));
        System.out.println("Proben von 1.1.2012 00:00 bis 1.1.2013 00:00");
        for(Termin t : lt) {
            System.out.println(t);
        }
        
        System.out.println("\n---Termin ändern/löschen---\n");
        
        // Termin ändern
        System.out.println("Proben von 17.11.2012 auf Dauer '30' und Ort 'Wohnzimmer' ändern:");
        lp = m.getTerminContainer().getProben(sdf.parse("17.11.2012 00:00"), sdf.parse("18.11.2012 00:00"));
        Probe p = lp.get(0);
        p.setDauer(30);
        p.setOrt("Wohnzimmer");
        System.out.println(p);
        
        // letzte Änderung rückgängig machen
        System.out.println("Zweite Änderung Rückgäng machen:");
        m.getTerminContainer().removeTermin(p);
        m.getTerminContainer().addTermin(p.getPreviousVersion());
        // Ausgabe des jetzt enthaltenen Termins
        lp = m.getTerminContainer().getProben(sdf.parse("17.11.2012 00:00"), sdf.parse("18.11.2012 00:00"));
        System.out.println(lp.get(0));
        
        // Status ändern
        System.out.println("Probe absagen:");
        lp = m.getTerminContainer().getProben(sdf.parse("17.11.2012 00:00"), sdf.parse("18.11.2012 00:00"));
        p = lp.get(0);
        p.setStatus(Termin.Status.ABGESAGT);
        m.getMitgliedContainer().updateTermin(p);  // Mitglieder informieren
        System.out.println(p);
        
        // Termin löschen
        System.out.println("Proben von 17.11.2012 löschen:");
        lp = m.getTerminContainer().getProben(sdf.parse("17.11.2012 00:00"), sdf.parse("18.11.2012 00:00"));
        m.getTerminContainer().removeTermin(lp.get(0));
        lp = m.getTerminContainer().getProben(sdf.parse("17.11.2012 00:00"), sdf.parse("18.11.2012 00:00"));
        for(Termin t : lp) {  // leere List weil gelöscht
            System.out.println(t);
        }
        // gelöschte Probe ausgeben
        System.out.println("Gelöschte Probe ausgeben:");
        System.out.println(m.getTerminContainer().getRemoved().pop());
        
        /*
        * -----------------------------------------------------------
        * ANFANG: Tests für MitgliedContainer
        * -----------------------------------------------------------
        */

        System.out.println("\nMitgliedContainer TEST #1: Rückgabe des momentanigen Lineups bei leerem Lineup");
        System.out.println(" Erwartung: \"Korrekt!\"");
        if(m.getMitgliedContainer().getMitgliederOn(null).isEmpty()){
        	System.out.println("Korrekt!");
        }else System.out.println("TEST FEHLGESCHLAGEN");

        System.out.println("\nMitgliedContainer TEST #2: Rückgabe des aktiven Lineups eines früheren Datums bei leerem Lineup");
        System.out.println(" Erwartung: \"Es gab zu diesem Zeitpunkt keine aktiven Mitglieder!\"");
        
        if(m.getMitgliedContainer().getMitgliederOn(sdf.parse("11.11.2011 00:00")).isEmpty()){
        	System.out.println("Korrekt!");
        }else System.out.println("TEST FEHLGESCHLAGEN");

        System.out.println("\nMitgliedContainer TEST #3: Hinzufügen von neuen Mitgliedern");
        System.out.println(" Erwartung: kein Crash ^^");
        m.getMitgliedContainer().addMitglied("Ian","0","Bass",null,null);
        m.getMitgliedContainer().addMitglied("Rob","1","Vocals", null,null);
        m.getMitgliedContainer().addMitglied("Glenn","2","Guitar,Keyboard",null,null);
        m.getMitgliedContainer().addMitglied("Scott", "3", "Drums",null,null);
        m.getMitgliedContainer().addMitglied("Richie", "4", "Guitar",null,null);

        System.out.println("\nMitgliedContainer TEST #4: Rückgabe des aktiven Lineups bei nicht-leerem Lineup");
        System.out.println(" Erwartung: Ian, Rob, Glenn, Scott und Richie's Infos sollten angezeigt werden");
        for(Mitglied mitglied: m.getMitgliedContainer().getMitgliederOn(null)){
        	System.out.println(mitglied.toString() + "\n");
        }

        System.out.println("\nMitgliedContainer TEST #5: Hinzufügen eines Mitglieds, das bereits aktiv ist");
        System.out.println(" Erwartung: Rob soll nicht zweimal aufscheinen");
        m.getMitgliedContainer().addMitglied("Rob","1","Vocals", null,null);
        for(Mitglied mitglied: m.getMitgliedContainer().getMitgliederOn(null)){
        	System.out.println(mitglied.toString() + "\n");
        }

        System.out.println("\nMitgliedContainer TEST #6: Rückgabe des aktiven Lineups eines früheren Datums bei nicht-leerem Lineup");
        System.out.println(" Erwartung: Kenneth's Info sollte ausgegeben werden");
        m.getMitgliedContainer().addMitglied("Kenneth","5","Guitar",sdf.parse("01.10.1970 00:00"), sdf.parse("20.04.2011 00:00"));
        for(Mitglied mitglied: m.getMitgliedContainer().getMitgliederOn(sdf.parse("02.10.1970 00:00"))){
        	System.out.println(mitglied.toString() + "\n");
        }

        System.out.println("\nMitgliedContainer TEST #7: Entfernen eines Mitglieds und anschließendes Ausgeben aller aktiver Mitglieder");
        System.out.println(" Erwartung: So wie Test#4, ohne Ian");
        m.getMitgliedContainer().removeMitglied("Ian");
        for(Mitglied mitglied: m.getMitgliedContainer().getMitgliederOn(null)){
        	System.out.println(mitglied.toString() + "\n");
        }
        
        /*
        * -----------------------------------------------------------
        * ENDE: Tests für MitgliedContainer
        * -----------------------------------------------------------
        */

        /**
         * Tests für Musikstueck
         */
        System.out.println();
        System.out.println("---- Testing Mustikstueck part");

        MusikstueckContainer musikstueckContainer = m.getMusikstueckContainer();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date today = new Date();
        Date yesterday = new Date(cal.getTimeInMillis());
        cal.add(Calendar.DATE, 2);
        Date tomorrow = new Date(cal.getTimeInMillis());
        cal.add(Calendar.DATE, 1);
        Date dayAfterTomorrow = new Date(cal.getTimeInMillis());
        Integer size;

        size = musikstueckContainer.getList(today).size();
        if (size == 0) {
            System.out.println("OK: Musikgruppe hat ein leeres Repertoire");
        } else {
            System.err.println("ERROR: Musikgruppe sollte ein leeres Repertoire haben");
        }

        // Add a musikstueck
        Musikstueck stueck1 = new Musikstueck("Für Amelie", 666);
        musikstueckContainer.addElement(stueck1, today);
        size = musikstueckContainer.getList(today).size();
        if (size == 1) {
            System.out.println("OK: Musikgruppe kennt ein Stück");
        } else {
            System.err.println("ERROR: Musikgruppe sollte ein Stück kennen");
        }
        if (musikstueckContainer.getList(today).get(0).equals(stueck1)) {
            System.out.println("OK: Die Stücke stimmen überein");
        } else {
            System.err.println("ERROR: Die Stücke sollten überein stimmen");
        }

        // Musikstück sollte gestern nicht sichtbar sein, aber morgen schon
        size = musikstueckContainer.getList(yesterday).size();
        if (size == 0) {
            System.out.println("OK: Musikgruppe kannte gestern kein Stück");
        } else {
            System.err.println("ERROR: Musikgruppe sollte gestern kein Stück kennen");
        }
        size = musikstueckContainer.getList(tomorrow).size();
        if (size == 1) {
            System.out.println("OK: Musikgruppe kennt morgen ein Stück");
        } else {
            System.err.println("ERROR: Musikgruppe sollte morgen ein Stück kennen");
        }

        // Entfernen des Elements
        musikstueckContainer.removeElement(stueck1, tomorrow);
        size = musikstueckContainer.getList(yesterday).size();
        if (size == 0) {
            System.out.println("OK: Musikgruppe kannte gestern immer noch kein Stück");
        } else {
            System.err.println("ERROR: Musikgruppe sollte gestern kein Stück kennen");
        }
        size = musikstueckContainer.getList(today).size();
        if (size == 1) {
            System.out.println("OK: Musikgruppe kennt heute ein Stück");
        } else {
            System.err.println("ERROR: Musikgruppe sollte heute ein Stück kennen");
        }
        size = musikstueckContainer.getList(tomorrow).size();
        if (size == 1) {
            System.out.println("OK: Musikgruppe kennt morgen ein Stück");
        } else {
            System.err.println("ERROR: Musikgruppe sollte morgen ein Stück kennen");
        }
        size = musikstueckContainer.getList(dayAfterTomorrow).size();
        if (size == 0) {
            System.out.println("OK: Musikgruppe kennt übermorgen kein Stück");
        } else {
            System.err.println("ERROR: Musikgruppe sollte übermorgen kein Stück kennen");
        }

    }
}
