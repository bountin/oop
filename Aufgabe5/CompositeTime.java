
public class CompositeTime extends ElapsedTime{

	private Double[] values;
	
	public CompositeTime(Double[] values) {
		super(0,0);
		this.values = values;
	}
	
	public double getValue(){
		double total = 0;
		for(Double d: values){
			total+= d;
		}
		return total;
	}

	public int count(){
		return values.length;
	}
	
	public double min(){
		double min = Double.MAX_VALUE;
		for(Double d: values){
			if(d<min){
				min = d.doubleValue();
			}
		}
		return min;
	}
}
