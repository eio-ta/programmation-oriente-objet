public class Palette {
	private Vue view ;
	private Modele modele = new Modele();
	private Controleur controleur = new Controleur();

	public Palette() {
		view = new Vue ();
		view.setVisible(true);
		
		//Changer les attributs de this		
		modele.couleur = view.panneauColore.getBackground();
		controleur.m = this.modele;
		controleur.view = this.view;
		
		// Changer les attributs de View
		view.modele = this.modele;
		view.controleur = this.controleur;
		
		// Changer les attributs de Controleur
		controleur.m = this.modele;
		controleur.view = this.view;
	}
	
	public static void main ( String [] args ) {
		new Palette();
	}
}