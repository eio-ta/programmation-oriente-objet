import java.io.InputStream;
import java.util.Scanner;

public class Shell {
	public Dossier racine;
	public Dossier courant;
	
	public Shell(Dossier r) {
		this.racine = r;
		this.courant = r;
	}
	
	public void interagir(InputStream in) {
		Scanner scanLigne = new Scanner(in);
		scanLigne.useDelimiter("\n");
		while(scanLigne.hasNext()) {
			String ligne = scanLigne.next();
			Scanner sc = new Scanner(ligne);
			if(ligne.length() != 0) {
				String s = sc.next();
				switch(s) {
					case "quit" :
						System.exit(0);
					case "help" :
						CommandeShell.aide();
						System.out.println("quit");
						System.out.println("help");
						break;
					case "cat" :
						CommandeCat c = new CommandeCat(racine, courant, getParam(sc));
						c.executer();
						break;
					case "cd" :
						CommandeCd c1 = new CommandeCd(racine, courant,  getParam(sc));
						Dossier newCourant = c1.executer();
						this.courant = newCourant;
						break;
					case "ed" :
						boolean echo = (in != System.in);
						CommandeEd c2 = new CommandeEd(racine, courant,  getParam(sc), scanLigne, echo);
						c2.executer();
						break;
					case "ls" :
						CommandeLs c3 = new CommandeLs(racine, courant,  getParam(sc));
						c3.executer();
						break;
					case "mkdir" :
						CommandeMkdir c4 = new CommandeMkdir(racine, courant,  getParam(sc));
						c4.executer();
						break;
					case "mv" :
						CommandeMv c5 = new CommandeMv(racine, courant,  getParam(sc));
						c5.executer();
						break;
					case "Rm" :
						CommandeRm c6 = new CommandeRm(racine, courant,  getParam(sc));
						c6.executer();
						break;
					default:
				}
			}
		}
	}
	
	// Fonction pas demandee
	public static String[] getParam(Scanner s) {
		String str = "";
		while(s.hasNext()) {
			str += s.next() + " ";
		}
		if(str.length() == 0) return new String[0];
		String[] param = str.split(" ");
		return param;
	}
	
}
