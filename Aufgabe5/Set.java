
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

    // Fuegt hinten in der Liste ein, falls unique.
    public void insert(T content) {
        Node<T> n = new Node<T>(content);
        boolean isUnique = true;
        for (T cont : this) {
            if (n.content.equals(cont)) {
                isUnique = false;
            }
        }
        if (isUnique) {
            Node<T> last = root;
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
