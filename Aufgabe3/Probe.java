import Buchung.RaumMiete;

import java.util.Date;

public class Probe extends Termin {
    private float raummiete;

    /**
     * Precondition: raummiete >= 0, ort != null, datum != null, dauer > 0
     * Postcondition: Erzeugt ein Proben Objekt mit den uebergebenen Werten
     */
    public Probe(float raummiete, Ort ort, Date datum, int dauer) {
        super(ort, datum, dauer);

	    // BAD: Um Rueckwaertskompatibilitaet zu den alten Testfaellen zu erhalten, wurde die lokale Raummiete nicht entfernt.
        this.raummiete = raummiete;
	    RaumMiete miete = new RaumMiete(raummiete, datum);
	    this.getBuchungContainer().addBuchung(miete);
    }

	/**
	 * BAD: Um Rueckwaertskompatibilitaet zu den alten Testfaellen zu erhalten, wurde die lokale Raummiete nicht entfernt.
	 */
    public float getRaummiete() {
        return raummiete;
    }

    /**
     * Precondition: raummiete >= 0
     * Postcondition: Setzt Raummiete auf den uebergeben Wert und speichert das
     * alte Proben Objekt in previousVersion
     *
     * BAD: Um Rueckwaertskompatibilitaet zu den alten Testfaellen zu erhalten, wurde die lokale Raummiete nicht entfernt.
     */
    public void setRaummiete(float raummiete) {
        this.setPreviousVersion(this.clone());
        this.raummiete = raummiete;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Probe other = (Probe) obj;
        if (Float.floatToIntBits(this.raummiete) != Float.floatToIntBits(other.raummiete)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Float.floatToIntBits(this.raummiete);
        return hash;
    }

    @Override
    public String toString() {
        return "Probe{" + super.toString() + ", raummiete=" + raummiete + '}';
    }

    @Override
    public Termin clone() {
        Probe p = new Probe(this.raummiete, this.getOrt(), this.getDatum(), this.getDauer());
        p.setPreviousVersion(this.getPreviousVersion());
        return p;
    }
}
