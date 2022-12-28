
public class Exercice3 {
	
	public static String ChangerEnPhrase(String[] tab) {
		String s = "";
		for(int i=0; i<tab.length; i++) {
			s = s + tab[i] + " ";
		}
		return s;
	}
	
	public static char ChangementDesVoyelles(char[] voyelles, char[] voyellesMaj, char carac) {
		for(int i=0; i<voyelles.length-1; i++) {
			if(carac == voyelles[i]) {
				carac = voyelles[i+1];
				return carac;
			}
			if(carac == voyellesMaj[i]) {
				carac = voyellesMaj[i+1];
				return carac;
			}
		}
		if(carac == 'y') {
			carac = 'a';
			return carac;
		}
		if(carac == 'Y') {
			carac = 'A';
			return carac;
		}
		return carac;
	}
	
	public static String ChangementDesLettres(char[] voyelles, char[] voyellesMaj, String s) {
		String res = "";
		for(int i=0; i<s.length(); i++) {
			res = res + ChangementDesVoyelles(voyelles, voyellesMaj, s.charAt(i));
		}
		return res;
	}
	
	public static void main(String[] args) {
		char[] voyelles = {'a', 'e', 'i', 'o', 'u', 'y'};
		char[] voyellesMaj = {'A', 'E', 'I', 'O', 'U', 'Y'};
		String p = ChangerEnPhrase(args);
		p = ChangementDesLettres(voyelles, voyellesMaj, p);
		System.out.println(p);
	}

}
