
public class Echecs {
	private static boolean joueur = true; //joueur courant, blanc = true, noir = false
	
	public static void placement5x5(Plateau plateau) {
		//Placement des pieces noires
		Piece T1 = new Tour(false);
		Piece C1 = new Cavalier(false);
		Piece F1 = new Fou(false);
		Piece D1 = new Dame(false);
		Piece R1 = new Roi(false);
		Piece P1 = new Pion(false);
		
		plateau.remplirCase(1, 1, T1);
		plateau.remplirCase(2, 1, C1);
		plateau.remplirCase(3, 1, F1);
		plateau.remplirCase(4, 1, D1);
		plateau.remplirCase(5, 1, R1);
		
		for(int i=1; i<=5; i++) {
			plateau.remplirCase(i, 2, P1);
		}
		
		//Placement des pieces blanches
		Piece T2 = new Tour(true);
		Piece C2 = new Cavalier(true);
		Piece F2 = new Fou(true);
		Piece D2 = new Dame(true);
		Piece R2 = new Roi(true);
		Piece P2 = new Pion(true);
		
		plateau.remplirCase(1, 5, T2);
		plateau.remplirCase(2, 5, C2);
		plateau.remplirCase(3, 5, F2);
		plateau.remplirCase(4, 5, D2);
		plateau.remplirCase(5, 5, R2);
		
		for(int i=1; i<=5; i++) {
			plateau.remplirCase(i, 4, P2);
		}
	}

	public static void testpiece(Plateau plateau) {
//		Pour le ROI :
		Piece r1 = plateau.getCase(5, 1).getPiece();
		Deplacement d1 = new Deplacement(5,1,6,1);
		Deplacement d2 = new Deplacement(5,1,4,1);
		Deplacement d3 = new Deplacement(5,1,5,3);
		System.out.println(r1.estValide(d1, plateau));
		System.out.println(r1.estValide(d2, plateau));
		System.out.println(r1.estValide(d3, plateau));
		System.out.println();
		
//		Pour la DAME:
		Piece dame = plateau.getCase(4, 1).getPiece();
		Deplacement dd1 = new Deplacement(4,1,1,1);
		Deplacement dd2 = new Deplacement(4,1,8,1);
		Deplacement dd3 = new Deplacement(4,1,3,2);
		System.out.println(dame.estValide(dd1, plateau));
		System.out.println(dame.estValide(dd2, plateau));
		System.out.println(dame.estValide(dd3, plateau));
		System.out.println();
		
//		Pour LA TOUR:
		Piece tour = plateau.getCase(1, 1).getPiece();
		Deplacement de1 = new Deplacement(1,1,1,5);
		Deplacement de2 = new Deplacement(1,1,8,1);
		Deplacement de3 = new Deplacement(1,1,3,2);
		System.out.println(tour.estValide(de1, plateau));
		System.out.println(tour.estValide(de2, plateau));
		System.out.println(tour.estValide(de3, plateau));
		System.out.println();
		
//		Pour LE FOU:
		Piece fou = plateau.getCase(3, 1).getPiece();
		Deplacement df1 = new Deplacement(3,1,2,2);
		Deplacement df2 = new Deplacement(3,1,8,1);
		Deplacement df3 = new Deplacement(3,1,3,2);
		System.out.println(fou.estValide(df1, plateau));
		System.out.println(fou.estValide(df2, plateau));
		System.out.println(fou.estValide(df3, plateau));
		System.out.println();

//		Pour LE PION:
		Piece pion = plateau.getCase(1,2).getPiece();
		Deplacement dp1 = new Deplacement(1,2,2,2);
		Deplacement dp2 = new Deplacement(1,2,1,3);
		Deplacement dp3 = new Deplacement(1,2,2,3);
		System.out.println(pion.estValide(dp1, plateau));
		System.out.println(pion.estValide(dp2, plateau));
		System.out.println(pion.estValide(dp3, plateau));
		System.out.println();
		
//		Pour LE CAVALIER:
		Piece cavalier = plateau.getCase(2,1).getPiece();
		Deplacement dc1 = new Deplacement(2,1,4,2);
		Deplacement dc2 = new Deplacement(2,1,3,3);
		Deplacement dc3 = new Deplacement(2,1,5,1);
		System.out.println(cavalier.estValide(dc1, plateau));
		System.out.println(cavalier.estValide(dc2, plateau));
		System.out.println(cavalier.estValide(dc3, plateau));
		System.out.println();
	}
	
