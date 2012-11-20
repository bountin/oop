
import java.util.Iterator;

/**
 * OrderedSet kann nicht von Set erben weil die Methode insert hier einen 
 * spezielleren Typ als Parameter verlangt.
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("--- TESTE SET ---");

        Set<String> set1 = new Set<String>();
        set1.insert("test1");
        set1.insert("test2");
        set1.insert("test3");
        set1.insert("test1");
        System.out.println("INSERT TEST");
        for (String s : set1) {
            System.out.println(s);
        }
        System.out.println("REMOVE TEST");
        Iterator<String> iter1 = set1.iterator();
        System.out.println("remove: " + iter1.next());
        iter1.remove(); 

        System.out.println("UEBRIGE ELEMENTE");
        for (String s : set1) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("--- TESTE ORDEREDSET ---");
        OrderedSet<TestString> set2 = new OrderedSet<TestString>();
        set2.insert(new TestString("test12"));
        set2.insert(new TestString("test12345"));
        set2.insert(new TestString("test123"));
        set2.insert(new TestString("test123"));
        set2.insert(new TestString("test1"));
        set2.insert(new TestString("test1234"));
        System.out.println("INSERT TEST");
        for (TestString s : set2) {
            System.out.println(s);
        }
        System.out.println("REMOVE TEST");
        Iterator<TestString> iter2 = set2.iterator();
        iter2.next();iter2.next();iter2.next();
        System.out.println("remove: " + iter2.next());
        iter2.remove();

        System.out.println("UEBRIGE ELEMENTE");
        for (TestString s : set2) {
            System.out.println(s);
        }        
    }
}
