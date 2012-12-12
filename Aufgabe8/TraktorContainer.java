
@Autor("Shahin")
public class TraktorContainer extends GenericContainer{

	/*
	 * fuegt ein HofIdentifiable vom Typen Traktor hinzu,
	 * ansonsten geschieht nichts
	 */
	@Autor("Shahin")
	@Override
	public void add(HofIdentifiable element) {
		if(element instanceof Traktor){
			Box newBox = new Box(element);

					if(getFirst() == null){
						setFirst(newBox);
						setLast(getFirst());
					}else{
						getLast().setNext(newBox);
						setLast(newBox);
					}
		}
	}

	// STATISTIK METHODEN //

	/*
	 * berechnet die durchschnittliche Anzahl an Betriebsstunden,
	 * insgesamt, sowie separat per Einsatzart und gibt sie aus
	 */
	@Autor("Shahin")
	public void avgWorktimePerAssignment(){
		Iterator i = iterator();
		int duengeNum = 0;
		int drillNum = 0;
		double duengeTime = 0;
		double drillTime = 0;
		Traktor t = null;
		while(i.hasNext()){
			t = (Traktor) i.next().getContent();
			if(t.getAusruestung() instanceof DuengeAusruestung){
				duengeNum++;
				duengeTime += t.getBetriebsdauer();
			}else if(t.getAusruestung() instanceof DrillAusruestung){
				drillNum++;
				drillTime += t.getBetriebsdauer();
			}
		}
		if(duengeNum == 0){
			System.out.println("Durchschnittliche Betriebsdauer der DuengeTraktoren: 0");
		}else System.out.println("Durchschnittliche Betriebsdauer der DuengeTraktoren: "+(duengeTime/duengeNum));
		if(drillNum == 0){
			System.out.println("Durchschnittliche Betriebsdauer der DrillTraktoren: 0");
		}else System.out.println("Durchschnittliche Betriebsdauer der DrillTraktoren: "+(drillTime/drillNum));
		if(duengeNum + drillNum == 0){
			System.out.println("Durchschnittliche Betriebsdauer aller Traktoren: 0");
		}else System.out.println("Durchschnittliche Betriebsdauer aller Traktoren: "+((drillTime+duengeTime)/(drillNum+duengeNum)));
	}

	/*
	 * berechnet die durchschnittliche Anzahl an Betriebsstunden
	 * per Motorart und gibt sie aus
	 */
	@Autor("Shahin")
	public void avgWorktimePerEngine(){
		Iterator i = iterator();
		int dieselNum = 0;
		int biogasNum = 0;
		double dieselTime = 0;
		double biogasTime = 0;
		Traktor t = null;
		while(i.hasNext()){
			t = (Traktor) i.next().getContent();
			if(t instanceof DieselTraktor){
				dieselNum++;
				dieselTime += t.getBetriebsdauer();
			}else if(t instanceof GasTraktor){
				biogasNum++;
				biogasTime += t.getBetriebsdauer();
			}
		}
		if(dieselNum == 0){
			System.out.println("Durchschnittliche Betriebsdauer der DieselTraktoren: 0");
		}else System.out.println("Durchschnittliche Betriebsdauer der DieselTraktoren: "+(dieselTime/dieselNum));
		if(biogasNum == 0){
			System.out.println("Durchschnittliche Betriebsdauer der BiogasTraktoren: 0");
		}else System.out.println("Durchschnittliche Betriebsdauer der BiogasTraktoren: "+(biogasTime/biogasNum));
	}

	/*
	 * berechnet den durchschnittlichen DieselVerbrauch
	 * per Einsatzart und gesamt und gibt sie aus
	 */
	@Autor("Shahin")
	public void avgDieselConsuptionPerAssignment(){
		Iterator i = iterator();
		int duengeNum = 0;
		int drillNum = 0;
		double duengeUse = 0;
		double drillUse = 0;
		Traktor t = null;
		while(i.hasNext()){
			t = (Traktor) i.next().getContent();
			if(t instanceof DieselTraktor && t.getAusruestung() instanceof DuengeAusruestung){
				duengeNum++;
				duengeUse += t.getVerbrauch();
			}else if(t instanceof DieselTraktor && t.getAusruestung() instanceof DrillAusruestung){
				drillNum++;
				drillUse += t.getVerbrauch();
			}
		}
		if(duengeNum == 0){
			System.out.println("Durchschnittlicher Verbrauch der DuengeTraktoren: 0");
		}else System.out.println("Durchschnittlicher Verbrauch der DuengeTraktoren: "+(duengeUse/duengeNum));
		if(drillNum == 0){
			System.out.println("Durchschnittlicher Verbrauch der DrillTraktoren: 0");
		}else System.out.println("Durchschnittlicher Verbrauch der DrillTraktoren: "+(drillUse/drillNum));
		if(duengeNum + drillNum == 0){
			System.out.println("Durchschnittlicher Verbrauch aller DieselTraktoren: 0");
		}else System.out.println("Durchschnittlicher Verbrauch aller DieselTraktoren: "+((drillUse+duengeUse)/(drillNum+duengeNum)));
	}


