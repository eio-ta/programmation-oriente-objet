
public class Dictionnaire implements Triable {
	private String[] tab;
	
	public Dictionnaire(String[] tab) {
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

	@Override
	public void echange(int i, int j) {
		String tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
	}

	@Override
	public boolean plusGrand(int i, int j) {
		String elementI = tab[i];
		String elementJ = tab[j];
		return tab[i].compareTo(tab[j]) > 0;
	}

	@Override
	public int taille() {
		return tab.length;
	}
	
	public static void main(String[] args) {
		String[] tab = {"un", "grand", "mechant", "loup", "est", "venu", "et", "a", "devore", "les", "enfants"};
		Dictionnaire t = new Dictionnaire(tab);
		System.out.println(t);
		Triable.triBulles(t);
		System.out.println(t);
	}
	

}
