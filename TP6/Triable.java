
public interface Triable {
	//échange les éléments en position i et j
	void echange(int i, int j);
	
	//retourne vrai si l'élément de position i est plus grand que l'élément de position j
	boolean plusGrand(int i, int j);
	
	//nombre d'éléments à trier
	int taille();
	
	static void triBulles(Triable t) {
		boolean change = false;
		do {
			change = false;
			for(int i=0; i<t.taille()-1; i++) {
				if(t.plusGrand(i, i+1)) {
					t.echange(i, i+1);
					change = true;
				}
			}
		} while(change);
	}
}
