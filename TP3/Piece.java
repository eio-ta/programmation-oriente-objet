
public class Piece {
	private boolean couleur; //blanc = true, noir = false
	private String name;
	
	public Piece(boolean couleur, String name) {
		this.couleur = couleur;
		this.name = name;
	}
	
	public boolean getCouleur() {
		return couleur;
	}
	
	public String toString() {
		String s = "";
		if(couleur) {
			s = name.substring(0,1).toLowerCase() + name.substring(1,name.length());
		} else {
			s = name.substring(0,1).toUpperCase() + name.substring(1,name.length());
		}
		return s;
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		if(p.horsLimite(d)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean estRoi() {
		return false;
	}
	


}
