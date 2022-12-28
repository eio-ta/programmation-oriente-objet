
public class Jeu {
	private Joueur joueur;
	private Plateau plateau;
	
	public Jeu(Joueur joueur, Plateau plateau) {
		this.joueur = joueur;
		this.plateau = plateau;
	}
	
	public void jouer() {
		System.out.println("................... L O A D I N G ...................");
		plateau.afficheCourant();
		System.out.println();
		
		while(plateau.jeuGagne() == false && plateau.jeuPerdu() == false) {
			char action = this.joueur.demanderAction();
			if(action == 'r') System.out.println("Vous allez reveler une case.");
			if(action == 'd') System.out.println("Vous allez mettre un drapeau.");
			int[] coordonnes = this.joueur.demanderCoordonnes();
			System.out.println(coordonnes[0] + " " + coordonnes[1]);
			if(action == 'r') this.plateau.revelerCase(coordonnes[0], coordonnes[1]);
			if(action == 'd') this.plateau.drapeauCase(coordonnes[0], coordonnes[1]);
			plateau.afficheCourant();
			System.out.println();
		}
		
		if(plateau.jeuGagne()) System.out.println("Vous avez gagne !");
		if(plateau.jeuPerdu()) System.out.println("Vous avez perdu !");
		
		System.out.println("Voilà le plateau :");
		plateau.afficheTout();
		
	}
}
