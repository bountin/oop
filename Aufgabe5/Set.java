
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Einfach verkettete List mit einmaligen Elementen
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Set<K> implements Iterable<K> {

    private class Node<K> {

        private K content;
        private Node<K> next = null;
        private Node<K> prev = null;

        public Node(K content) {
            this.content = content;
        }
    }
    private Node<K> root = null;

    // Fuegt hinten in der Liste ein, falls unique.
    public void insert(K content) {
        Node<K> n = new Node<K>(content);
        boolean isUnique = true;
        for (K cont : this) {
            if (n.content.equals(cont)) {
                isUnique = false;
            }
        }
        if (isUnique) {
            Node<K> last = root;
            if (root == null) {
                root = n;
            } else {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = n;
                n.prev = last;
            }
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            Node<K> pos = root;
            Node<K> lastpos = null;

            @Override
            public boolean hasNext() {
                if (pos == null) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public K next() {
                if (hasNext()) {
                    K cont = pos.content;
                    lastpos = pos;
                    pos = pos.next;
                    return cont;
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                if (lastpos == null) {
                    throw new IllegalStateException();
                }
                Node<K> prev = lastpos.prev;
                Node<K> next = lastpos.next;
                if (prev != null) {
                    prev.next = next;
                } else {
                    root = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
                lastpos = null;
            }
        };
        
        
    }
}
