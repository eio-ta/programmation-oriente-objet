import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Arbre {
	private Noeud racine;
	
	public Arbre(String chemin) throws FileNotFoundException {
		racine = new Noeud(new File(chemin));
	}
	
	public void afficher() {
		racine.afficher(0);
	}
	
	public class Noeud {
		private String nom;
		private int taille;
		private boolean repertoire;
		private ArrayList<Noeud> fils;
		
		public Noeud(File file) throws FileNotFoundException {
			if(file.exists()) {
				this.nom = file.getName();
				this.taille = (int) file.length();
				if(file.isDirectory()) {
					repertoire = true;
					File[] files = file.listFiles();
					fils = new ArrayList<Noeud>();
					if(files.length != 0) {
						for(File f : files) {
							fils.add(new Noeud(f));
						}
					}
				} else {
					repertoire = false;
					fils = null;
				}
			} else throw new FileNotFoundException();
		}
		
		public void afficher(int dec) {
			String r = " ";
			r = r.repeat(dec);
			System.out.println(r + this.nom + " [" + this.taille + "]");
			if(fils != null) {
				for(int i=0; i<fils.size(); i++) {
					fils.get(i).afficher(dec + 2);
				}
			}
		}
		
		public void map(StringTransformation t) {
			if(!this.repertoire) this.nom = t.transf(this.nom);
			else {
				fils.forEach((e) -> e.map(t));
			}
		}
		
		public void traverser(String extension) {
			if(this.nom.endsWith(extension)) {
				System.out.println(this.nom + " [" + this.taille + "]");
			}
			if(fils != null) {
				for(int i=0; i<fils.size(); i++) {
					fils.get(i).traverser(extension);
				}
			}
		}
		
		public boolean supprimer(String extension) {
			boolean b = false;
			if(repertoire) {
				for(int i = fils.size()-1; i>=0; i--) {
					if(fils.get(i).repertoire) {
						b = b || fils.get(i).supprimer(extension);
					}
					if(!fils.get(i).repertoire && fils.get(i).nom.endsWith(extension)) {
						fils.remove(i);
						b = true;
					}
				}
			}
			return b;
		}
	}
	
	public void map(StringTransformation t) {
		racine.map(t);
	}
	
	public void traverser(String extension) {
		racine.traverser(extension);
	}
	
	public void supprimer(String extension) {
		racine.supprimer(extension);
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnableToDeleteFileException {
		StringTransformation addBlah = (String s) -> (s + ".blah");
		Arbre a = new Arbre("racine");
		Arbre b = new Arbre("racine");
		
		a.afficher();
		System.out.println();
		
		// Test Exercice 4
		a.map(addBlah);
		a.afficher();
		System.out.println();
		
		//Test Exercice 5
		b.traverser("txt");
		b.supprimer("txt");
		System.out.println();
		b.afficher();
		
		
		
	}

}
