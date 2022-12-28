import java.util.Scanner;

public class Communication {
	Scanner scanReponse;
	
	public Communication() {
		this.scanReponse = new Scanner(System.in);
	}
	
	public Deplacement demanderDeplacement(boolean joueur) {
		System.out.println("Coordonnées de la pièce a déplacer ? (de la forme 2,3 ou 5,3)");
		String s = scanReponse.nextLine();
		int x0 = Character.getNumericValue(s.charAt(0));
		int y0 = Character.getNumericValue(s.charAt(2));
		System.out.println("Coordonnées de la nouvelle case de la pièce à déplacer ? (de la forme 2,3 ou 5,3)");
		String st = scanReponse.nextLine();
		int x1 = Character.getNumericValue(st.charAt(0));
		int y1 = Character.getNumericValue(st.charAt(2));
		return new Deplacement(x0,y0,x1,y1);
	}

}
