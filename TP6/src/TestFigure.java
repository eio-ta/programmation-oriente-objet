
public class TestFigure {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(0, 0, 10, 20);
		r.affiche();
		Figure r2 = r.deformation(0.5, 1.5);
		r2.affiche();
		System.out.println(r.surface());
		System.out.println();
		
		Ellipse e = new Ellipse(0, 0, 10, 20);
		e.affiche();
		Figure e2 = e.deformation(0.5, 1.5);
		e2.affiche();
		System.out.println(e.surface());
		System.out.println();
		
		Triangle t = new Triangle(0, 10, 20);
		t.affiche();
		Figure t2 = t.deformation(0.5, 1.5);
		t2.affiche();
		System.out.println(t.surface());
		System.out.println();
		
		
	}

}
