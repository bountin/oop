import java.lang.Integer;
import java.lang.String;
import java.util.Date;

class Musikstueck {
    private String name;
    // The unit of laenge is seconds
    private Integer laenge;

    private Date eintragung;
    private Date austragung;

    public Musikstueck(String Name, Integer laenge) {
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
            return datum.after(eintragung);
        }

        return datum.after(eintragung) && datum.before(austragung);
    }
}
