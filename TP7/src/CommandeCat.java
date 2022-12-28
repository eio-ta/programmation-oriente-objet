
public class CommandeCat extends CommandeShell {

	public CommandeCat(Dossier racine, Dossier courant, String[] para) {
		super(racine, courant, para);
	}

	@Override
	public Dossier executer() {
		if(para.length != 1) {
			erreurParam();
			aide();
		} else {
			Entree e = acceder(para[0], false);
			if(e != null && e.getElement() instanceof Affichable) {
				Affichable a = (Affichable) e.getElement();
				a.afficher();
			}
		}
		return courant;
	}
	
	public static void aide() {
		System.out.println("cat <name>");
	}
}