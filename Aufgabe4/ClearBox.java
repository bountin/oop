
// Der Rand besteht immer aus Sternchen
// Der Inhalt besteht immer aus Leerzeichen
// Die Hoehe und die Breite sind immer > 0
// Skalierung basiert auf Streckung
public class ClearBox extends Box{

	public ClearBox(double width, double height) {
		super('*',' ',width,height);
	}

	public double getRatio(){
		return width/height;
	}
}
