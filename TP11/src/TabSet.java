import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TabSet<E> implements Iterable<E>, Set<E>{
	private E[] tableau;
	
	// CONTRUCTEUR EXO 2
	@SuppressWarnings("unchecked")
	public TabSet(int n) {
		tableau = (E[]) new Object[n];
	}
	
	// CONTRUCTEUR EXO 9
	@SuppressWarnings("unchecked")
	public TabSet() {
		tableau = (E[]) new Object[10];
	}
	
	@Override
	public Iterator<E> iterator() {
		return new TabIter();
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(var element : c) {
			if(!this.add(element)) return false;
		}
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(var element : c) {
			if(!this.contains(element)) return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(var element : c) {
			if(!this.remove(element)) return false;
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean res = false;
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			E e = it.next();
			boolean contains = false;
			for( var element : c) {
				if(e != null) {
					if(e.equals(element)) contains = true;
				}
			}
			if(!contains) {
				this.remove(e);
				res = true;
			}
		}
		return res;
	}
	
	@Override
	public Object[] toArray() {
		Object[] nouveauTab = new Object[this.size()];
		int i = 0;
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			E e = it.next();
			if(e != null) {
				nouveauTab[i] = e;
				i++;
			}
		}
		return nouveauTab;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length >= tableau.length) {
			for(int i=0; i<a.length; i++) {
				a[i] = null;
			}
			int indice = 0;
			Iterator<E> it = this.iterator();
			while(it.hasNext()) {
				E e = it.next();
				if(e != null) {
					a[indice] = (T) e;
					indice++;
				}
			}
			return a;
		} else {
			Class c = a.getClass().getComponentType();
			T[] newA = (T[]) Array.newInstance(c, this.size());
			int indice = 0;
			Iterator<E> it = this.iterator();
			while(it.hasNext()) {
				E e = it.next();
				if(e != null) {
					newA[indice] = (T) e;
					indice++;
				}
			}
			return newA;
		}
	}
	
	public boolean contains(Object o) {
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			E e = it.next();
			if(e != null) {
				if(e.equals(o)) return true;
			}
		}
		return false;
	}
	
	public int size() {
		int cmp = 0;
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			E e = it.next();
			if(e != null) cmp++;
		}
		return cmp;
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public boolean add(E e) {
		if(e == null) {
			throw new NullPointerException();
		} else {
			if(this.contains(e)) return false;
			
			if(this.size() == this.tableau.length) {
				@SuppressWarnings("unchecked")
				E[] newTab = (E[]) new Object[tableau.length*2];
				Iterator<E> it = this.iterator();
				int indice = 0;
				while(it.hasNext()) {
					E element = it.next();
					newTab[indice] = element;
					indice ++;
				}
				tableau = newTab;
				this.add(e);
				return true;
//				throw new IllegalStateException();
			}
			
			Iterator<E> it = this.iterator();
			((TabSet<E>.TabIter) it).add(e);
			return true;
		}
	}
	
	public boolean remove(Object o) {
		if(!this.contains(o)) return false;
		Iterator<E> it = new TabIter();
		E tmp = it.next();
		while(tmp != o) {
			tmp = it.next();
		}
		it.remove();
		return true;
	}
	
	public void clear() {
		Iterator<E> it = new TabIter();
		while(it.hasNext()) {
			E e = it.next();
			it.remove();
		}
	}
	
	
	public class TabIter implements Iterator<E> {
		private int index = 0;
		
		public void add(E e) {
			E element = tableau[index];
			if(element == null) {
				tableau[index] = e;
				return;
			} else {
				while(this.hasNext()) {
					element = this.next();
					if(element == null) {
						tableau[index-1] = e;
						return;
					}
				}
			}
			throw new IllegalStateException();
		}
		
		public void remove() {
			if(index == 0) {
				throw new IllegalStateException();
			} else {
				tableau[index-1] = null;
			}
		}

		@Override
		public boolean hasNext() {
			return (index < tableau.length);
		}
	
		@Override
		public E next() {
			return tableau[index++];
		}
		
	}

}
