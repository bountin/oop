package Aufgabe1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

class Test {

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
              
    }
}