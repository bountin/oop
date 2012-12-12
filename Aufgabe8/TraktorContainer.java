
@Autor("Shahin")
public class TraktorContainer extends GenericContainer{

	/*
	 * fuegt ein HofIdentifiable vom Typen Traktor hinzu,
	 * ansonsten geschieht nichts
	 */
	@Autor("Shahin")
	@Override
	public void add(HofIdentifiable element) {
		if(element instanceof Traktor){
			Box newBox = new Box(element);
					
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
