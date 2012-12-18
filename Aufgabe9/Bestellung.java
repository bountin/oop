import java.util.Iterator;
import java.util.LinkedList;

/**
 * ANGABE:
 * "Eine Bestellung ist eine Liste von Positionen, die jeweils die Anzahl, 
 * Form, Teigart und Fülle (wenn Doppelkekse gewünscht sind, sonst keine 
 * Fülle) angeben."
 */
public class Bestellung {

	private LinkedList<Position> pos;
	
	public Bestellung() {
		this.pos = new LinkedList<Position>();
	}

	/**
	 * ANGABE:
	 * "Eine Methode drucke für eine Bestellung,
	 *  die alle Positionen in der Standardausgabe auflistet." 
	 */
	public void drucke(){
		for(Position p: pos){
			System.out.println(p.toString());
		}
	}
	
	public Iterator<Position> iterator(){
		return pos.iterator();
	}
	
	public void addPosition(Position p){
		pos.add(p);
	}
}
