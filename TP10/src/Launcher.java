import java.awt.EventQueue;
import java.io.IOException;

/**
 * @author elody
 * Les boutons UNDO et REDO ne fonctionnent pas.
 * Il y a un probleme sur les fonctions canUndo() et canRedo().
 * Ils sont toujours à false, peu importe ce que je fais...
 */

public class Launcher {

	public static void main(String[] args) throws IOException {
		ImageEditModel imageModele = new ImageEditModel("image.png");
		EventQueue.invokeLater(() -> {
			ImageEditView imageView = new ImageEditView(imageModele);
			imageView.pack();
			imageView.setVisible(true);
		});
	}
	
}
