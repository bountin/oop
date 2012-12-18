import java.util.LinkedList;


public class Keksdose {
	public LinkedList<Keks> kekse;

	public Keksdose() {
		kekse = new LinkedList<Keks>();
	}
	
	/**
	 * ANGABE:
	 * Eine Methode inhalt für eine Keksdose, die Beschreibungen der 
	 * in der Dose enthaltenen Kekse auf die Standardausgabe ausgibt. 
	 */
	public void inhalt(){
		if(kekse.size() == 0){
			System.out.println("Keine Kekse in dieser Dose =( !!!");
		}else{
			//TODO: restliche Implementierung
		}
	}
}
