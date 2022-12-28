import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {
	private String contenu;
	
	public FichierTexte(String c) {
		this.contenu = c;
	}

	@Override
	public String getType() {
		return "fichier";
	}

	@Override
	public void afficher() {
		System.out.println(contenu);
	}

	@Override
	public void editer(Scanner sc, boolean echo) {
		String s = sc.nextLine();
		while(!s.equals(".")) {
			if(echo) {
				System.out.println(s);
				contenu += s;
			} else {
				contenu += s;
			}
			contenu += "\n";
			s = sc.nextLine();
		}
	}
}
