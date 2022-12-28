import java.util.LinkedList;

public class Dossier extends Element implements Affichable {
	private LinkedList<Entree> liste;
	private Dossier parent;
	
	public Dossier(Dossier parent) {
		this.parent = parent;
		liste = new LinkedList<Entree>();
		liste.add(new EntreeSpeciale(this.parent, ".", this));
		if(this.parent != null) liste.add(new EntreeSpeciale(this.parent.parent, "..", this.parent));
	}

	@Override
	public String getType() {
		return "dossier";
	}
	
	public Entree getEntree(String nom, boolean creer) {
		if(creer) {
			Entree e = new Entree(this, nom, null);
			liste.add(e);
			return e;
		}
		
		for(Entree e : liste) {
			if(e.getNom().contentEquals(nom)) return e;
		}
		return null;
	}
	
	@Override
	public void afficher() {
		
		for(Entree e : liste) {
			System.out.println(e);
		}
	}
	
	public boolean estEnfantDe(Dossier o) {
		Dossier tmp = this.parent;
		while(tmp != null) {
			if(tmp.equals(o)) return true;
			tmp = tmp.parent;
		}
		return false;
	}
	
	// Fonctions non demandees
	public void remove(Entree e) {
		liste.remove(e);
	}
	
	public void setParent(Dossier p) {
		this.parent = p;
	}

}
