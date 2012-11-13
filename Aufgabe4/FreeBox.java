/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class FreeBox extends Repeated {

    /** 
     * Create a FreeBox
     * @param text
     */
    public FreeBox(Character[][] text) {
        super(text);
    }

    /** 
     * Create a FreeBox
     * @param text
    */
    public FreeBox(char[][] text) {
        super(toCharacterField(text));
    }

    private static Character[][] toCharacterField(char[][] field) {
        if (field.length == 0) {
            return new Character[0][0];
        }
        Character[][] f = new Character[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                f[i][j] = field[i][j];
            }
        }
        return f;
    }
}
