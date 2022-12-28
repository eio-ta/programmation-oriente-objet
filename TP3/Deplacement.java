
public class Deplacement {
	private int x0;
	private int y0;
	private int x1;
	private int y1;
	
	public Deplacement(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	public char typeDeplacement() {
		int dx = +Math.abs(x1-x0);
		int dy = +Math.abs(y1-y0);
		
		if(dx == 0) {
			return 'v';
		}
		
		if(dy == 0) {
			return 'h';
		}
		
		if(dy == dx) {
			return 'd';
		}
		
		if(dx == 1 && dy == 2) {
			return 'c';
		}
		
		return 'x';
	}
	
	public int dist() {
		if(this.typeDeplacement() == 'v') {
			return +Math.abs(y1-y0);
		}
		
		if(this.typeDeplacement() == 'h' || this.typeDeplacement() == 'd') {
			return +Math.abs(x1-x0);
		}
		
		return -1;
	}
	
	public int getX0() {
		return this.x0;
	}
	
	public int getX1() {
		return this.x1;
	}
	
	public int getY0() {
		return this.y0;
	}
	
	public int getY1() {
		return this.y1;
	}
}
