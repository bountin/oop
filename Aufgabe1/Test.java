package Aufgabe1;

import java.lang.System;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Test {

    public static void main(String [] args)
    {
    	Musikgruppe mg = new Musikgruppe();
    	DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    	
        System.out.println("Test YAY!");
        
        /* 
         * -----------------------------------------------------------
         * ANFANG: Tests für MitgliedContainer
         * -----------------------------------------------------------
         */
        
        System.out.println("\nMitgliedContainer TEST #1: Rückgabe des momentanigen Lineups bei leerem Lineup");
        System.out.println("                Erwartung: \"Es gibt im Moment keine aktiven Mitglieder!\"");
        mg.printLineup();
        
        System.out.println("\nMitgliedContainer TEST #2: Rückgabe des aktiven Lineups eines früheren Datums bei leerem Lineup");
        System.out.println("                Erwartung: \"Es gab zu diesem Zeitpunkt keine aktiven Mitglieder!\"");
        mg.printLineup(new Date());
        
        System.out.println("\nMitgliedContainer TEST #3: Hinzufügen von neuen Mitgliedern");
        System.out.println("                Erwartung: kein Crash ^^");
        mg.addMitglied("Ian",0,"Bass");
        mg.addMitglied("Rob",1,"Vocals");
        mg.addMitglied("Glenn",2,"Guitar,Keyboard");
        mg.addMitglied("Scott", 3, "Drums");
        mg.addMitglied("Richie", 4, "Guitar");
        
        System.out.println("\nMitgliedContainer TEST #4: Rückgabe des aktiven Lineups bei nicht-leerem Lineup");
        System.out.println("                Erwartung: Ian, Rob, Glenn, Scott und Richie's Infos sollten angezeigt werden");
        mg.printLineup();
        
        System.out.println("\nMitgliedContainer TEST #5: Hinzufügen eines Mitglieds, das bereits aktiv ist");
        System.out.println("                Erwartung: \"Rob ist bereits in der Gruppe!\"");
        mg.addMitglied("Rob",1,"Vocals");
        
        System.out.println("\nMitgliedContainer TEST #6: Rückgabe des aktiven Lineups eines früheren Datums bei nicht-leerem Lineup");
        System.out.println("                Erwartung: Kenneth's Info sollte ausgegeben werden");
        mg.addMitglied("Kenneth",5,"Guitar");
        Mitglied kk = mg.getLineup().getMitglieder().get(5);
        try{
        	kk.setBeitritt(df.parse("01.10.1970"));
        	kk.setAustritt(df.parse("20.04.2011"));
        	mg.printLineup(df.parse("02.10.1970"));
        }catch(ParseException e){
        	System.err.println("ERROR: PARSE ERROR IN TEST NUMBER 6");
        }
        
        System.out.println("\nMitgliedContainer TEST #7: Entfernen eines Mitglieds und anschließendes Ausgeben aller aktiver Mitglieder");
        System.out.println("                Erwartung: So wie Test#4, ohne Ian");
        mg.removeMitglied("Ian");
        mg.printLineup();
        
        System.out.println("\nMitgliedContainer TEST #8: Entfernen eines Mitglieds, das nicht aktiv ist");
        System.out.println("                Erwartung: \"Ian ist kein aktives Mitglied der Gruppe!\"");
        mg.removeMitglied("Ian");
        
        /* 
         * -----------------------------------------------------------
         * ENDE: Tests für MitgliedContainer
         * -----------------------------------------------------------
         */
    }
}