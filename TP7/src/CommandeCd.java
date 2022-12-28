
public class CommandeCd extends CommandeShell {

	public CommandeCd(Dossier racine, Dossier courant, String[] para) {
		super(racine, courant, para);
	}

	@Override
	public Dossier executer() {
		
		if(para.length == 0) {
			return racine;
		} else if(para.length == 1) {
			Entree entree = acceder(para[0], false);
			if(entree != null) {
				Element elem = entree.getElement();
				if(entree.getElement() instanceof Dossier) {
					return (Dossier) elem;
				}
			} else {
				System.out.println("erreur chemin");
				return courant;
			}
		} else {
			erreurParam();
			aide();
		}
		return courant;
	}
	
	public static void aide() {
		System.out.println("cd [<foldername>]");
	}

}