/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aufgabe1;

import java.util.Date;

/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Auftritt extends Termin {
    private float gage;

    /**
     *
     * @param gage
     * @param Ort
     * @param datum
     * @param dauer Dauer in Minuten
     */
    public Auftritt(float gage, String Ort, Date datum, int dauer) {
        super(Ort, datum, dauer);
        this.gage = gage;
    }

    public float getGage() {
        return gage;
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
    public String toString() {
        return "Auftritt{" + super.toString() + ", gage=" + gage + '}';
    }



}
