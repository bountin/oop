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
public abstract class Termin {
     private String Ort;
     private Date datum;
     private int dauer;   // Minuten

     /**
      * 
      * @param Ort
      * @param datum
      * @param dauer Dauer in Minuten
      */
    public Termin(String Ort, Date datum, int dauer) {
        this.Ort = Ort;
        this.datum = datum;
        this.dauer = dauer;
    } 
     
    public String getOrt() {
        return Ort;
    }

    /**
     * 
     * @return Dauer in Minuten
     */
    public int getDauer() {
        return dauer;
    }

    public Date getDatum() {
        return datum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Termin other = (Termin) obj;
        if ((this.Ort == null) ? (other.Ort != null) : !this.Ort.equals(other.Ort)) {
            return false;
        }
        if (this.datum != other.datum && (this.datum == null || !this.datum.equals(other.datum))) {
            return false;
        }
        if (this.dauer != other.dauer) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.Ort != null ? this.Ort.hashCode() : 0);
        hash = 29 * hash + (this.datum != null ? this.datum.hashCode() : 0);
        hash = 29 * hash + this.dauer;
        return hash;
    }

    @Override
    public String toString() {
        return "Ort=" + Ort + ", datum=" + datum + ", dauer=" + dauer;
    }    
    
}
