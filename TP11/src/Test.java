import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
	
	// FONCTIONS AJOUTEES POUR FACILITER LES TESTS
	
	/**
	 * Cette fonction ajoute des elements au parametre.
	 * @param TabSet<Integer> tab
	 */
	
	public static void remplirTabSet(TabSet<Integer> tab) {
		tab.add(0);
		tab.add(1);
//		tab.add(null);
		// Exception in thread "main" java.lang.NullPointerException
		tab.add(2);
		tab.add(3);
		tab.add(1);
		tab.add(4);
		tab.add(5);
		tab.add(6);
		tab.add(7);
		tab.add(6);
		tab.add(8);
		// Pour tester les fonctions de l'exo 9, enlevez les deux lignes suivantes
//		tab.add(9);
//		tab.add(10);
		// Exception in thread "main" java.lang.IllegalStateException
	}
	
	/**
	 * Cette fonction affiche les elements du parametre.
	 * @param TabSet<Integer> tab
	 */
	
	public static <E> void afficherTabSet(TabSet<E> tab) {
		Iterator<E> it = (Iterator<E>) tab.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Cette fonction retourne une Collection avec les donnees donnees en parametres
	 * @param int[] tableau
	 * @return Collection<Integer>
	 */
	
	public static Collection<Integer> avoirCollection(int[] tabEntier) {
		Collection<Integer> c = new ArrayList<Integer>();
		for(int n : tabEntier) {
			c.add(n);
		}
		return c;
	}
	
	/**
	 * Cette fonction affiche le contenu d'un tableau
	 * @param int[] tableau
	 */
	
	public static void afficheTableau(Object[] nouveauTab) {
		for(Object n : nouveauTab) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	// FONCTION PRINCIPALE (MAIN)
	
	public static <E> void main(String[] args) {
		// TEST EXO 1
		String[] tabString = {"test0", "test1", "test2", "test3"};
		TestIter<String> testIter = new TestIter<String>(tabString);
		while(testIter.hasNext()) {
			System.out.print(testIter.next() + " ");
		}
		
		System.out.println("\n");
		
		// TEST EXO 2 A 6
		TabSet<Integer> tab = new TabSet<Integer>(10);
		remplirTabSet(tab);
		afficherTabSet(tab); // expected : 0 1 2 3 4 5 6 7 8 null
		System.out.println(tab.contains(20)); // expected : false
		System.out.println(tab.contains(5)); // expected : true
		System.out.println(tab.size()); // expected : 9
		System.out.println(tab.isEmpty()); // expected : false
		tab.remove(5);
		tab.remove(2);
		afficherTabSet(tab); // expected : 0 1 null 3 4 null 6 7 8 null
		tab.clear();
		afficherTabSet(tab); // expected : null null null null null null null null null null
		remplirTabSet(tab);
		afficherTabSet(tab); // expected : 0 1 2 3 4 5 6 7 8 null
		int[] t1 = {0, 2, 8};
		int[] t2 = {18, 3, 9};
		int[] t3 = {20, 18, 13, 59};
		Collection<Integer> c1 = avoirCollection(t1);
		Collection<Integer> c2 = avoirCollection(t2);
		Collection<Integer> c3 = avoirCollection(t3);
		System.out.println(tab.containsAll(c1)); // expected : true
		System.out.println(tab.containsAll(c2)); // expected : false
		tab.remove(4);
		tab.remove(7);
		tab.remove(1);
		System.out.println(tab.addAll(c3)); // expected : true
		afficherTabSet(tab); // expected : 0 20 2 3 18 5 6 13 8 59
		System.out.println(tab.removeAll(c1)); // expected : true
		afficherTabSet(tab); // expected : null 20 null 3 18 5 6 13 null 59
		System.out.println(tab.retainAll(c2));
		afficherTabSet(tab); // expected : null null 3 18 null null null null null null
		
		// TEST EXO 8
		Object[] nouveauTab = tab.toArray();
		afficheTableau(nouveauTab); // expected : 3 18
	}

}
