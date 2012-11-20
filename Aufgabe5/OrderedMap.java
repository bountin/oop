
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class OrderedMap<K extends Shorter<K>, V> extends OrderedSet<K> {


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

            public Iterator<V> iterator() {
                return new Iterator<V>() {

                    @Override
                    public boolean hasNext() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    @Override
                    public V next() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public void add(V content) {
                    }
                };
            }
        };
    }
}
