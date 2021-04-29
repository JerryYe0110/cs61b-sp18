/**
* LinkedListDeque
*/
public class LinkedListDeque<T> {
   private class LinkedNode<T>{
		public T item;
		public LinkedNode<T> next;
		public LinkedNode<T> pre;
		public LinkedNode(T item, LinkedNode<T> next, LinkedNode<T> pre) {
		  this.item = item;
		  this.next = next;
		  this.pre = pre;
		}
		public LinkedNode(LinkedNode<T> Node) {
		  this.item = Node.item;
		  this.next = Node.next;
		  this.pre = Node.pre;
		}
   }


   private T item;
	private LinkedNode<T> sentinel;
   private int size = 0;


   public LinkedListDeque(){
	sentinel = new LinkedNode<>(item, null, null);
	sentinel.next = sentinel;
	sentinel.pre = sentinel.next;
   }
	public LinkedListDeque(LinkedListDeque<T> other){
	  sentinel = new LinkedNode<>(item, null, null);
	  for (int i = 0; i < other.size(); i++) {
		size++;
	  	addLast((T)other.get(i));
	  }
	}
	public void addFirst(T item) {
		sentinel.next = new LinkedNode<>(item, sentinel.next, sentinel);
		sentinel.next.next.pre = sentinel.next;
		size++;
	}
	public void addLast(T item) {
		sentinel.pre = new LinkedNode<>(item, null, sentinel.pre);
		sentinel.pre.pre.next = sentinel.pre;
		size++;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	public void printDeque() {
	   if (size == 0) {
		System.out.printf("\n");
	   return ;	
	   }
		LinkedNode<T> p = sentinel.next;
		System.out.print(p.item.toString());
		while (p.next != null) {
			p = p.next;
			System.out.print(" "+p.item.toString());
		}
		System.out.println();
	}
	public T removeFirst() {
		if (size == 0) return null;
		T first = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		size--;
		return first;
	}
	public T removeLast() {
		if (size == 0) return null;
		T last = sentinel.pre.item;
		sentinel.pre = sentinel.pre.pre;
		size--;
		return last;
	}
	public T get(int index) {
		if (size < index+1) return null;
		LinkedNode<T> p = sentinel.next;
		while (p.next != null && index > 0) {
			p = p.next;
			index--;
		}
		return p.item;
	}
	public T getRecursive(int index) {
		if (size < index - 1) return null;
		if (index == 0) return sentinel.next.item;
		return get(index-1);
	}

}
