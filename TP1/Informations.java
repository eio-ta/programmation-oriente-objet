public class Informations {
	private int a;
	private int f;
	private int v;


	public Informations(int v, int f, int a) {
		this.a = a;
		this.v = v;
		this.f = f;
	}

	//Accesseurs et modifieurs//
	public int getAgility() {
		return this.a;
	}

	public void setAgility(int a) {
		this.a = a;
	}

	public int getVitalite() {
		return this.v;
	}

	public void setVitalite(int v) {
		this.v = v;
	}

	public int getForce() {
		return this.f;
	}

	public void setForce(int f) {
		this.f = f;
	}

	//Fonctions & Méthodes//
	public String toString() {
   		return "(Agilité : " + this.a + ", Vitalité : " + this.v + " et Force :" + this.f + ")";
	}

}
