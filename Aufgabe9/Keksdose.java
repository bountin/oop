import java.util.HashMap;


public class Keksdose {
	public HashMap<Keks,Integer> kekse;

	public Keksdose() {
		kekse = new HashMap<Keks,Integer>();
	}
	
	public void add(Keks k){
		if(kekse.containsKey(k)){
			int i = kekse.get(k).intValue() +1;
			kekse.put(k, i);
		}else{
			kekse.put(k, 0);
		}
	}
	
	public String getContents(){
		StringBuilder sb = new StringBuilder();
		for(Keks k: kekse.keySet()){
			sb.append("Keksart: "+k.toString() + " Anzahl:  " + kekse.get(k)+"\n");
		}
		return sb.toString();
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
			System.out.println(getContents());
		}
	}
}
