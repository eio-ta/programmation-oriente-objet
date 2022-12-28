
public class Lanceur {

	public static void main(String[] args) {
		/*QUESTION 7
		Plateau p = new Plateau (8, 8, 10);
		p.afficheTout();*/
		
		//Lancement d'une partie, Question 18
		System.out.println("Bienvenue dans le Jeu-TP du Demineur.\n");
		Joueur j = new Joueur();
		String nom = j.demanderNom();
		j.setNom(nom);
		
		while(j.veutJouer()) {
			System.out.println("Nous allons initialiser le plateau de jeu. Veuillez renseigner les informations suivantes.");
			int[] dim = j.demanderDimensions();
			int mi = j.demanderNbMines();
			Plateau p = new Plateau(dim[0], dim[1], mi);
			Jeu jeu = new Jeu(j, p);
			jeu.jouer();
			System.out.println();
		}
		j.finish();
		System.out.println("A plus tard. Revenez jouer quand vous voulez.");
	}
	

}
