
public class Triangle extends Figure implements Deformable {
	//triangle toujours isocele et toujours meme position
	// y = hauteur/2
	private final double base;
	private final double hauteur;
	
	public Triangle(int x, double base, double hauteur ) {
		super(x,(int) hauteur/2);
		this.base = base;
		this.hauteur = hauteur;
	}
	
	@Override
	public void affiche() {
		System.out.println("Coordonées du centre : (" + super.getPosX() + "," + super.getPosY() + ")");
		System.out.println("Base du triangle : " + this.base);
		System.out.println("Hauteur du triangle : " + this.hauteur);
		System.out.println();
	}
	
	@Override
	//Cette méthode devrait retourner un triangle
	public Figure deformation(double coeffH, double coeffV) {
		double newBase = this.base*coeffH;
		double newHauteur = this.hauteur*coeffV;
		Figure newTriangle = new Triangle(super.getPosX(), newBase, newHauteur);
		return newTriangle;
	}

	@Override
	public double surface() {
		return (this.base*this.hauteur)/2;
	}
}
