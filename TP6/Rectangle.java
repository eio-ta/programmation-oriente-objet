
public class Rectangle extends Figure implements Deformable {
	private static final Figure Carre = null;
	private final double largeur;
	private final double hauteur;
	
	public Rectangle(int x, int y, double largeur, double hauteur) {
		super(x,y);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	@Override
	public void affiche() {
		System.out.println("Coordonées du centre : (" + super.getPosX() + "," + super.getPosY() + ")");
		System.out.println("Largeur du rectangle : " + this.largeur);
		System.out.println("Hauteur du rectangle : " + this.hauteur);
		System.out.println();
	}
	
	@Override
	public Figure deformation(double coeffH, double coeffV) {
		double newLargeur = this.largeur*coeffH;
		double newHauteur = this.hauteur*coeffV;
		if(newLargeur == newHauteur) {
			double cote = newLargeur;
			return new Carre(super.getPosX(), super.getPosY(), cote);
		} else {
			return new Rectangle(super.getPosX(), super.getPosY(), newLargeur, newHauteur);
		}
	}

	@Override
	//Pour cette méthode, on pouvait aussi utiliser la fonction de la classe Triangle. On pouvait découper notre rectangle en deux et additionner les deux aires.
	public double surface() {
		return this.largeur*this.hauteur;
	}
}
