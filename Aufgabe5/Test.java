
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
      
        System.out.println("--- TEST # 1 ---");
        OrderedSet<Description> t1 = new OrderedSet<Description>();
        Description d1 = new Description("55555");
        Description d2 = new Description("22");
        Description d3 = new Description("88888888");
        Description d4 = new Description("55555");
        Description d5 = new Description("333");
        t1.insert(d1);
        t1.insert(d2);
        t1.insert(d3);
        t1.insert(d4);
        t1.insert(d5);
        Iterator<Description> i1 = t1.iterator();
        while(i1.hasNext()){
        	System.out.println(i1.next().toString());
        }
        System.out.println("------");
        t1.insert(d2);
        t1.insert(new Description("1"));
        t1.insert(new Description("4444"));
        i1 = t1.iterator();
        while(i1.hasNext()){
        	System.out.println(i1.next().toString());
        }  
        /*System.out.println("--- TEST # 2 ---");
        OrderedMap<MeanElapsedTime,CompositeTime> t2 = new OrderedMap<MeanElapsedTime,CompositeTime>();
        */
        MeanElapsedTime m1 = new MeanElapsedTime();
         
        m1.add(3.3);
        m1.add(43);
        m1.add(1.8);
        m1.add(13.3);
        MeanElapsedTime m2 = new MeanElapsedTime();
        m2.add(33.3);
        m2.add(4);
        m2.add(18);
        m2.add(1.3);
        m2.add(1.4);
        MeanElapsedTime m3 = new MeanElapsedTime();
        m3.add(0.3);
        m3.add(0.4);
        m3.add(3.3);
        MeanElapsedTime m4 = new MeanElapsedTime();
        m4.add(18);
        m4.add(133);
        
        Double[] double1 = {1.0,3.0,4.0,5.0,5.0};
        Double[] double2 = {1.3,3.0,41.0,7.0,8.0};
        Double[] double3 = {41.0,3.0,4.0};
        Double[] double4 = {1.0,9.0,9.0,5.0,5.0,0.0,2.3};
        CompositeTime c1 = new CompositeTime(double1);
        CompositeTime c2 = new CompositeTime(double2);
        CompositeTime c3 = new CompositeTime(double3);
        CompositeTime c4 = new CompositeTime(double4);
        /*
        t2.insert(m1);
        t2.insert(m2);
        t2.insert(m3);
        t2.insert(m4);
        Iterator<MeanElapsedTime> i2 = t2.iterator();
        // ????
        */
        /*
        System.out.println("--- TEST#3 ---");
         // ????
         */
        System.out.println("--- TEST#4 ---");
        OrderedSet<ElapsedTime> t4 = new OrderedSet<ElapsedTime>();
        t4.insert(m1);
        t4.insert(m2);
        t4.insert(m3);
        t4.insert(m4);
        t4.insert(c1);
        t4.insert(c2);
        t4.insert(c3);
        t4.insert(c4);
        Iterator<ElapsedTime> i3 = t4.iterator();
        while(i3.hasNext()){
        	ElapsedTime temp = i3.next();
        	System.out.println(temp.count() + "---" + temp.getValue());
        }
    }
}
