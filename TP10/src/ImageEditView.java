import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ImageEditView extends JFrame {
	private JButton cutButton;
	private JButton undoButton;
	private JButton redoButton;
	private ImagePane imagePane;
	private ImageEditModel model;
	
	public ImageEditView(ImageEditModel m) {
		this.model = m;
		this.setTitle("TP10");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar b = new JMenuBar();
		cutButton = new JButton("cut");
		undoButton = new JButton("undo");
		redoButton = new JButton("redo");
		
		cutButton.setEnabled(false);
		cutButton.addActionListener((ActionEvent e) -> {
			model.saveCut(imagePane.selection.getRectangle());
			imagePane.repaint();
			cutButton.setEnabled(false);
			undoButton.setEnabled(true);
			redoButton.setEnabled(true);
		});
		undoButton.setEnabled(false);
		undoButton.addActionListener((ActionEvent e) -> {
			if(model.undoManager.canUndo()) {
				model.undoManager.undo();
			}
			imagePane.repaint();
		});
		redoButton.setEnabled(false);
		redoButton.addActionListener((ActionEvent e) -> {
			if(model.undoManager.canRedo()) {
				model.undoManager.redo();
			}
			imagePane.repaint();
		});
		
		b.add(cutButton);
		b.add(undoButton);
		b.add(redoButton);
		
		this.setJMenuBar(b);
		
		this.imagePane = new ImagePane();
		this.setContentPane(imagePane);
	}
	
	public class ImagePane extends JPanel {
		private Selection selection = new Selection();
		
		public ImagePane() {
			this.setPreferredSize(new Dimension(model.getImage().getWidth(), model.getImage().getHeight()));
			addMouseListener(selection);
			addMouseMotionListener(selection);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(model.getImage(), 0, 0, this);
			((Graphics2D) g).draw(selection.getRectangle());
		}
		
		public class Selection extends MouseAdapter implements MouseMotionListener {
			// Point 1
			private int x1;
			private int y1;
			// Point 2
			private int x2;
			private int y2;
			
			public Rectangle getRectangle() {
				return new Rectangle(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}
			
			public void mousePressed(MouseEvent event) {
				x1 = event.getX();
				y1 = event.getY();
				cutButton.setEnabled(false);
				imagePane.repaint();
			}
			
			public void mouseDragged(MouseEvent event) {
				x2 = event.getX();
				y2 = event.getY();
				if(x1 != x2 && y1 != y2) {
					cutButton.setEnabled(true);
				}
				imagePane.repaint();
			}
			
			public void mouseMoved(MouseEvent event) {
				return;
			}
		}
	}
}
