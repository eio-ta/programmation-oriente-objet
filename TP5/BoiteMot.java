
public class BoiteMot extends Boite {
	private String mot;
	
	public BoiteMot(String mot) {
		this.mot = mot;
	}
	
	public int length() {
		return this.mot.length();
	}
	
	public String toString() {
		return this.mot;
	}
	

}
