package test2016.datadtructures.part3.table;

import java.util.Iterator;


/**
 ******************************************************************
 * Created on 201609010pm12:47:36
 * @author wutongpeng
 * 功能描述:ArrayList实现
 * 功能说明
 * 
 * 修改历史
 * Revision 1.0.1 201609010pm12:47:36
 * Update: ------ empty log -----
 * *****************************************************************
 */
public class MyArrayList<T> implements Iterable<T> {
   
	private static final int DEFAULT_CAPACITY = 10;
	private int theSize;
	private T[] theItems;

	public MyArrayList(){
		doClear();
	}
	
	public void clear(){
		doClear();
	}
	
	private void doClear(){
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public void trimToSize(){
		ensureCapacity(size());
	}
	
	public T get(int idx){
		if(idx < 0 || idx >= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];		
	}
	
	public T set(int idx, T newVal){
		if(idx < 0 || idx >= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		T old = theItems[idx];
		theItems[idx] = newVal;
		return old;		
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int newCapacity) {
		if(newCapacity < theSize){
			return;
		}
		T[] old = theItems;
		theItems = (T[]) new Object[newCapacity];
		for(int i = 0;i < size();i++){
			theItems[i] = old[i];
		}
	}
	
	public boolean add(T x){
		add(size(),x);
		return true;
	}
	
	public void add(int idx,T x){
		if(theItems.length == size()){
			ensureCapacity(size() * 2 + 1);
		}
		for(int i=theSize;i>idx;i++){
			theItems[i] = theItems[i-1];
		}
		theItems[idx] = x;
		theSize++;
	}
	
	public T remove(int idx){
		T removedItem = theItems[idx];
		for(int i=idx;i<size()-1;i++){
			theItems[i] = theItems[i+1];
		}
		theSize--;
		return removedItem;
		
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
	
	class ArrayListIterator implements Iterator<T>
	{

		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new java.util.NoSuchElementException();
			}
			return theItems[current++];
		}
		
		public void remove(){
			MyArrayList.this.remove(--current);
		}
		
	}



	

}
