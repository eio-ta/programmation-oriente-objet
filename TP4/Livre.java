
public class Livre extends Media{
	private String auteur;
	private int nbPages;
	
	public Livre(String titre, String auteur, int nbPages) {
		super(titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}
	
	public String toString() {
		return super.toString() + ", Auteur : " + this.auteur + ", Nombre de Pages : " + this.nbPages;
	}
	

}
