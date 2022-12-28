import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;

public class ImageEditModel {
	private BufferedImage image;
	UndoManager undoManager = new UndoManager();
	
	public ImageEditModel(String chemin) {
		try {
			this.image = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void fillzone(Rectangle z, int[][] pixels) {
		for (int y=0; y < image.getHeight(); y++) {
            for (int x=0; x < image.getWidth(); x++) {
                if (z.contains(x, y)) {
                    image.setRGB(x, y, pixels[y - (int) z.getMinY()][x - (int) z.getMinX()]);
                }
            }
        }
	}
	
	public void clearzone(Rectangle z) {
		for (int y=0; y < image.getHeight(); y++) {
            for (int x=0; x < image.getWidth(); x++) {
                if (z.contains(x, y)) {
                    image.setRGB(x, y, 0);
                }
            }
        }
	}
	
	public void saveCut(Rectangle z) {
		BufferedImage sousImage = image.getSubimage((int) z.getMinX(), (int) z.getMinY(), (int) z.getWidth(), (int) z.getHeight());
		Coupe c = new Coupe((int) z.getMinX(), (int) z.getMinY(), (int) z.getWidth(), (int) z.getHeight(), sousImage);
		c.doit();
		CutEdit cut = new CutEdit(c);
		cut.addEdit(undoManager);
	}
	
	public class Coupe {
		private Rectangle z;
		private int[][] pixels;
		
		public Coupe(int x1, int y1, int width, int height, BufferedImage image) {
			z = new Rectangle(x1, y1, width, height);
            pixels = new int[height][width];
             for (int y=0; y < height; y++) {
                for (int x=0; x < width; x++) {
                    pixels[y][x] = image.getRGB(x, y);
                }
            }
		}
		
		public void doit() {
			clearzone(z);
		}
		
		public void undo() {
			fillzone(z, pixels);
		}
	}
	
	public class CutEdit extends AbstractUndoableEdit {
		private Coupe c;
		
		public CutEdit(Coupe c) {
			this.c = c;
		}
		
		public void undo() {
			super.undo();
			c.undo();
		}
		
		public void redo() {
			super.redo();
			c.doit();
		}
	}
	

}
