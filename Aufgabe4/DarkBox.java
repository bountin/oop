
/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */

// Der Rand besteht immer aus einem beliebigen Zeichen
// Der Inhalt besteht immer aus einem beliebigen Zeichen
// Inhalt und Rand bestehen aus dem selben Zeichen
// Die Hoehe und die Breite sind immer > 0
// Skalierung basiert auf Streckung und Wiederholung, da keine Unterscheidung moeglich
public class DarkBox extends Box {
    private char c;

    public DarkBox(char c, double width, double height) {
        super(c, c, width, height);
        this.c = c;
    }

    public void setCharacter(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.ceil(height); i++) {
            for (int j = 0; j < Math.ceil(width); j++) {
                sb.append(c);
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1); // delete last \n
        return sb.toString();
    }
}
