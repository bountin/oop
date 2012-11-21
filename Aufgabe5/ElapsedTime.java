
public class ElapsedTime implements Shorter<ElapsedTime>{

	private Double value;
	private int repetitions;
	
	public ElapsedTime(double value, int repetitions) {
		this.value = value;
		this.repetitions = repetitions;
	}

	@Override
	public boolean shorter(ElapsedTime other) {
		return this.getValue() < other.getValue();
	}
	
	public double getValue(){
		return this.value;
	}
	
	public int count(){
		return this.repetitions;
	}
}
