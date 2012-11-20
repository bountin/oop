
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Kann nicht von Set erben weil die Methode insert hier einen spezielleren Typ
 * verlangt!
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class OrderedSet<K extends Shorter<K>> implements Iterable<K> {

    protected class Node<K> {

        protected K content;
        protected Node<K> next = null;
        protected Node<K> prev = null;

        public Node(K content) {
            this.content = content;
        }
    }
    protected Node<K> root = null;

    /**
     * Fuegt geordnet in Liste ein falls unique. Kurz = Vorne, Lang = Hinten
     * @param content 
     */
    public void insert(K content) {
        Node<K> n = new Node<K>(content);
        boolean isUnique = true;
        for (K cont : this) {
            if (n.content.equals(cont)) {
                isUnique = false;
            }
        }
        if (isUnique) {
            if (root == null) {
                root = n;
            } else {
                Node<K> act = root;
                Node<K> lastact = null;
                while (act != null && act.content.shorter(content)) {
                    lastact = act;
                    act = act.next;
                }
                Node<K> prev = lastact;
                Node<K> next = act;
                if (prev == null) {
                    n.next = root;
                    root.prev = n.next;
                    root = n;
                } else {
                    prev.next = n;
                    n.prev = prev;
                }
                if (next != null) {
                    n.next = next;
                    next.prev = n;
                }
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
