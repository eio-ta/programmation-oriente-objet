import java.io.*;
import java.util.*;

public class FormateurLimite extends Formateur {
	private int largeur; //longueur maximum d'une ligne
	private LinkedList<LinkedList<BoiteComposite>> listeB; //liste de liste de boite
	
	public FormateurLimite(String fic, int largeur) {
		super(fic);
		this.largeur = largeur;
		this.listeB = new LinkedList<LinkedList<BoiteComposite>>();
	}
	
	
	public void read(){
		sc.useDelimiter("\n\\s*\n");
		while(sc.hasNext()) { 
			BoiteComposite p = super.readParagraphe();
			LinkedList<BoiteComposite> listePara = new LinkedList<BoiteComposite>();
			
			//BoiteComposite de taille largeur
			int nbBloc = p.size()/largeur;
			int cmp = 0;
			while (nbBloc != 0) {
				BoiteComposite tmp = new BoiteComposite();
				for(int i=0; i<largeur; i++) {
					tmp.addBoite(p.get(cmp+i));
				}
				listePara.add(tmp);
				cmp+= largeur;
				nbBloc--;
			}
			
			//dernier mot du paragraphe
			BoiteComposite tmp = new BoiteComposite();
			for(int i=p.size()-(p.size()%largeur); i<p.size(); i++) {
				tmp.addBoite(p.get(i));
			}
			listePara.add(tmp);
			listeB.add(listePara);
		}
	}
	
	public void print() {
		int taille = listeB.size();
		for(int i=0; i<taille; i++) {
			for(int j=0; j<listeB.get(i).size(); j++) {
				super.printParagraphe(listeB.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public void printJustifie() {
		//voir quelle ligne a le + de caractère
		int indice1 = 0;
		int indice2 = 0;
		int longueurmax = 0;
		
		for(int i=0; i<listeB.size(); i++) {
			for(int j=0; j<listeB.get(i).size(); j++) {
				if(listeB.get(i).get(j).length() > longueurmax) {
					indice1 = i;
					indice2 = j;
					longueurmax = listeB.get(i).get(j).length();
				}
			}
		}
		
		//Afficher toutes les lignes de longueur longueurmax
		
		for(int i=0; i<listeB.size(); i++) {
			for(int j=0; j<listeB.get(i).size(); j++) {
				if(listeB.get(i).get(j).length() < longueurmax) {
					int diff = longueurmax-listeB.get(i).get(j).length();
					if(listeB.get(i).get(j).isEtirable()) {
						printParagrapheJustifie(listeB.get(i).get(j), diff);
					} else {
						printParagraphe(listeB.get(i).get(j));
					}
					System.out.println();
				} else {
					super.printParagraphe(listeB.get(i).get(j));
					System.out.println();
				}
			}
		}
	}
	
	public void printParagrapheJustifie(BoiteComposite b, int diff) {
		System.out.print(b.toString(diff));
	}
	
	public static void main(String[] args) {
//		Test Exercice 5
//		Formateur f = new FormateurLimite("textes/texte", 7);
//		f.read();
//		f.print();
		
//		Formateur f1 = new FormateurLimite("textes/texte", 50);
//		f1.read();
//		f1.print();
		
//		Test Exercice 10 et 11
		FormateurLimite f2 = new FormateurLimite("textes/texte", 50);
		f2.read();
		//f2.print();
		f2.printJustifie();
	}
}
