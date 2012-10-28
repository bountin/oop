
public class Ort {
    private String name;
    private String adresse;
    private String plz;
    private boolean soundanlage;
    private boolean lichtanlage;
    private int zugl_personen;

    /**
     * Preconditon: name und adresse != null, plz ist eine Postleitzahl, zugl_personen >= 0
     * Postcondition: Ein Ort-Objekt mit den entsprechenden Werten wird erzeugt
     */
    public Ort(String name, String adresse, String plz, boolean soundanlage, boolean lichtanlage, int zugl_personen) {
        this.name = name;
        this.adresse = adresse;
        this.plz = plz;
        this.soundanlage = soundanlage;
        this.lichtanlage = lichtanlage;
        this.zugl_personen = zugl_personen;
    }

    public String getAdresse() {
        return adresse;
    }

    public boolean isLichtanlage() {
        return lichtanlage;
    }

    public String getName() {
        return name;
    }

    public String getPlz() {
        return plz;
    }

    public boolean isSoundanlage() {
        return soundanlage;
    }

    public int getZugl_personen() {
        return zugl_personen;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ort other = (Ort) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.adresse == null) ? (other.adresse != null) : !this.adresse.equals(other.adresse)) {
            return false;
        }
        if ((this.plz == null) ? (other.plz != null) : !this.plz.equals(other.plz)) {
            return false;
        }
        if (this.soundanlage != other.soundanlage) {
            return false;
        }
        if (this.lichtanlage != other.lichtanlage) {
            return false;
        }
        if (this.zugl_personen != other.zugl_personen) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.adresse != null ? this.adresse.hashCode() : 0);
        hash = 97 * hash + (this.plz != null ? this.plz.hashCode() : 0);
        hash = 97 * hash + (this.soundanlage ? 1 : 0);
        hash = 97 * hash + (this.lichtanlage ? 1 : 0);
        hash = 97 * hash + this.zugl_personen;
        return hash;
    }

    @Override
    public String toString() {
        return "Ort{" + "name=" + name + ", adresse=" + adresse + ", plz=" + plz + ", soundanlage=" + soundanlage + ", lichtanlage=" + lichtanlage + ", zugl_personen=" + zugl_personen + '}';
    }
}
