/**
* LinkedListDeque
*/
public class LinkedListDeque<T> implements Deque<T>{
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
	public LinkedListDeque(LinkedListDeque other){
	  sentinel = new LinkedNode<>(item, null, null);
	  for (int i = 0; i < other.size(); i++) {
		size++;
	  	addLast((T)other.get(i));
	  }
	}
	@Override
	public void addFirst(T item) {
		sentinel.next = new LinkedNode<>(item, sentinel.next, sentinel);
		sentinel.next.next.pre = sentinel.next;
		size++;
	}
	@Override
	public void addLast(T item) {
		sentinel.pre = new LinkedNode<>(item, sentinel, sentinel.pre);
		sentinel.pre.pre.next = sentinel.pre;
		size++;
	}
	@Override
	public void printDeque() {
	   if (size == 0) {
		System.out.printf("\n");
	   return ;	
	   }
		LinkedNode<T> p = sentinel.next;
		System.out.print(p.item.toString());
		for (int i = 1; i<size;i++ ){
			p = p.next;
			System.out.print(" "+p.item.toString());
		}
		System.out.println();
	}
	@Override
	public T removeFirst() {
		if (size == 0) return null;
		T first = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.pre = sentinel;
		size--;
		return first;
	}
	@Override
	public T removeLast() {
		if (size == 0) return null;
		T last = sentinel.pre.item;
		sentinel.pre = sentinel.pre.pre;
		sentinel.pre.next = sentinel;
		size--;
		return last;
	}
	@Override
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
		return getRecursive(sentinel.next, index).item;
	}
	private LinkedNode<T> getRecursive(LinkedNode<T> item, int index) {
		if (index==0) return item;
		return getRecursive(item.next, index-1);
	}

}
