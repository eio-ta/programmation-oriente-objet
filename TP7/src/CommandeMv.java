
public class CommandeMv extends CommandeShell {

	public CommandeMv(Dossier racine, Dossier courant, String[] para) {
		super(racine, courant, para);
	}

	@Override
	public Dossier executer() {
		if(para.length != 2) {
			erreurParam();
			aide();
		} else {
			Entree source = acceder(para[0], false);
			Entree destination = acceder(para[1], false);
			if((destination == null) && (source != null)) {
				courant.getEntree(para[1], true);
				if(source.getElement() instanceof Dossier) {
					if((destination != null) && destination.getElement() instanceof Dossier) {
						Dossier s = (Dossier) source.getElement();
						Dossier d = (Dossier) destination.getElement();
						if(d.estEnfantDe(s)) {
							System.out.println("Pas possible de deplacer un dossier dans lui meme.");
						} else {
							d.getEntree(source.getNom(), true).remplacer(source.getElement());
							source.supprimer();
						}
					}
				} else {
					if(destination.getElement() instanceof Dossier) {
						Dossier d = (Dossier) destination.getElement();
						d.getEntree(source.getNom(), true).remplacer(source.getElement());
						source.supprimer();
					}
				}
			} else if((source != null) && (destination != null)) {
				if(source.getElement() instanceof Dossier) {
					if((destination != null) && destination.getElement() instanceof Dossier) {
						Dossier s = (Dossier) source.getElement();
						Dossier d = (Dossier) destination.getElement();
						if(d.estEnfantDe(s)) {
							System.out.println("Pas possible de deplacer un dossier dans lui meme.");
						} else {
							d.getEntree(source.getNom(), true).remplacer(source.getElement());
							source.supprimer();
						}
					}
				} else {
					if(destination.getElement() instanceof Dossier) {
						Dossier d = (Dossier) destination.getElement();
						d.getEntree(source.getNom(), true).remplacer(source.getElement());
						source.supprimer();
					}
				}
			}
		}
		return courant;
	}
	
	public static void aide() {
		System.out.println("mv <src> <dst>");
	}

}