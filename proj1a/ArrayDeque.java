/**
* ArrayDeque
*/
public class ArrayDeque<T> {
   private T[] Arraydeque;
	private int size = 0;
	private int firstindex = 0;
	private int lastindex = 0;
	private int ArrayDequelength;
	public ArrayDeque() {
		Arraydeque = (T[])new Object[8];
		ArrayDequelength=8;
		firstindex = 7;
		lastindex = 0;
	}
	public ArrayDeque(ArrayDeque other) {
		ArrayDequelength = other.ArrayDequelength;
		Arraydeque = (T[])new Object[other.ArrayDequelength];
		System.arraycopy(Arraydeque, 0, other.Arraydeque, 0, other.ArrayDequelength-1);
		firstindex = other.firstindex;
		lastindex = other.lastindex;
	}
	public void addFirst(T item) {
	  if (firstindex  == lastindex) resize();
	  Arraydeque[firstindex] = item;
	  firstindex--;
	  if (firstindex<0) firstindex += ArrayDequelength;
	  size++;
	}
	public void addLast(T item) {
	  if (firstindex == lastindex) resize();
	  Arraydeque[lastindex] = item;
	  lastindex++;
	  if (lastindex > ArrayDequelength -1 ) lastindex -= ArrayDequelength;
	  size++;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public void printDeque() {
	   if (size == 0) {
		System.out.printf("\n");
	   return ;	
	   }
		T p = Arraydeque[firstindex+1];
		System.out.print(p.toString());
		for (int i = 1; i<size;i++ ){
			System.out.print(" "+Arraydeque[(firstindex+i+1)%ArrayDequelength].toString());
		}
		System.out.println();
	}
	public T removeFirst() {
		if (size == 0) return null;
		firstindex++;
		if (firstindex > ArrayDequelength-1) firstindex -= ArrayDequelength;
		T tem = Arraydeque[firstindex];
		Arraydeque[firstindex] = null;
		size--;
		return tem;
	}
	public T removeLast() {
		if (size == 0) return null;
		lastindex--;
		if (lastindex < 0) lastindex += ArrayDequelength;
		T tem = Arraydeque[lastindex];
		Arraydeque[lastindex] = null;
		size--;
		return tem;
	}
	public T get(int index) {
		int realindex = firstindex + 1 + index;
		if (realindex > ArrayDequelength-1) realindex -= ArrayDequelength;
		if (realindex > ArrayDequelength-1) return null;
		return Arraydeque[realindex];
	}
	private void resize() {
	  if (lastindex == firstindex) {
		  T[] newArraydeque = (T[])new Object[ArrayDequelength*2];
		  System.arraycopy(Arraydeque,0 ,newArraydeque, 0, firstindex);
		  System.arraycopy(Arraydeque,firstindex, newArraydeque, ArrayDequelength+firstindex, ArrayDequelength - firstindex);
		  Arraydeque = newArraydeque;
		  firstindex = ArrayDequelength+firstindex;
		  ArrayDequelength*=2;
	  }else{
		  T[] newArraydeque = (T[])new Object[ArrayDequelength/2];
		  if (lastindex > firstindex){
		  System.arraycopy(Arraydeque,firstindex, newArraydeque, 0, lastindex);
		  }else{
		  System.arraycopy(Arraydeque,firstindex, newArraydeque, 0, ArrayDequelength);
		  System.arraycopy(Arraydeque,0, newArraydeque, ArrayDequelength-firstindex, lastindex);
		  }
		  Arraydeque = newArraydeque;
		  lastindex = size;
		  firstindex = ArrayDequelength/2-1;
		  ArrayDequelength/=2;
	  }
}
}
