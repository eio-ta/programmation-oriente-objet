
public class Ellipse extends Figure implements Deformable {
	private final double petit_rayon;
	private final double grand_rayon;
	
	public Ellipse(int x, int y, double petit_rayon, double grand_rayon) {
		super(x, y);
		this.petit_rayon = petit_rayon;
		this.grand_rayon = grand_rayon;
	}
	
	@Override
	public void affiche() {
		System.out.println("Coordonées du centre : (" + super.getPosX() + "," + super.getPosY() + ")");
		System.out.println("Petit rayon de l'ellipse : " + this.petit_rayon);
		System.out.println("Grand rayon de l'ellipse : " + this.grand_rayon);
		System.out.println();
	}
	
	@Override
	public Figure deformation(double coeffH, double coeffV) {
		double newRayonH = this.grand_rayon*coeffH;
		double newRayonV = this.petit_rayon*coeffV;
		if(newRayonH == newRayonV) {
			double rayon = newRayonH;
			return new Circle(super.getPosX(), super.getPosY(), rayon);
		} else {
			return new Ellipse(super.getPosX(), super.getPosY(), newRayonH, newRayonV);	
		}
	}
	
	@Override
	public double surface() {
		return Math.PI*this.grand_rayon*this.petit_rayon;
	}
}
