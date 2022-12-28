public class Combat {
	

	public static void main(String[] args) {
		Personnage a = new Personnage("Robot 1", new Informations(5, 10, 10), new Informations(5, 10, 10));
        Personnage b = new Personnage("Robot 2", new Informations(5, 5, 5), new Informations(5, 5, 5));

        a.lutte(b);
	}

}
