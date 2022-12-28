import java.util.Scanner;

public class CommandeEd extends CommandeShell {
	private Scanner sc;
	private boolean echo;

	public CommandeEd(Dossier racine, Dossier courant, String[] para, Scanner sc, boolean echo) {
		super(racine, courant, para);
		this.sc = sc;
		this.echo = echo;
	}

	@Override
	public Dossier executer() {
		if(para.length != 1) {
			erreurParam();
			aide();
		} else {
			Entree e = acceder(para[0], true);
			e.remplacer((Element) new FichierTexte(""));
			if(e != null) {
				FichierTexte f = (FichierTexte) e.getElement();
				f.editer(sc, false);
				e.remplacer((Element) f);
			}
		}
		return courant;
	}
	
	public static void aide() {
		System.out.println("ed <filename>");
	}

}