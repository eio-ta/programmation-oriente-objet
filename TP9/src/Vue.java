import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {
	JPanel panneauColore = new JPanel();
	JLabel etiqCouleur = new JLabel();
	JPanel panneauChoix = new JPanel();
	
	// JSlider
	JSlider r = new JSlider(0, 100, 0);
	JSlider v = new JSlider(0, 100, 100);
	JSlider b = new JSlider(0, 100, 0);
	
	// Bouton
	JButton memo = new JButton("Mémoriser");
	JButton rappel = new JButton("S'en rappeler");
	JButton complementaire = new JButton("Complémentaire");
	
	// Attributs en plus
	Modele modele;
	Controleur controleur;
	
	// Memoire
	int rougeMemo = 0;
	int bleuMemo = 0;
	int vertMemo = 0;
	
	public Vue() {
		this.setTitle("Palette");
		this.setAlwaysOnTop(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color c = new Color(0, 255, 0);
		this.panneauColore.setBackground(c);
		this.getContentPane().add(panneauColore);
		etiqCouleur.setText("#" + Integer.toHexString(c.getRGB()).substring(2));
		this.panneauColore.add(etiqCouleur);
		this.panneauColore.setLayout(new BorderLayout());
		this.panneauColore.add(etiqCouleur, BorderLayout.CENTER);
		this.etiqCouleur.setHorizontalAlignment(0);
		this.getContentPane().setLayout(new GridLayout());
		this.getContentPane().add(panneauChoix);
		this.getContentPane().add(panneauColore);
		this.panneauChoix.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		this.panneauChoix.add(p1);
		p1.setLayout(new GridLayout(3,1));
		
	    r.setPaintTicks(true);
	    r.setPaintLabels(true);
	    r.setMinorTickSpacing(5);
	    r.setMajorTickSpacing(25);
	    r.addChangeListener ((event) -> {
	    	controleur.sliderMoved();
	    	}
	    );
	    
	    v.setPaintTicks(true);
	    v.setPaintLabels(true);
	    v.setMinorTickSpacing(5);
	    v.setMajorTickSpacing(25);
	    v.addChangeListener ((event) -> {
	    	controleur.sliderMoved();
	    	}
	    );
	    
	    b.setPaintTicks(true);
	    b.setPaintLabels(true);
	    b.setMinorTickSpacing(5);
	    b.setMajorTickSpacing(25);
	    b.addChangeListener ((event) -> {
	    	controleur.sliderMoved();
	    	}
	    );
	    
	    p1.add("Rouge", r);
		p1.add("Vert", v);
		p1.add("Bleu", b);
	    
		JPanel p2 = new JPanel();
		this.panneauChoix.add(p2, BorderLayout.SOUTH);
		p2.setLayout(new GridLayout(1,3));
		p2.add(memo);
		memo.addActionListener ((event) -> {
			this.rougeMemo = r.getValue();
			this.bleuMemo = b.getValue();
			this.vertMemo = v.getValue();
			System.out.println(rougeMemo + " " + bleuMemo + " " + vertMemo);
		   	controleur.garderEnMemoire();
		   	}
		);
		p2.add(rappel);
		rappel.addActionListener ((event) -> {
			r.setValue(rougeMemo);
			b.setValue(bleuMemo);
			v.setValue(vertMemo);
			controleur.senRappeler();
		   	}
		);
		p2.add(complementaire);
		complementaire.addActionListener ((event) -> {
			r.setValue(100-r.getValue());
			b.setValue(100-b.getValue());
			v.setValue(100-v.getValue());
			controleur.couleurComplementaire();
		   	}
		);
		
	}
	
	public void miseAJour() {
		Color c = modele.couleur;
		this.panneauColore.setBackground(c);
		etiqCouleur.setText(("#" + Integer.toHexString(c.getRGB()).substring(2)));
	}

}
