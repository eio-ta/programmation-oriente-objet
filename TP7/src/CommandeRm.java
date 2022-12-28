
public class CommandeRm extends CommandeShell{

	public CommandeRm(Dossier racine, Dossier courant, String[] para) {
		super(racine, courant, para);
	}

	@Override
	public Dossier executer() {
		if(para.length != 1) {
			erreurParam();
			aide();
		} else {
			Entree e = acceder(para[0], false);
			if(e != null) {
				if(e instanceof EntreeSpeciale) {
					EntreeSpeciale es = (EntreeSpeciale) e;
					es.supprimer();
				} else {
					e.supprimer();
				}
			} else {
				System.out.println("erreur chemin");
			}
		}
		return courant;
	}
	
	public static void aide() {
		System.out.println("rm <name>");
	}

}