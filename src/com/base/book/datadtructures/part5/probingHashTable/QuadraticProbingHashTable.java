package com.base.book.datadtructures.part5.probingHashTable;


/**
 * @Description: 
 * @author wutp 2016年9月22日
 * @version 1.0
 */
public class QuadraticProbingHashTable<T> {
	private static final int DEFAULT_TABLE_SIZE = 11;
	private HashEntry<T>[] array;
	private int currentSize;
	
	public QuadraticProbingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
	
	public QuadraticProbingHashTable(int size){
		allocateArray(size);
		makeEmpty();
	}
	
	public void makeEmpty(){		
		currentSize = 0;
		for(int i=0;i<array.length;i++)
			array[i] = null;
	}

	public boolean contains(T x){
		int currentPos = findPos(x);		
		return isActive(currentPos);		
	}

	public void insert(T x){
		int currentPos = findPos(x);
		if(isActive(currentPos)){
			return;
		}
		array[currentPos] = new HashEntry<T>(x,true);
		if(currentSize > array.length/2)
			rehash();
	}
	
	public void remove(T x){
		int currentPos = findPos(x);
		if(isActive(currentPos)){
			array[currentPos].isActive = false;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void allocateArray(int arraySize) {
		array=new HashEntry[nextPrime(arraySize)];
	}

	private boolean isActive(int currentPos){
		return array[currentPos] != null && 
				array[currentPos].isActive;	
	}

	private int findPos(T x) {
		int offset = 1;
		int currentPos = myhash(x);
		
		while(array[currentPos] != null &&
				!array[currentPos].element.equals(x)){
			currentPos += offset;
			offset += 2;
			if(currentPos >= array.length)
				currentPos -= array.length;
		}
		return currentPos;
	}

	private void rehash(){
		HashEntry<T>[] oldArray = array;
		allocateArray(nextPrime(2*oldArray.length));		
		currentSize = 0;
		for(int i=0;i<oldArray.length;i++)
			if(oldArray[i] != null && oldArray[i].isActive)
				insert(oldArray[i].element);
	}
	
	private int myhash(T x){
		/*int hashVal = x.hashCode();
		hashVal %= array.length;
		if(hashVal < 0){
			hashVal += array.length;
		}*/
		return 0;
		
	}
	
	private static int nextPrime(int n){
		return 0;
		
	}
	
	private static boolean isPrime(int n){
		return false;
		
	}
	
	private static class HashEntry<T>{
		public T element;
		public boolean isActive;
		
		@SuppressWarnings("unused")
		public HashEntry(T e){
			this(e,true);
		}
		
		public HashEntry(T e,boolean i){
			element=e;
			isActive=i;
		}
	}
}
