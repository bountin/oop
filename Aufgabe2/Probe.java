import java.util.Date;

public class Probe extends Termin {
    private float raummiete;

    /**
     *
     * @param raummiete
     * @param Ort
     * @param datum
     * @param dauer Dauer in Minuten
     */
    public Probe(float raummiete, String Ort, Date datum, int dauer) {
        super(Ort, datum, dauer);
        this.raummiete = raummiete;
    }

    public float getRaummiete() {
        return raummiete;
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
}
