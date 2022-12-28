
public class Carre extends Rectangle implements Deformable {
	private final double cote;
	
	public Carre(int x, int y, double cote) {
		super(x,y,cote, cote);
		this.cote = cote;
	}

}
