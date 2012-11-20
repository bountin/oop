
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Kann nicht von Set erben weil die Methode insert hier einen spezielleren Typ
 * verlangt!
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class OrderedSet<T extends Shorter> implements Iterable<T> {

    private class Node<T> {

        private T content;
        private Node<T> next = null;
        private Node<T> prev = null;

        public Node(T content) {
            this.content = content;
        }
    }
    private Node<T> root = null;

    /**
     * Fuegt geordnet in Liste ein falls unique. Kurz = Vorne, Lang = Hinten
     * @param content 
     */
    public void insert(T content) {
        Node<T> n = new Node<T>(content);
        boolean isUnique = true;
        for (T cont : this) {
            if (n.content.equals(cont)) {
                isUnique = false;
            }
        }
        if (isUnique) {
            if (root == null) {
                root = n;
            } else {
                Node<T> act = root;
                Node<T> lastact = null;
                while (act != null && act.content.shorter(content)) {
                    lastact = act;
                    act = act.next;
                }
                Node<T> prev = lastact;
                Node<T> next = act;
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
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> pos = root;
            Node<T> lastpos = null;

            @Override
            public boolean hasNext() {
                if (pos == null) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T cont = pos.content;
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
                Node<T> prev = lastpos.prev;
                Node<T> next = lastpos.next;
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
