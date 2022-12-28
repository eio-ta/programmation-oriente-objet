
public class Case {
	private boolean couleur; //blanche = true, noir = false
	private Piece p; //null si pas de piece
	
	public Case(boolean couleur) {
		this.couleur = couleur;
		this.p = null;
	}
	
	public Piece getPiece() {
		return this.p;
	}
	
	public boolean getCouleur() {
		return couleur;
	}
	
	public boolean estVide() {
		return (this.p == null);
	}
	
	public void remplirPiece(Piece p) {
		this.p = p;
	}
	
	public void enleverPiece() {
		this.p = null;
	}
	
	public String toString() {
		if(p == null) {
			if(couleur) {
				return "- ";
			} else {
				return "* ";
			}
		} else {
			return p.toString().substring(0,1) + " ";
		}
	}

}
