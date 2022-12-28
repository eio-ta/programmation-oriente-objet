
public class Plateau {
	private int longueur;
	private int largeur;
	private Case[] cases; //tableau simple mais on pouvait aussi faire double tableau
	
	public Plateau(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.cases = new Case[longueur * largeur];
		
		for(int i=0; i<largeur; i++) {
			for(int j=0; j<longueur; j++) {
				int indice = i+j*largeur;
				cases[indice] = new Case((i+j)%2 == 1);
			}
		}
	}
	
	public boolean horsLimite(int x, int y) {
		if((x>this.largeur || x<=0)) return true;
		if(y>this.longueur || y<=0) return true;
		return false;
	}
	
	public boolean horsLimite(Deplacement d) {
		int x1 = d.getX1();
		int y1 = d.getY1();
		return horsLimite(x1, y1);
	}
	
	public Case getCase(int x, int y) {
		if(horsLimite(x, y)) return null;
		return cases[(y-1)*largeur+(x-1)];
	}
	
	public void videCase(int x, int y) {
		if(!horsLimite(x,y)) {
			cases[(y-1)*largeur+(x-1)].enleverPiece();
		}
	}
	
	public void remplirCase(int x, int y, Piece p) {
		if(!horsLimite(x, y)) {
			cases[(y-1)*largeur+(x-1)].remplirPiece(p);
		}
	}
	
	public void afficher() {
		for(int i=0; i<cases.length; i++) {
			System.out.print(cases[i]);
			if(i % longueur == longueur-1) {
				System.out.println();
			}
		}
	}
	

}
