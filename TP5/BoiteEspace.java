import java.util.Arrays;

public class BoiteEspace extends BoiteEtirable {
	
	public int length() {
		return 1;
	}
	
	public String toString() {
		return " ";
	}
	
	public String toString(int n) {
		String s = " ";
		for(int i=0; i<n; i++) {
			s+= " ";
		}
		return s;
	}
	
	public boolean isEtirable() {
		return true;
	}

}
