import java.util.Scanner;

public class Joueur {
	private String nom;
	Scanner scanReponse;
	
	public Joueur() {
		this.nom = "Anonyme";
		this.scanReponse = new Scanner(System.in);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void finish() {
		scanReponse.close();
	}
	
	public boolean veutJouer() {
		System.out.println("Voulez-vous jouer (oui/non) ?");
		String rep = scanReponse.nextLine();
		if(rep.equals("oui")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String demanderNom() {
		System.out.println("Quel est votre nom ?");
		String rep = scanReponse.nextLine();
		return rep;
	}
	
	public int[] demanderDimensions() {
		int[] dim = new int[2];
		System.out.println("Hauteur ?");
		dim[0] = scanReponse.nextInt();
		System.out.println("Largeur ?");
		dim[1] = scanReponse.nextInt();
		return dim;
	}
	
	public int demanderNbMines() {
		System.out.println("Nombre de mines ?");
		int rep = scanReponse.nextInt();
		return rep;
	}
	
	public char demanderAction() {
		System.out.println("Voulez-vous reveler une case (r) ou placer un drapeau (d) ?");
		char rep = scanReponse.next().charAt(0);
		return rep;
	}
	
	public int[] demanderCoordonnes() {
		System.out.println("Quelle coordonnees ? (forme : B4, C6)");
		scanReponse.nextLine();
		String rep = scanReponse.nextLine();
		int[] coordonnes = new int[2];
		char[] alphabet = {'0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char l = rep.charAt(0);
		
		for(int i=1; i<alphabet.length; i++) {
			if(l == alphabet[i]) {
				coordonnes[0] = i;
			}
		}
		char n = rep.charAt(1);
		coordonnes[1] = Character.getNumericValue(n);
		return coordonnes;
	}
	
	
	

}
