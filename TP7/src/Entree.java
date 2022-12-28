
public class Entree {
	private Element element;
	private String nom;
	private Dossier parent;
	
	public Entree(Dossier p, String n, Element e) {
		this.element = e;
		this.nom = n;
		this.parent = p;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public String toString() {
		return this.nom + " (" + ((element == null) ? "entree vide" : element.getType()) + ")";
	}
	
	public void supprimer() {
		parent.remove(this);
	}
	
	public void remplacer(Element e) {
		if(e instanceof Dossier) {
			Dossier d = (Dossier) e;
			d.setParent(this.parent);
			e = d;
		}
		element = e;
	}
	
	

}
