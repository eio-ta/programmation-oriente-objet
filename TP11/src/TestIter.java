import java.util.Iterator;

public class TestIter<E> implements Iterator<E> {
	private E[] tableau;
	private int index = 0;
	
	public TestIter(E[] tableau) {
		this.tableau = tableau;
	}

	@Override
	public boolean hasNext() {
		if(index < tableau.length) {
			if(tableau[index] == null) return false;
		}
		return (index <= tableau.length-1);
		
	}

	@Override
	public E next() {
		return tableau[index++];
	}
	
}
