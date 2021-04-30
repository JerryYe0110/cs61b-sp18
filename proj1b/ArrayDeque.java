/**
* ArrayDeque
*/
public class ArrayDeque<T> implements Deque<T>{
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
	@Override
	public void addFirst(T item) {
	  if (firstindex  == lastindex) resize();
	  Arraydeque[firstindex] = item;
	  firstindex--;
	  if (firstindex<0) firstindex += ArrayDequelength;
	  size++;
	}
	@Override
	public void addLast(T item) {
	  if (firstindex == lastindex) resize();
	  Arraydeque[lastindex] = item;
	  lastindex++;
	  if (lastindex > ArrayDequelength -1 ) lastindex -= ArrayDequelength;
	  size++;
	}
	@Override
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
	@Override
	public T removeFirst() {
		if (size == 0) return null;
		firstindex++;
		if (firstindex > ArrayDequelength-1) firstindex -= ArrayDequelength;
		T tem = Arraydeque[firstindex];
		Arraydeque[firstindex] = null;
		size--;
		if (4 * size < ArrayDequelength && ArrayDequelength > 8) resize();
		return tem;
	}
	@Override
	public T removeLast() {
		if (size == 0) return null;
		lastindex--;
		if (lastindex < 0) lastindex += ArrayDequelength;
		T tem = Arraydeque[lastindex];
		Arraydeque[lastindex] = null;
		size--;
		if (4 * size < ArrayDequelength && ArrayDequelength > 8) resize();
		return tem;
	}
	@Override
	public T get(int index) {
		int realindex = firstindex + 1 + index;
		if (realindex > ArrayDequelength-1) realindex -= ArrayDequelength;
		if (realindex > ArrayDequelength-1) return null;
		return Arraydeque[realindex];
	}
	private void resize() {
	  if (lastindex == firstindex) {
		  T[] newArraydeque = (T[])new Object[ArrayDequelength*2];
		  System.arraycopy(Arraydeque,0 ,newArraydeque, 0, lastindex);
		  System.arraycopy(Arraydeque,firstindex, newArraydeque, ArrayDequelength+firstindex, ArrayDequelength - firstindex);
		  Arraydeque = newArraydeque;
		  firstindex += ArrayDequelength;
		  ArrayDequelength*=2;
	  }else{
		  T[] newArraydeque = (T[])new Object[ArrayDequelength/2];
	  if (lastindex > firstindex){
		  System.arraycopy(Arraydeque,firstindex, newArraydeque, 0, lastindex-firstindex);
		  lastindex = lastindex - firstindex;
		  firstindex = 0;
		  }else{
		  System.arraycopy(Arraydeque,0 ,newArraydeque, 0, lastindex);
		  System.arraycopy(Arraydeque,firstindex, newArraydeque, firstindex - ArrayDequelength/2, ArrayDequelength - firstindex);
		  firstindex -= ArrayDequelength/2;
		  }
		  Arraydeque = newArraydeque;
		  ArrayDequelength/=2;
	  }
}
}
