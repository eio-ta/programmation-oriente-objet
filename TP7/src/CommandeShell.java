import java.util.Scanner;

public abstract class CommandeShell {
	public Dossier racine;
	public Dossier courant;
	public String[] para;
	
	public CommandeShell(Dossier racine, Dossier courant, String[] para) {
		this.racine = racine;
		this.courant = courant;
		this.para = para;
	}
	
	public abstract Dossier executer();
	
	public static void aide() {
		CommandeCat.aide();
		CommandeCd.aide();
		CommandeEd.aide();
		CommandeLs.aide();
		CommandeMkdir.aide();
		CommandeMv.aide();
		CommandeRm.aide();
	}
	
	protected static void erreurParam() {
		System.out.println("Pas un bon nombre de parametres.");
//		aide();
	}
	
	protected Entree acceder(String chemin, boolean creer) {
		Scanner sc = new Scanner(chemin);
		sc.useDelimiter("/");
		Dossier actuel = (chemin.startsWith("/") ? racine : courant);
		Entree actu = null;
		while(sc.hasNext()) {
			actu = actuel.getEntree(sc.next(), creer);
			if(actu == null) {
				System.out.println("erreur chemin");
				return null;
			}
			if(sc.hasNext()) {
				Element elem = actu.getElement();
				if(!(elem instanceof Dossier)) {
					return actu;
				} else {
					actuel = (Dossier) elem;
				}
			}
		}
		return actu;
	}
	

}
