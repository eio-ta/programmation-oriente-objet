
public class TabEntiersTriable implements Triable {
	private int[] tab;
	
	public TabEntiersTriable(int[] tab) {
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
		int tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
	}

	@Override
	public boolean plusGrand(int i, int j) {
		return (tab[i]>tab[j]);
	}

	@Override
	public int taille() {
		return tab.length;
	}
	
	public static void main(String[] args) {
		int[] tab = {4, 6, 2, 10, 89, 215, 1, 3, 0, 7};
		TabEntiersTriable t = new TabEntiersTriable(tab);
		System.out.println(t);
		Triable.triBulles(t);
		System.out.println(t);
	}

}
