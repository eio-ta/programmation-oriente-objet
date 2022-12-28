
public class Tour extends Piece{

	public Tour(boolean couleur) {
		super(couleur, "Tour");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		if(!p.horsLimite(d)) {
			if(d.typeDeplacement() == 'v' || d.typeDeplacement() == 'h') {
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
