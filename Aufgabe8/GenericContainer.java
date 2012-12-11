//Shahin
public abstract class GenericContainer {
	
	private Box first;
	private Box last;

	public GenericContainer() {
	}
	
	/*
	 * liefert neuen Iterator mit dem ersten Element als Startelement
	 */
	public Iterator iterator(){
		return new Iterator(first);
	}
	
	public abstract void add(Object element);/*{
		Box newBox = new Box(element);
		
		if(first == null){
			first = newBox;
			last = first;
		}else{
			last.setNext(newBox);
			last = newBox;
		}
	}*/
	
	public abstract void remove(Object id);
	
	public abstract Object get(Object id);

	private class Box{
		private Object content;
		private Box next;
		
		public Box(Object element){
			this.content = element;
		}
		
		public Object getContent(){
			return content;
		}
		
		public Box getNext(){
			return next;
		}
		
		public void setNext(Box next){
			this.next = next;
		}
	}
	
	public class Iterator{
		private Box current;
		
		public Iterator(Box first){
			this.current = first;
		}
		
		public boolean hasNext(){
			return current != null;
		}
		
		public Object next(){
			if(current == null){
				return null;
			}
			Object value = current.getContent();	
			current = current.getNext();
			return value;
		}
	}
}
