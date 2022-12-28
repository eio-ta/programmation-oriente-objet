import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cadre extends JFrame {
	private JPanel conteneurPrincipal;
	
	public Cadre() {
		this.setSize(600,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		conteneurPrincipal = new JPanel();
		this.getContentPane().add(conteneurPrincipal);
	}
	
	class Carre extends JPanel {
		
		public Carre() {
			this.setBounds(100, 200, 50, 50);
		}
	}
}
