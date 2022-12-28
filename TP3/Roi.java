
public class Roi extends Piece {

	public Roi(boolean couleur) {
		super(couleur, "Roi");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		if(!p.horsLimite(d)) {
			if(d.dist() != 1) {
				return false;
			}
			if(d.typeDeplacement() == 'v' || d.typeDeplacement() == 'd' || d.typeDeplacement() == 'h') {
				return true;
			} else {
			return false;
			}
		} else {
			return false;
		}	
	}
	
	public boolean estRoi() {
		return true;
	}
	
	

}
