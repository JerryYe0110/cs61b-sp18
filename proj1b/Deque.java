/**
* Deque
*/
public interface Deque<T> {
	 public int size = 0;

	 public default boolean isEmpty() {return size == 0;}
	 public abstract void addFirst(T item);
	 public abstract void addLast(T item);
	 public default int size(){return size;}
	 public abstract void printDeque();
	 public abstract T removeFirst();
	 public abstract T removeLast();
	 public abstract T get(int index);
}
