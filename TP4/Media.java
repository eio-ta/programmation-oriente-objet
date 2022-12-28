
public class Media {
	private final String titre;
	private static int nbNumero = 0;
	private final int numero;
	
	public Media(String titre) {
		this.titre = titre;
		this.numero = nbNumero;
		nbNumero++;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String toString() {
		return "Numero : " + this.numero + ", Titre : " + this.titre;
	}
	
	public boolean plusPetit(Media doc) {
		int ordreDoc = doc.ordreMedia();
		int ordreCourant = this.ordreMedia();
		
		if(ordreCourant != ordreDoc) {
			if(ordreCourant < ordreDoc) {
				return true;
			} else {
				return false;
			}
		} else {
			return this.numero < doc.getNumero();
		}
	}
	
	public int ordreMedia() {
		if(this instanceof Livre) return 1;
		if(this instanceof Dictionnaire) return 2;
		if(this instanceof DictionnaireBilingue) return 3;
		return 4;
	}

}
