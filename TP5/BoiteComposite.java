import java.util.LinkedList;

public class BoiteComposite {
	private LinkedList<Boite> suite = new LinkedList<Boite>();
	
	public int length() {
		int cmp = 0;
		int indice = 0;
		while(indice != suite.size()) {
			cmp += suite.get(indice).length();
			indice++;
		}
		return cmp;
	}
	
	public String toString() {
		String s = "";
		int indice = 0;
		while(indice != suite.size()) {
			s += suite.get(indice).toString();
			indice++;
		}
		return s;
	}
	
	public String toString(int n) {		
		String s = "";
		int nbBoiteEtirable = 0;
		int dernierIndice = 0;
		for(int i=0; i<suite.size(); i++) {
			if(suite.get(i).isEtirable()) {
				nbBoiteEtirable++;
				dernierIndice = i;
			}
		}
		
		int espaceNecessaire = n/nbBoiteEtirable;
		int espaceDerniereBoite = n%nbBoiteEtirable+2;
		
		for(int i=0; i<suite.size(); i++) {
			if(suite.get(i).isEtirable() && i != dernierIndice) {
				s+= suite.get(i).toString(espaceNecessaire);
			}
			else if(suite.get(i).isEtirable() && i == dernierIndice) {
				s+= suite.get(i).toString(espaceDerniereBoite);
			} else {
				s+= suite.get(i).toString();
			}
		}
		return s;
	}
	
	public boolean isEmpty() {
		return suite.isEmpty();
	}
	
	public void addBoite(Boite b) {
		suite.add(b);
	}
	
	public Boite get(int indice) {
		return suite.get(indice);
	}
	
	public int size() {
		return suite.size();
	}
	
	public boolean isEtirable() {
		for(int i=0; i<suite.size(); i++) {
			if(suite.get(i).isEtirable()) {
				return true;
			}
		}
		return false;
	}
}
