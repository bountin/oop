import java.lang.Character;
import java.lang.String;
import java.lang.System;

public class Scaled<P extends Pict>
	implements Pict
{

	P[][] field;

	public Scaled(P[][] field)
	{
		this.field = field;
	}

	public void scale(double factor)
	{
		for (P[] row: field) {
			for (P element: row) {
				element.scale(factor);
			}
		}

	}

	public String toString()
	{
		// Calc the height of each row and the width of each column
		int[] heights = new int[field.length];
		int[] widths = new int[field[0].length];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				String content[] = field[i][j].toString().split("\n");

				if (heights[i] < content.length) {
					heights[i] = content.length;
				}

				if (widths[j] < content[0].length()) {
					widths[j] = content[0].length();
				}
			}
		}

		// Calc width sum
		int width_sum = 0;
		for (int w: widths) {
			width_sum += w;
		}

		// Generate output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < field.length; i++) {
			// Compose the row
			char[][] row = new char[heights[i]][width_sum];
			int width_offset = 0;

			for (int a=0; a < row.length; a++) {
				for (int b=0; b < row[0].length; b++) {
					row[a][b] = ' ';
				}
			}

			// Walk through all columns in i-th row
			for (int j = 0; j < field[i].length; j++) {
				String box[] = field[i][j].toString().split("\n");

				for (int k = 0; k < box.length; k++) {
					String line = box[k];
					for (int l = 0; l < line.length(); l++) {
						row[k][l+width_offset] = line.charAt(l);
					}
				}
				width_offset += widths[j];
			}

			// Save row to StringBuilder
			for (char[] line: row) {
				for (char c: line) {
					sb.append(c);
				}
				sb.append('\n');
			}
		}

		// Truncate last newline
		sb.deleteCharAt(sb.length()-1);

		return sb.toString();
	}

}
