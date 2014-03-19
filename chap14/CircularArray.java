package chap14;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
	 T[] items;
	 int head = 0;

	public CircularArray(int n){
		items = (T[]) new Object[n];
	}

	public  int convert(int n){
		while(n < 0){
			n += items.length;
		}
		return (n + head)%(items.length);
	}

	public  void rotate(int n){
		head = convert(head);
	}

	public T get(int n){
		return items[convert(n)];
	}

	public void set(int n, T t){
		items[convert(n)] = t;
	}

	public Iterator<T> iterator(){
		return new CircularArrayIterator<T>(this);
	}

	private class CircularArrayIterator<T> implements Iterator<T>{
		T[] _items;
		int _current = -1;

		public CircularArrayIterator(CircularArray<T> arr){
			_items = arr.items;
		}

		@Override
			public boolean hasNext(){
				if(_current < _items.length - 1){
					return true;
				}
				return false;
			}

		@Override
			public T next(){
				_current ++ ;
				T item = (T) _items[convert(_current)];
				return item;
			}

		@Override
			public void remove(){
				throw new UnsupportedOperationException("remove exception");
			}
	}

}

