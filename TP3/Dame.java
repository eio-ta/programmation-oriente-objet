
public class Dame extends Piece {

	public Dame(boolean couleur) {
		super(couleur, "Dame");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		if(!p.horsLimite(d)) {
			if(d.typeDeplacement() == 'v' || d.typeDeplacement() == 'd' || d.typeDeplacement() == 'h') {
				return true;
			}
			return false;
		} else {
			return false;
		}	
	}
	
	public boolean estRoi() {
		return false;
	}
}
