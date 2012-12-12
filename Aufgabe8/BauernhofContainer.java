@Autor("Shahin")
public class BauernhofContainer extends GenericContainer{

	/*
	 * fuegt ein HofIdentifiable vom Typen Bauernhof hinzu,
	 * ansonsten geschieht nichts
	 */
	@Autor("Shahin")
	@Override
	public void add(HofIdentifiable element) {
		if(element instanceof Bauernhof){
			Box newBox = new Box((Bauernhof)element);
					
					if(getFirst() == null){
						setFirst(newBox);
						setLast(getFirst());
					}else{
						getLast().setNext(newBox);
						setLast(newBox);
					}
		}
	}

}
