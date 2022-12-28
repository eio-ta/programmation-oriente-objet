import java.io.*;
import java.util.*;

public class Formateur {
	protected Scanner sc;
	protected LinkedList<BoiteComposite> liste;
	
	//Constructor
	public Formateur(String fic) {
		sc = null;
		try {
			sc = new Scanner(new File(fic));
		}
		catch(Exception e){
			System.out.println("Erreur lors d’ouverture fichier:");
			e.printStackTrace();
			System.exit(1);
		}
		liste = new LinkedList<BoiteComposite>();
	}
	
	public void read(){
		sc.useDelimiter("\n\\s*\n");
		while(sc.hasNext()) {
			BoiteComposite p = readParagraphe();
			liste.add(p);
		}
	}
	
	public BoiteComposite readParagraphe() {
		BoiteComposite paragraphe = new BoiteComposite();
		String para = sc.next();
		Scanner s = new Scanner(para);
		while(s.hasNext()){
			paragraphe.addBoite(new BoiteMot(s.next()));
			paragraphe.addBoite(new BoiteEspace());
		}
		return paragraphe;
	}
	
	public void print() {
		int taille = liste.size();
		for(int i=0; i<taille; i++) {
			printParagraphe(liste.get(i));
			System.out.println();
		}
	}
	
	public void printParagraphe(BoiteComposite b) {
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		
//		Test Exercice 4
//		Formateur f = new Formateur("textes/vide");
//		f.read();
//		f.print();
//		
//		Formateur f2 = new Formateur("textes/videBis");
//		f2.read();
//		f2.print();
//		
		Formateur f3 = new Formateur("textes/texte");
		f3.read();
		f3.print();
//		
//		Formateur f4 = new Formateur("textes/texteBis");
//		f4.read();
//		f4.print();
		
	}

}
