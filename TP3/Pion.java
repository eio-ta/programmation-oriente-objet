
public class Pion extends Piece {

	public Pion(boolean couleur) {
		super(couleur, "Pion");
	}
	
	public boolean estValide(Deplacement d, Plateau p) {
		int x1 = d.getX1();
		int y0 = d.getY0();
		int y1 = d.getY1();
		int x0 = d.getX0();
		
		if(!p.horsLimite(d)) {
			if(d.typeDeplacement() == 'v' && d.dist() == 1 && x1 == x0) {
				if(p.getCase(x1,y1).estVide()) {
					return true;
				}
				return false;
			}
			if(d.typeDeplacement() == 'd' && d.dist() == 1) {
				if(p.getCase(x1,y1).estVide()) {
					return false;
				}
				return true;
			}
			if(d.typeDeplacement() == 'v' && d.dist() == 2 && x1 == x0+2) {
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
