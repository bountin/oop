import java.util.Iterator;



public class MeanElapsedTime extends ElapsedTime{
	
	private Set<Double> set;

	public MeanElapsedTime() {
		super(0,0);
		this.set = new Set<Double>();
	}
	
	public double getValue(){
		double total = 0.0;
		Iterator<Double> i= set.iterator();
		while(i.hasNext()){
			total += i.next();
		}
		return total/count();
	}
	
	public int count(){
		int total = 0;
		Iterator<Double> i= set.iterator();
		while(i.hasNext()){
			total ++;
			i.next();
		}
		return total+1;
	}

	public void add(double value){
		set.insert(value);
	}
	
	public double max(){
		double max = 0;
		double d;
		Iterator<Double> i= set.iterator();
		while(i.hasNext()){
			if((d = i.next())>max) max = d;
			i.next();
		}
		return max;
	}
}
