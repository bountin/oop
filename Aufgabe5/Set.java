
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Einfach verkettete List mit einmaligen Elementen
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Set<T> implements Iterable<T> {
    
    private class Node<T> {
        private T content;
        private Node<T> next = null;    
        private Node<T> prev = null;
        
        public Node(T content) {
            this.content = content;
        }
    }
    
    private Node<T> root = null;

    
    // Fuegt vorne in der Liste ein, falls unique.
    public void insert(T content) {
        Node<T> n = new Node<T>(content);
        boolean isUnique = true;
        for(T cont : this) {
            if(n.content.equals(cont)) {
                isUnique = false;
            }
        }
        if(isUnique) {
            if(root != null) {
                root.prev = n;
                n.next = root;
            }
            root = n;
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            
            Node<T> pos = root;
            boolean nextCalled;
            
            @Override
            public boolean hasNext() {
                if(pos.next == null) {
                    return false;
                }else {
                    return true;
                }
            }

            @Override
            public T next() {
                if(hasNext()) {
                    pos = pos.next;
                    T cont = pos.content;
                    nextCalled = false;
                    return cont;
                }else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                if(pos == null || nextCalled) {
                    throw new IllegalStateException();
                }
                Node<T> prev = pos.prev;
                Node<T> next = pos.next;
                prev.next = next;
                next.prev = prev; 
                nextCalled = true;
            }
        };
    }
    
}
