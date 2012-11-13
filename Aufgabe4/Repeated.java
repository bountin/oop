/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Repeated<P> implements Pict {

    private P[][] field;
    private double scale;

    public Repeated(P[][] field) {
        this.field = field;
        this.scale = 1.0;
    }

    /**
     * 0.1 <= factor <= 10.0; resize the picture
     * @param factor 
     */
    @Override
    public void scale(double factor) {
        if (factor >= 0.1 && factor <= 10.0) {
            this.scale = scale * factor;
        }
    }

    /** 
     * If elements have different sizes, the smaller ones will be filled with
     * spaces
     * @return the picture as String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int old_height = field.length;
        int old_width = field[0].length;
        int height = (int) Math.ceil(old_height * scale);
        int width = (int) Math.ceil(old_width * scale);

        // Search for biggest height and width of each element
        int max_height = 0;
        int max_width = 0;
        for (int i = 0; i < old_height; i++) {
            for (int j = 0; j < old_width; j++) {
                String[] elm_f = field[i][j].toString().split("\n");
                if (elm_f.length > max_height) {
                    max_height = elm_f.length;
                }
                for (String s : elm_f) {
                    if (s.length() > max_width) {
                        max_width = s.length();
                    }
                }
            }
        }

        // Create field of equal-sized char arrays filled with spaces
        char[][][][] sized = new char[old_height][old_width][max_height][max_width];
        for (int i = 0; i < sized.length; i++) {
            for (int j = 0; j < sized[i].length; j++) {
                char[][] output = new char[max_height][max_width];
                String s = field[i][j].toString();
                String[] elm_f = s.split("\n");
                for (int line_nr = 0; line_nr < output.length; line_nr++) {
                    for (int char_nr = 0; char_nr < output[line_nr].length; char_nr++) {
                        if (elm_f.length > line_nr && elm_f[line_nr].length() > char_nr) {
                            output[line_nr][char_nr] = elm_f[line_nr].charAt(char_nr);
                        } else {
                            output[line_nr][char_nr] = ' ';
                        }
                    }
                }
                sized[i][j] = output;
            }
        }

        // compose a String of the sized field
        for (int i = 0; i < height; i++) {
            for (int line_nr = 0; line_nr < max_height; line_nr++) {
                for (int j = 0; j < width; j++) {
                    sb.append(sized[i%old_height][j%old_width][line_nr]);
                }
                sb.append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1); // delete last \n
        return sb.toString();
    }
}
