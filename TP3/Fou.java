
public class Fou extends Piece {

	public Fou(boolean couleur) {
		super(couleur, "Fou");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		if(!p.horsLimite(d)) {
			if(d.typeDeplacement() == 'd') {
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
