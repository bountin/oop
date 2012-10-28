import Buchung.Gage;

import java.util.Date;

public class Auftritt extends Termin {
    private float gage;

    /**
     * Proconditon: gage >= 0, ort != null, datum != null, dauer > 0
     * dauer gibt die Dauer in Minuten an.
     * Postcondition: Ein Auftritt-Objekt mit den entsprechenden Werten wird erzeugt
     *
     * BAD: Um Rueckwaertskompatibilitaet zu den alten Testfaellen zu erhalten, wurde die lokale Gage nicht entfernt.
     */
    public Auftritt(float gage, Ort ort, Date datum, int dauer) {
        super(ort, datum, dauer);
	    this.getBuchungContainer().addBuchung(new Gage(gage, datum));
	    this.gage = gage;
    }

    public float getGage() {
        return gage;
    }

    /**
     * Proconditon: gage >= 0
     * Postcondition: Setzt die Gage auf den übergebenen Wert. Speichert zuvor
     * das gesamte Objekt als previosVersion
     *
     * BAD: Um Rueckwaertskompatibilitaet zu den alten Testfaellen zu erhalten, wurde die lokale Gage nicht entfernt.
     */
    public void setGage(float gage) {
        this.setPreviousVersion(this.clone());
        this.gage = gage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auftritt other = (Auftritt) obj;
        if (Float.floatToIntBits(this.gage) != Float.floatToIntBits(other.gage)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Float.floatToIntBits(this.gage);
        return hash;
    }

    @Override
    public Termin clone() {
        Auftritt a = new Auftritt(this.gage, this.getOrt(), this.getDatum(), this.getDauer());
        a.setPreviousVersion(this.getPreviousVersion());
        return a;
    }

    @Override
    public String toString() {
        return "Auftritt{" + super.toString() + ", gage=" + gage + '}';
    }
}
