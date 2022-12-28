import java.util.Scanner;
import java.util.Random;

public class Exercice4 {
	
	public static int question() {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int x = rd.nextInt(10);
		int y = rd.nextInt(10);

		int cmp = 1;
		System.out.println("Vous devez faire la multiplication de ces deux nombres : " + x + " et " + y + ".");
		System.out.print("Votre réponse : ");
		
		int rep = x*y;
		int essai = sc.nextInt();
		while(essai != rep) {
			System.out.println("Vous avez faux : réessayer.");
			cmp += 1;
			System.out.println("Nombre de essais : " + cmp);
			System.out.print("Votre réponse : ");
			essai = sc.nextInt();
		}

		System.out.println();
		System.out.println("Félicitations, vous avez réussi en " + cmp + " essai(s).");
		System.out.println();
		System.out.println();

		return cmp;
	}

	public static int evaluation(int n) {
		System.out.println("Votre évaluation va commencer. Vous avez " + n + " questions");
		int tmp = n;
		int points = 0;
		while(tmp != 0) {
			int essais = question();
			if (essais != 1) points -= essais;
			if(essais == 1) points++;
			tmp--;
		}

		int score = points;
		System.out.println("Vous avez eu " + score + " points sur " + n + " questions.");
		System.out.println("Votre évalutation est terminée.");
		return score;
	}
	
	public static void main(String[] args) {
		//question();

		Scanner sc = new Scanner(System.in);
		System.out.println("Interrogation de combien de questions ?");
		int n = sc.nextInt();
		System.out.println("Le test va commencer. Veuillez patienter.");
		System.out.println();
		System.out.println();
		System.out.println();
		evaluation(n);
		
		
		
	}

}
