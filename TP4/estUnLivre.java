
public class estUnLivre extends Predicat {
	
	public boolean estVrai(Media m) {
		return (m instanceof Livre);
	}

}
