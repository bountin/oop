import Buchung.BuchungContainer;

import java.util.Date;

public abstract class Termin {
     private Ort ort;
     private Date datum;
     private int dauer;
     private Status status;
     private Termin previousVersion;

    private BuchungContainer buchungen;

     public static enum Status {
         STATTGEFUNDEN, ABGESAGT, GEPLANT
     };

    /**
     * Precondition: raummiete != null, Date != null, dauer > 0
     * Postcondition: Setzt Parameter im Objekt.
     */
    public Termin(Ort ort, Date datum, int dauer) {
        this.ort = ort;
        this.datum = datum;
        this.dauer = dauer;
        this.status = Status.GEPLANT;

	    this.buchungen = new BuchungContainer();
    }

    public Ort getOrt() {
        return ort;
    }

    public int getDauer() {
        return dauer;
    }

    public Date getDatum() {
        return datum;
    }

    public Status getStatus() {
        return status;
    }

    public BuchungContainer getBuchungContainer() {
        return buchungen;
    }

    /**
     * GOOD: Status enum - Es kann kein ungueltiger Wert uebergeben werden.
     * Postcondition: Setzt Status auf den uebergebenen Status und speichert die
     * alte Terminversion in previousVersion.
     */
    public void setStatus(Status status) {
        this.previousVersion = this.clone();
        this.status = status;
    }

    /**
     * Precondition: datum != null
     * Postcondition: Setzt das uebergeben Datum und speichert die
     * alte Terminversion in previousVersion.
     */
    public void setDatum(Date datum) {
        this.previousVersion = this.clone();
        this.datum = datum;
    }

    /**
     * Precondition: dauer > 0
     * Postcondition: Setzt die uebergeben Dauer und speichert die
     * alte Terminversion in previousVersion.
     */
    public void setDauer(int dauer) {
        this.previousVersion = this.clone();
        this.dauer = dauer;
    }

    /**
     * Precondition: ort != null
     * Postcondition: Setzt den uebergeben Ort und speichert die
     * alte Terminversion in previousVersion.
     */
    public void setOrt(Ort ort) {
        this.previousVersion = this.clone();
        this.ort = ort;
    }

    /**
     * Precondition: nur von Termin und geerbeten Klassen aufrufen
     * Postcondition: Setzt previousVersion auf den uebergebenen Termin
     */
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
