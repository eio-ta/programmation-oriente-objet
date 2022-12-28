
public class TriBinaire implements Triable {
	private String[] tab; //chiffre binaire
	
	public TriBinaire(String[] tab) {
		this.tab = tab;
	}
	
	public String toString() {
		String s = "[";
		for(int i=0; i<tab.length; i++) {
			s += " " + tab[i];
		}
		s += " ]";
		return s;
	}
	
	//méthode pour convertir en chiffre décimal
	public static int convertBinaryToInt(String binaryValue){
		int valueI;
	    try {
	    	valueI = Integer.parseInt(binaryValue, 2);
	    }
	    catch (NumberFormatException x){
	         System.out.println("Erreur de conversion (binaire - décimale)");
	         return 0;
	    }
	    return valueI;
	}

	@Override
	public void echange(int i, int j) {
		String tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
	}

	@Override
	public boolean plusGrand(int i, int j) {
		int elementI = convertBinaryToInt(tab[i]);
		int elementJ = convertBinaryToInt(tab[j]);
		return (elementI > elementJ);
	}

	@Override
	public int taille() {
		return tab.length;
	}
	
	public static void main(String[] args) {
//		String s = "10";
//		System.out.println(convertBinaryToInt(s));
		String[] tab = {"0101010", "10101010001", "110", "1", "11", "10"};
		TriBinaire t = new TriBinaire(tab);
		System.out.println(t);
		Triable.triBulles(t);
		System.out.println(t);
	}

}
