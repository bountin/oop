import java.util.Date;

public abstract class Termin {
     private String ort;
     private Date datum;
     private int dauer;   // Minuten
     private Status status;
     private Termin previousVersion;
     
     public static enum Status {
         STATTGEFUNDEN, ABGESAGT, GEPLANT
     };
     
     /**
      * Erzeugt einen geplanten Termin
      * @param Ort
      * @param datum
      * @param dauer Dauer in Minuten
      */
    public Termin(String Ort, Date datum, int dauer) {
        this.ort = Ort;
        this.datum = datum;
        this.dauer = dauer;
        this.status = Status.GEPLANT;
    }

    public String getOrt() {
        return ort;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.previousVersion = this.clone();
        this.status = status;
    }

    public void setDatum(Date datum) {
        this.previousVersion = this.clone();
        this.datum = datum;
    }

    public void setDauer(int dauer) {
        this.previousVersion = this.clone();
        this.dauer = dauer;
    }

    public void setOrt(String ort) {
        this.previousVersion = this.clone();
        this.ort = ort;
    }
    
    protected void setPreviousVersion(Termin t) {
        this.previousVersion = t;
    }
    
    public Termin getPreviousVersion() {
        return previousVersion;
    }
    
    /**
     * Returnt eine Kopie des Objects.
     */
    @Override
    public abstract Termin clone();
            
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Termin other = (Termin) obj;
        if ((this.ort == null) ? (other.ort != null) : !this.ort.equals(other.ort)) {
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
        hash = 29 * hash + (this.ort != null ? this.ort.hashCode() : 0);
        hash = 29 * hash + (this.datum != null ? this.datum.hashCode() : 0);
        hash = 29 * hash + this.dauer;
        return hash;
    }

    @Override
    public String toString() {
        return "Status=" + status + " Ort=" + ort + ", datum=" + datum + ", dauer=" + dauer;
    }

}
