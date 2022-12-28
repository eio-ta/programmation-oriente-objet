
public abstract class Figure {
	//coordonees du centre approximatif de la figure
	private int posX;
	private int posY;
	
	public Figure(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public abstract void affiche();
	
	public double estDistantDe(Figure fig) {
		double distanceX = (this.posX-fig.posX)*(this.posX-fig.posX);
		double distanceY = (this.posY-fig.posY)*(this.posY-fig.posY);
		return Math.sqrt(distanceX+distanceY);
	}
	
	public abstract double surface();
	
	public void deplacement(int x, int y) {
		this.posX += x;
		this.posY += y;
	}
	

}
