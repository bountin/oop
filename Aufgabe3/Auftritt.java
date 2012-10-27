import Buchung.Gage;

import java.util.Date;

public class Auftritt extends Termin {
	/**
	 * @deprecated
	 */
    private float gage;

    /**
     * Erzeugt einen geplanten Auftritt
     * @param gage
     * @param Ort
     * @param datum
     * @param dauer Dauer in Minuten
     */
    public Auftritt(float gage, Ort ort, Date datum, int dauer) {
        super(ort, datum, dauer);
	    this.getBuchungContainer().addBuchung(new Gage(gage, datum));
	    this.gage = gage;
    }

	/**
	 * @deprecated
	 */
    public float getGage() {
        return gage;
    }

	/**
	 * @deprecated
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
