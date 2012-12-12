@Autor("Shahin")
public abstract class GenericContainer {
	
	/*
	 * ist null bei leerem container
	 */
	private Box first;
	/*
	 * ist null bei leerem container
	 */
	private Box last;
	
	/*
	 * liefert neuen Iterator mit dem ersten Element als Startelement
	 */
	@Autor("Shahin")
	public Iterator iterator(){
		return new Iterator();
	}
	@Autor("Shahin")
	public abstract void add(HofIdentifiable element);/*{
		Box newBox = new Box(element);
		
		if(first == null){
			first = newBox;
			last = first;
		}else{
			last.setNext(newBox);
			last = newBox;
		}
	}*/
	
	/*
	 * sucht nach einem HofIdentifiable mit der gesuchten id
	 * und entfernt sie, insofern sie existiert
	 * */
	
	@Autor("Shahin")
	public void remove(Object id) {
		Iterator i = new Iterator();
		Box predecessor = null;
		Box current = null;
		while(i.hasNext()){
			predecessor = current;
			current = i.next();
			if(id.equals(current.getContent().getIdentifier())){
				predecessor.setNext(current.getNext());
				current.setNext(null);
				break;
			}
		}
	}

	/*
	 * sucht nach und retourniert ein HofIdentifiable
	 * mit der angegebenen id, insofern es existiert.
	 * Ansonsten wird null zurückgegeben
	 */
	@Autor("Shahin")
	public HofIdentifiable get(Object id) {
		Iterator i = new Iterator();
		while(i.hasNext()){
			Box current = i.next();
			if(id.equals(current.getContent().getIdentifier())){
				return current.getContent();
			}
		}
		return null;
	}

	@Autor("Shahin")
	protected Box getFirst() {
		return first;
	}
	@Autor("Shahin")
	protected void setFirst(Box first) {
		this.first = first;
	}
	@Autor("Shahin")
	protected Box getLast() {
		return last;
	}
	@Autor("Shahin")
	protected void setLast(Box last) {
		this.last = last;
	}
	
	@Autor("Shahin") protected class Box{
		private HofIdentifiable content;
		private Box next;
		@Autor("Shahin")
		public Box(HofIdentifiable element){
			this.content = element;
		}
		/*
		 * gibt den Inhalt zurück
		 */
		@Autor("Shahin")
		public HofIdentifiable getContent(){
			return content;
		}
		/*
		 * gibt die Box zurück, auf die diese verweist. 
		 * null falls keine solche existiert
		 */
		@Autor("Shahin")
		public Box getNext(){
			return next;
		}
		@Autor("Shahin")
		public void setNext(Box next){
			this.next = next;
		}
	}
	@Autor("Shahin")
	public class Iterator{
		private Box current;
		@Autor("Shahin")
		public Iterator(){
			this.current = getFirst();
		}
		/*
		 * überprüft ob es noch ein nicht 
		 * zurückgebenes Element gibt
		 */
		@Autor("Shahin")
		public boolean hasNext(){
			return current != null;
		}
		/*
		 * gibt das nächste Element aus
		 * falls es noch eines gibt, ansonsten
		 * null
		 */
		@Autor("Shahin")
		public Box next(){
			if(current == null){
				return null;
			}
			Box value = current;	
			current = current.getNext();
			return value;
		}
	}
}
