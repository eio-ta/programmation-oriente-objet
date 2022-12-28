public class Exercice1 {
	
	public static double hypot​(double x, double y) {
		return Math.sqrt(x*x + y*y);
	}

	public static void main(String[] args) {
		//Question 1 : Le type d'entrée de la méthode Main est un tableau de chaînes de Caractères (String[] args). C'est une procédure : elle ne renvoie aucun type spécial.
		
		//Question 2 :
		System.out.println(args.length);
		
		//Question 3 : (nom de la chaîne).length();
		
		//Question 4 : hypot calcule la racine carrée de(x^2 + y^2).
		double x = 2;
		double y = 5;
		System.out.println(hypot(x, y));
	

	}

}