	public static void jouerTour(Deplacement d, boolean joueur, Plateau p) {
		int x1 = d.getX1();
		int y0 = d.getY0();
		int y1 = d.getY1();
		int x0 = d.getX0();

		if(!p.getCase(x0, y0).estVide() && p.getCase(x0, y0).getPiece().getCouleur() == joueur && p.getCase(x0, y0).getPiece().estValide(d, p) && (p.getCase(x1, y1).estVide() || p.getCase(x1, y1).getCouleur() != joueur)) {
			Piece tmp = p.getCase(x0, y0).getPiece();
			p.videCase(x0, y0);
			if(p.getCase(x1, y1).estVide()) {
				p.remplirCase(x1, y1, tmp);
			} else {
				p.videCase(x1, y1);
				p.remplirCase(x1, y1, tmp);
			}
		} else {
			System.out.println("Ce changement n'est pas possible.");
		}
	}
	
	public static void jouerPartir(Plateau plateau) {
		Communication communication = new Communication();
		boolean partieFinie = false;
		while(!partieFinie) {
			Deplacement coup = communication.demanderDeplacement(joueur);
			while(plateau.getCase(coup.getX0(), coup.getY0()).getPiece().estValide(coup, plateau) == false) {
				System.out.println("Ce coup n'est pas valide.");
				coup = communication.demanderDeplacement(joueur);
			}
			
			
			if(!plateau.getCase(coup.getX1(), coup.getY1()).estVide()) {
				Piece tmp = plateau.getCase(coup.getX1(), coup.getY1()).getPiece();
				jouerTour(coup, joueur, plateau);
				if(tmp.estRoi()) {
					partieFinie = true;
					if(joueur = true) System.out.println("Les Blancs ont gagné !");
					if(joueur = false) System.out.println("Les Noirs ont gagné !");
				} else {
					if(joueur = true) joueur = false;
					if(joueur = false) joueur = true;
					plateau.afficher();
//					System.out.println();
					System.out.println("Changement de joueur");
				}
			} else {
				jouerTour(coup, joueur, plateau);
				if(joueur = true) joueur = false;
				if(joueur = false) joueur = true;
				plateau.afficher();
//				System.out.println();
				System.out.println("Changement de joueur");
			}
			
		}
	}
	
	public static void main(String[] args) {
				
//		Exercice 2 : Pas besoin de redefinir la methode toString(), la methode est heritee.
//		Piece a = new Roi(true);
//		System.out.println(a);
//				
//		Test de l'exercice 3, question 4
//		On considere que la premiere case du tableau est (1,1).
//		Plateau b = new Plateau(8,8);
//		b.remplirCase(2, 5, a);
//		System.out.println(b.getCase(2, 5));
//		b.afficher();

				
//		Initialisation du plateau 5X5 (baby chess)
		Plateau plateau = new Plateau(5,5);
		placement5x5(plateau);
		plateau.afficher();
		System.out.println();
		
//		Pour les tests des pieces
		testpiece(plateau);
		
//		Test de l'exercice 7, question 3
//		Deplacement d = new Deplacement(2,4,2,3);
//		jouerTour(d, true, plateau);
//		plateau.afficher();
//		System.out.println();
//		Deplacement d1 = new Deplacement(3,2,2,3);
//		jouerTour(d1, false, plateau);
//		plateau.afficher();
//		System.out.println();
//		Deplacement d2 = new Deplacement(3,4,2,3);
//		jouerTour(d2, true, plateau);
//		plateau.afficher();
//		System.out.println();
		
//		Test de l'exercice 8, question 3
//		jouerPartir(plateau);	

	}

}
