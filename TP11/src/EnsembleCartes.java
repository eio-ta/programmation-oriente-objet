import java.util.Iterator;

public class EnsembleCartes extends TabSet<Carte> {
	
	// Score total
	public int score() {
		int scoreTotal = 0;
		Iterator<Carte> it = this.iterator();
		while(it.hasNext()) {
			Carte c = it.next();
			scoreTotal += c.getScores().get(c);
		}
		return scoreTotal;
	}

}