	/*
	 * berechnet den durchschnittlichen BiogasVerbrauch
	 * per Einsatzart und gesamt und gibt sie aus
	 */
	@Autor("Shahin")
	public void avgBiogasConsuptionPerAssignment(){
		Iterator i = iterator();
		int duengeNum = 0;
		int drillNum = 0;
		double duengeUse = 0;
		double drillUse = 0;
		Traktor t = null;
		while(i.hasNext()){
			t = (Traktor) i.next().getContent();
			if(t instanceof GasTraktor && t.getAusruestung() instanceof DuengeAusruestung){
				duengeNum++;
				duengeUse += t.getVerbrauch();
			}else if(t instanceof GasTraktor && t.getAusruestung() instanceof DrillAusruestung){
				drillNum++;
				drillUse += t.getVerbrauch();
			}
		}
		if(duengeNum == 0){
			System.out.println("Durchschnittlicher Verbrauch der DuengeTraktoren: 0");
		}else System.out.println("Durchschnittlicher Verbrauch der DuengeTraktoren: "+(duengeUse/duengeNum));
		if(drillNum == 0){
			System.out.println("Durchschnittlicher Verbrauch der DrillTraktoren: 0");
		}else System.out.println("Durchschnittlicher Verbrauch der DrillTraktoren: "+(drillUse/drillNum));
		if(duengeNum + drillNum == 0){
			System.out.println("Durchschnittlicher Verbrauch aller BiogasTraktoren: 0");
		}else System.out.println("Durchschnittlicher Verbrauch aller BiogasTraktoren: "+((drillUse+duengeUse)/(drillNum+duengeNum)));
	}

	/*
	 * berechnet die minimale und maximale Anzahl
	 * an Saescharen und gibt sie aus
	 */
	@Autor("Shahin")
	public void minMaxSowingCoulters(){
		Iterator i = iterator();
		int minDiesel = 0;
		int maxDiesel = 0;
		int minGas = 0;
		int maxGas = 0;
		Traktor t = null;
		while(i.hasNext()){
			t = (Traktor) i.next().getContent();
			if(t instanceof DieselTraktor && t.getAusruestung() instanceof DrillAusruestung){

				if(((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl()<minDiesel){
					minDiesel = ((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl();
				}
				if(maxDiesel == 0 || ((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl()>maxDiesel){
					maxDiesel = ((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl();
				}
			}else if(t instanceof GasTraktor && t.getAusruestung() instanceof DrillAusruestung){

				if(((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl()<minGas){
					minGas = ((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl();
				}
				if(maxGas == 0 || ((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl()>maxGas){
					maxGas = ((DrillAusruestung)(t.getAusruestung())).getSaeschare_anzahl();
				}
			}
		}
		System.out.println("Kleinste Anzahl an Saescharen bei DieselTraktoren: " + minDiesel);
		System.out.println("Groesste Anzahl an Saescharen bei DieselTraktoren: " + maxDiesel);
		System.out.println("Kleinste Anzahl an Saescharen bei BiogasTraktoren: " + minGas);
		System.out.println("Groesste Anzahl an Saescharen bei BiogasTraktoren: " + maxGas);
		if(minDiesel<minGas){
			System.out.println("Kleinste Anzahl an Saescharen insgesamt: " + minDiesel);
		}else System.out.println("Kleinste Anzahl an Saescharen insgesamt: " + minGas);
		if(maxDiesel<maxGas){
			System.out.println("Groesste Anzahl an Saescharen insgesamt: " + maxDiesel);
		}else System.out.println("Groesste Anzahl an Saescharen insgesamt: " + maxGas);
	}

	/*
	 * berechnet das durchschnittliche Fassunsgsvermoegen
	 * per Motorart und gesamt und gibt sie aus
	 */
	@Autor("Shahin")
	public void avgFertilizerCapacity(){
		Iterator i = iterator();
		int dieselNum = 0;
		int biogasNum = 0;
		double dieselCap = 0;
		double biogasCap = 0;
		Traktor t = null;
		while(i.hasNext()){
			t = (Traktor) i.next().getContent();
			if(t instanceof DieselTraktor && t.getAusruestung() instanceof DuengeAusruestung){
				dieselNum++;
				dieselCap += ((DuengeAusruestung)(t.getAusruestung())).getKapazitaet();
			}else if(t instanceof GasTraktor && t.getAusruestung() instanceof DuengeAusruestung){
				biogasNum++;
				biogasCap += ((DuengeAusruestung)(t.getAusruestung())).getKapazitaet();;
			}
		}
		if(dieselNum == 0){
			System.out.println("Durchschnittliche Kapazitaet der DieselTraktoren: 0");
		}else System.out.println("Durchschnittliche Kapazitaet der DieselTraktoren: "+(dieselCap/dieselNum));
		if(biogasNum == 0){
			System.out.println("Durchschnittliche Kapazitaet der BiogasTraktoren: 0");
		}else System.out.println("Durchschnittliche Kapazitaet der BiogasTraktoren: "+(biogasCap/biogasNum));
		if(dieselNum + biogasNum == 0){
			System.out.println("Durchschnittliche Kapazitaet aller Traktoren: 0");
		}else System.out.println("Durchschnittliche Kapazitaet aller Traktoren: "+((dieselCap+biogasCap)/(biogasNum+dieselNum)));
	}
}

