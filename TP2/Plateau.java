import java.util.*;

public class Plateau {
	int ha;
	int la;
	int mi;
	int nbDrapeaux;
	private boolean[][] mines;
	private int[][] etats; //0 : case cachee, 1 : drapeau, 2 : case revelee 
	private int[][] adja;
	
	public Plateau(int ha, int la, int mi) {
		this.ha = ha;
		this.la = la;
		this.mi = mi;
		this.nbDrapeaux = 0;
		mines = new boolean[ha + 2][la + 2];
		ajouteMinesAlea();
		etats = new int[ha + 2][la + 2];
		adja = new int[ha + 2][la + 2];
		calculeAdjacence();
	}
	
	private void ajouteMinesAlea() {
		int tmp = mi;
		Random rd = new Random();
		int l = rd.nextInt(this.la);
		int h = rd.nextInt(this.ha);
		while(tmp != 0) {
			if(mines[h][l] == false) {
				mines[h][l] = true;
				tmp -= 1;
			} else {
				l = rd.nextInt(this.la);
				h = rd.nextInt(this.ha);
			}
		}
	}
	
	private void calculeAdjacence() {
		for(int i=1; i<ha; i++) {
			for(int j=1; j<la; j++) {
				if(mines[i][j] == true) {
					adja[i-1][j-1]++;
					adja[i-1][j]++;
					adja[i-1][j+1]++;
					adja[i][j+1]++;
					adja[i][j-1]++;
					adja[i+1][j]++;
					adja[i+1][j-1]++;
					adja[i+1][j+1]++;
					calculeAdjacenceCaseSup(i, j);
				}
			}
		}
	}
	
	//On fait -2 aux valeurs des cases supplementaires car elles sont initiees à 0, et dans la fonction calculeAdjacence(), on fait dejà +1. Et on veut -1, d'où -2.
	private void calculeAdjacenceCaseSup(int i, int j) {
		if(i == 1) {
			adja[i-1][j-1] -= 2;
			adja[i-1][j] -= 2;
			adja[i-1][j+1] -= 2;
		}
		if(i == this.ha) {
			adja[i+1][j-1] -= 2;
			adja[i+1][j] -= 2;
			adja[i+1][j+1] -= 2;
		}
		if(j == 1) {
			adja[i-1][j-1] -= 2;
			adja[i][j-1] -= 2;
			adja[i+1][j-1] -= 2;
		}
		if(j == this.la) {
			adja[i+1][j+1] -= 2;
			adja[i][j+1] -= 2;
			adja[i-1][j+1] -= 2;
		}
	}
	
	public void revelerCase(int h, int l) {
		if(etats[h][l] == 1) {
			System.out.println("Il y a dejà un drapeau sur cette case.");
		} else {
			etats[h][l] = 2;
			if(adja[h][l] == 0) {
				for(int i=h-1; i<=h+1; i++) {
					for(int j=l-1; j<=l+1; j++) {
						etats[i][j] = 2;
					}
				}
			}
		}
	}
	
	public void drapeauCase(int h, int l) {
		if(etats[h][l] == 2) {
			System.out.println("Cette case a dejà ete revelee.");
		}
		if(etats[h][l] == 1) {
			etats[h][l] = 0;
			nbDrapeaux--;
		}
		if(etats[h][l] == 0) {
			etats[h][l] = 1;
			nbDrapeaux++;
		}
	}
	
	public boolean jeuGagne() {
		int dim = (this.ha*this.la)-this.mi;
		for(int i=1; i<=ha; i++) {
			for(int j=1; j<=la; j++) {
				if(etats[i][j] == 2) {
					if(mines[i][j] == false) {
					dim--;
					}
				}
			}
		}
		if(dim == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean jeuPerdu() {
		for(int i=1; i<=ha; i++) {
			for(int j=1; j<=la; j++) {
				if(etats[i][j] == 2) {
					if(mines[i][j] == true) {
					return true;
					}
				}
			}
		}
		return false;
	}
	
	public void afficheCourant() {
		System.out.println("********************");
		System.out.println("* Mines / Drapeaux *");
		System.out.println("*      " + (this.mi-this.nbDrapeaux) + " / " + this.nbDrapeaux + "      *");
		System.out.println("********************");
		System.out.println();
		
		System.out.print("    ");
		for(int i=1; i<=la; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.print("-----");
		for(int i=1; i<=la; i++) {
			System.out.print("--");
		}
		System.out.println();
		String s = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=1; i<=ha; i++) {
			System.out.print(s.charAt(i) + " | ");
			
			for(int j=1; j<=la; j++) {
				if(etats[i][j] == 2) {
					System.out.print(adja[i][j] + " ");
				}
				if(etats[i][j] == 1) {
					System.out.print("? ");
				}
				if(etats[i][j] == 0) {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
	
	public void afficheTout() {
		System.out.println("********************");
		System.out.println("* Mines / Drapeaux *");
		System.out.println("*      " + this.mi + " / " + this.nbDrapeaux + "      *");
		System.out.println("********************");
		System.out.println();
		
		System.out.print("    ");
		for(int i=1; i<=la; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.print("-----");
		for(int i=1; i<=la; i++) {
			System.out.print("--");
		}
		System.out.println();
		String s = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=1; i<=ha; i++) {
			System.out.print(s.charAt(i) + " | ");
			
			for(int j=1; j<=la; j++) {
				if(mines[i][j] == true) System.out.print("* ");
				else System.out.print(adja[i][j] + " ");
			}
			System.out.println();
		}
	}
}
		
