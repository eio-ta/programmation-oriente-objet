import java.awt.Color;

public class Controleur {
	Modele m;
	Vue view;
	
	public void sliderMoved() {
		int r = view.r.getValue();
		int b = view.b.getValue();
		int v = view.v.getValue();
		m.couleur = new Color((255*r/100), (255*v)/100, (255*b)/100);
		view.miseAJour();
	}
	
	public void garderEnMemoire() {
		int r = view.r.getValue();
		int b = view.b.getValue();
		int v = view.v.getValue();
		m.couleur = new Color((255*r/100), (255*v)/100, (255*b)/100);
		view.miseAJour();
	}
	
	public void senRappeler() {
		int r = view.rougeMemo;
		int b = view.bleuMemo;
		int v = view.vertMemo;
		m.couleur = new Color((255*r/100), (255*v)/100, (255*b)/100);
		view.miseAJour();
	}
	
	public void couleurComplementaire() {
		int r = view.r.getValue();
		int b = view.b.getValue();
		int v = view.v.getValue();
		m.couleur = new Color((255*r/100), (255*v)/100, (255*b)/100);
		view.miseAJour();
	}
}
