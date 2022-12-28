public class Exercice2 {
	
	public static void affiche(int[] t) {
		for(int i=0; i<t.length; i++) {
			System.out.print(t[i] + " ");
		}
	}
	
	public static int[] multiplication(int[] t1, int[] t2) {
		int n1 = t1.length;
		int n2 = t2.length;
		if(n1 >= n2) {
			int[] t3 = new int[n1];
			for(int i=0; i<n2; i++) {
				t3[i] = t1[i]*t2[i];
			}
			for(int i=n2; i<n1; i++) {
				t3[i] = t1[i];
			}
			return t3;
		} else {
			int[] t3 = new int[n2];
			for(int i=0; i<n1; i++) {
				t3[i] = t1[i]*t2[i];
			}
			for(int i=n2; i<n1; i++) {
				t3[i] = t2[i];
			}
			return t3;
		}
	}
	
	
	public static int[] split(int[] t) {
		String s = "";
		for(int i=0; i<t.length; i++) {
			s = s + String.valueOf(t[i]);
		}
		int[] t2 = new int[s.length()];
	
		for(int i=0; i<t2.length; i++) {
			int number = Character.getNumericValue(s.charAt(i));
			t2[i] = number;
		}
		
		affiche(t2);
		System.out.println();
		return t2;
	}
	
	
	public static void main(String[] args) {
		int[] t1 = {1, 3, 6, 7};
		int[] t2 = {2, 4, 6};
		int[] t3 = multiplication(t1, t2);
		affiche(t3);
		System.out.println();
		split(t3);
		
		
		


	}

}
