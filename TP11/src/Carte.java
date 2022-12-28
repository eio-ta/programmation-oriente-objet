import java.util.HashMap;

public class Carte {
	private final String couleur;
	private final String valeur;
	private HashMap<Carte, Integer> scores;
	
	// CONSTRUCTEUR
	public Carte(String c, String v) {
		this.couleur = c;
		this.valeur = v;
		scores.put(this, Integer.parseInt(this.valeur));
	}

	// ACCESSEURS (GETTEURS)
	public String getCouleur() {
		return couleur;
	}

	public String getValeur() {
		return valeur;
	}
	
	public HashMap<Carte, Integer> getScores() {
		return scores;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Carte) {
			Carte c = (Carte) o;
			if(this.couleur.equals(c.couleur) && this.valeur.equals(c.valeur)) return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (2 * getValeur().hashCode() + 3 * getCouleur().hashCode());
	}

}
