package com.code2016.datadtructures.part5.cuckooHashing;

public class CuckooHashTable<T> {
	
	private static final double MAX_LOAD = 0.4;
	private static final int ALLOWED_REHASHES = 1;	
	private static final int DEFAULT_TABLE_SIZE = 101;
	
	private final HashFamily<? extends T> hashFunctions;
	private final int numHashFunctions;	
	private T[] array;
	private int currentSize;
	
	public CuckooHashTable(HashFamily<? extends T> hf){
		this(hf,DEFAULT_TABLE_SIZE);
	}
	
	public CuckooHashTable(HashFamily<? extends T> hf,int size){
		allocateArray(nextPrime(size));
		doClear();
		hashFunctions = hf;
		numHashFunctions = hf.getNumberOfFunctions();
	}
	
	public void makeEmpty(){		
		doClear();
	}

	public boolean contains(T x){
		return false;
		/*int currentPos = findPos(x);		
		return isActive(currentPos);*/		
	}

	public void insert(T x){
		/*int currentPos = findPos(x);
		if(isActive(currentPos)){
			return;
		}
		array[currentPos] = new HashEntry<>(x,true);
		if(currentSize > array.length/2)
			rehash();*/
	}

	private int myhash(T x){
		/*int hashVal = x.hashCode();
		hashVal %= array.length;
		if(hashVal < 0){
			hashVal += array.length;
		}*/
		return 0;
		
	}

	private int findPos(T x) {
		int offset = 1;
		int currentPos = myhash(x);
		
		/*while(array[currentPos] != null &&
				!array[currentPos].element.equals(x)){
			currentPos += offset;
			offset += 2;
			if(currentPos >= array.length)
				currentPos -= array.length;
		}*/
		return currentPos;
	}
	
	public void remove(T x){
		int currentPos = findPos(x);
		/*if(isActive(currentPos)){
			array[currentPos].isActive = false;
		}*/
	}

	private void expand(){
		
	}

	private void rehash(){
		/*HashEntry<T>[] oldArray = array;
		allocateArray(nextPrime(2*oldArray.length));		
		currentSize = 0;
		for(int i=0;i<oldArray.length;i++)
			if(oldArray[i] != null && oldArray[i].isActive)
				insert(oldArray[i].element);*/
	}

	private void doClear(){
		currentSize = 0;
		for(int i = 0;i < array.length ;i++)
			array[i] = null;
	}

	private void allocateArray(int arraySize) {
		array=(T[]) new Object[arraySize];
	}
	
	private static int nextPrime(int n){
		return 0;
		
	}
	
	private static boolean isPrime(int n){
		return false;
		
	}
	
}
