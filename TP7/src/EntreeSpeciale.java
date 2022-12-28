
public class EntreeSpeciale extends Entree {
	
	public EntreeSpeciale(Dossier p, String n, Element e) {
		super(p, n, e);
	}
	
	public void remplacer(Element e) {
		System.out.println("On ne peut pas remplacer, c'est une entree speciale.");
	}
	
	public void supprimer() {
		System.out.println("On ne peut pas modifier, c'est une entree speciale.");
	}

}