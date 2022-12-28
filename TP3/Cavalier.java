
public class Cavalier extends Piece{

	public Cavalier(boolean couleur) {
		super(couleur, "Cavalier");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		if(!p.horsLimite(d)) {
			if(d.typeDeplacement() == 'c') {
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
