import java.lang.Integer;
import java.lang.String;
import java.util.Date;

class Musikstueck {
    private String name;
    // The unit of laenge is seconds
    private Integer laenge;

    private Date eintragung;
    private Date austragung;

    public Musikstueck(String name, Integer laenge) {
        this.name = name;
        this.laenge = laenge;
    }

    public String getName() {
        return name;
    }

    /**
     * Laenge is measured in seconds
     */
    public Integer getLaenge() {
        return laenge;
    }

    public Date getEintragung() {
        return eintragung;
    }

    public Date getAustragung() {
        return austragung;
    }

    public void setEintragung(Date eintragung) {
        this.eintragung = eintragung;
    }

    public void setAustragung(Date austragung) {
        this.austragung = austragung;
    }

    public boolean isActive(Date datum) {
        if (eintragung == null ) {
            return false;
        }

        if (austragung == null) {
            return datum.after(eintragung) || datum.equals(eintragung);
        }

        return
            (datum.after(eintragung) || datum.equals(eintragung))
         && (datum.before(austragung) || datum.equals(austragung));
    }

    public boolean equals(Musikstueck other) {
        return this.getName() == other.getName()
            && this.getLaenge() == other.getLaenge()
            && this.getEintragung() == other.getEintragung()
            && this.getAustragung() == other.getAustragung();
    }
}
