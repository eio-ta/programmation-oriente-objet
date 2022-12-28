
public class TitreCommenceparS extends Predicat {
	
	public boolean estVrai(Media m) {
		return (m.getTitre().charAt(0) == 'S' || m.getTitre().charAt(0) == 's');
	}

}
