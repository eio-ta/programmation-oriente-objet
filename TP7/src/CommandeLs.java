
public class CommandeLs extends CommandeShell {

	public CommandeLs(Dossier racine, Dossier courant, String[] para) {
		super(racine, courant, para);
	}

	@Override
	public Dossier executer() {
		if(para.length == 0) {
			courant.afficher();
		} else if(para.length == 1) {
			Entree entree = acceder(para[0], false);
			if(entree != null && entree.getElement() instanceof Dossier) {
				Dossier d = (Dossier) entree.getElement();
				d.afficher();
			}
			else if(entree != null && entree.getElement() instanceof FichierTexte) {
				System.out.println(entree);
			}
		} else {
			erreurParam();
			aide();
		}
		return courant;
	}
	
	public static void aide() {
		System.out.println("ls [<name>]");
	}

}