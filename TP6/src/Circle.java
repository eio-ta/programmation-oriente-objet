
public class Circle extends Ellipse implements Deformable {
	private final double rayon;
	
	public Circle(int x, int y, double rayon) {
		super(x, y, rayon, rayon);
		this.rayon = rayon;
	}
}
