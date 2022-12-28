
public class Dictionnaire extends Media {
	private String auteur;
	private int nbPages;
	private String langue;
	private int nbTomes;
	
	public Dictionnaire(String titre, String auteur, int nbPages, String langue, int nbTomes) {
		super(titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
		this.langue = langue;
		this.nbTomes = nbTomes;
	}
	
	public String toString() {
		return super.toString() + ", Auteur : " + this.auteur + ", Nombre de Pages : " + this.nbPages + ", Langue : " + this.langue + ", Nombre de tomes : " + this.nbTomes;
	}

}
