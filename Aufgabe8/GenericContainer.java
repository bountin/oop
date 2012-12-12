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
	public abstract void add(HofIdentifiable element);

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
				if (predecessor != null) {
					predecessor.setNext(current.getNext());
				} else {
					first = current.getNext();
				}
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
				if(id instanceof String){
					return (Bauernhof)current.getContent();
				}else{
					return (Traktor)current.getContent();
				}
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
		/*
		 * null falls letztes Element des
		 * Containers
		 */
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
		 * gibt die Box zurueck, auf die diese verweist.
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
		/*
		 * null bei leerem Container
		 */
		private Box current;

		/*
		 * erzeugt einen neuen Iterator
		 * und setzt das erste Element
		 * des Containers als erstes
		 * Element des Iterators
		 */
		@Autor("Shahin")
		public Iterator(){
			this.current = getFirst();
		}
		/*
		 * ueberprueft ob es noch ein nicht
		 * zurueckgebenes Element gibt
		 */
		@Autor("Shahin")
		public boolean hasNext(){
			return current != null;
		}
		/*
		 * gibt das naechste Element aus
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
