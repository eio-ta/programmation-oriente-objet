import java.util.ArrayList;
import java.util.LinkedList;

public class Mediatheque {
	LinkedList<Media> baseDeDonnees;
	
	public Mediatheque() {
		baseDeDonnees = new LinkedList<Media> ();
	}
	
	public void ajouter(Media doc) {
		if(baseDeDonnees.isEmpty()) {
			baseDeDonnees.push(doc);
			return;
		} else {
			int indice = 0;
			for(int i=0; i<baseDeDonnees.size(); i++) {
				Media test = baseDeDonnees.get(i);
				if(!doc.plusPetit(test)) {
					indice++;
				} else {
					indice = i;
					break;
				}
			}
			baseDeDonnees.add(indice, doc);
		}
	}
	
	public void afficher() { //Afficher tous les médias enregistres
		int taille = baseDeDonnees.size();
		int i = 0;
		while(i != taille) {
			Media tmp = baseDeDonnees.get(i);
			System.out.println(tmp);
			i++;
		}
	}
	
	public void tousLesDictionnaires() { //imprime tous les dicos
		int taille = baseDeDonnees.size();
		int i = 0;
		while(i != taille) {
			Media tmp = baseDeDonnees.get(i);
			if(tmp instanceof Dictionnaire) System.out.println(tmp);
			i++;
		}
	}
	
	public ArrayList<Media> recherche(Predicat p) {
		ArrayList<Media> tab = new ArrayList<Media> ();
		int taille = baseDeDonnees.size();
		int i = 0;
		while(i != taille) {
			if(p.estVrai(baseDeDonnees.get(i))) {
				Media tmp = baseDeDonnees.get(i);
				tab.add(tmp);
			}
			i++;
		}
		return tab;
	}
	
	
	
	public static void main(String[] args) {
		//Test de l'exercice 3
		Mediatheque mediatheque = new Mediatheque();
		Media a = new Livre("Le Petit Prince", "Saint Exupéry", 93);
		Media b = new Dictionnaire("Larousse", "Larousse", 1736, "Français", 1);
		Media c = new Manga("Spy x Family", "Endo", 183);
		Media d = new DictionnaireBilingue("Dico Anglais/Français", "Larousse", 1565, "Anglais", 3);
		Media e = new Livre("Le Petit Poucet", "Charles Perault", 13);
		
		mediatheque.ajouter(a);
		mediatheque.ajouter(b);
		mediatheque.ajouter(c);
		mediatheque.ajouter(d);
		mediatheque.ajouter(e);
		
		mediatheque.afficher();
		System.out.println();
		mediatheque.tousLesDictionnaires();
		System.out.println();
		
		//Test de l'exercice 5
		Predicat p1 = new estUnLivre();
		Predicat p2 = new TitreCommenceparS();
		Predicat p3 = new Et(p1, p2);
		
		ArrayList<Media> tab = new ArrayList<Media> ();
		tab = mediatheque.recherche(p3);
		
		for(Media elem: tab) {
			System.out.println(elem);
		}
	}
}
