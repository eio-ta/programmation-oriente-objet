
public class CommandeMkdir extends CommandeShell {

	public CommandeMkdir(Dossier racine, Dossier courant, String[] para) {
		super(racine, courant, para);
	}

	@Override
	public Dossier executer() {
		if(para.length != 1) {
			erreurParam();
			aide();
		} else {			
			Entree e = acceder(para[0], false);
			if(e != null || para[0].equals("..")) {
				System.out.println("Existe deja");
				return courant;
			}
			e = courant.getEntree(para[0], true);
			Dossier d = new Dossier(courant);
			e.remplacer(d);
		}
		
		return courant;
	}
	
	public static void aide() {
		System.out.println("mkdir <foldername>");
	}

}
