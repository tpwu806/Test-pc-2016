package test2016.datadtructures.part5.separateChainng;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: ��������</p>
 * @author wutp 2016��9��20��
 * @version 1.0
 */
public class SparateChainingHashTable<T> {
	
	private static final int DEFAULT_TABLE_SIZE = 101;
	private List<T>[] theLists;
	private int currentSize;
	
	public SparateChainingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public SparateChainingHashTable(int size){
		theLists = new LinkedList[nextPrime(size)];
		for(int i=0;i<theLists.length;i++)
			theLists[i] = new LinkedList<>();
	}
	
	public void insert(T x){
		List<T> whichList = theLists[myhash(x)];
		if(!whichList.contains(x)){
			whichList.add(x);
			if(++currentSize > theLists.length)
				rehash();
		}
	}
	
	public void remove(T x){
		List<T> whichList = theLists[myhash(x)];
		if(whichList.contains(x)){
			whichList.add(x);
			currentSize--;
		}
	}
	
	public boolean contains(T x){
		List<T> whichList = theLists[myhash(x)];		
		return whichList.contains(x);		
	}
	
	public void makeEmpty(T x){
		for(int i=0;i<theLists.length;i++)
			theLists[i].clear();
		currentSize = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void rehash(){
		List<T>[] oldLists = theLists;
		theLists = new List[nextPrime(2*theLists.length)];
		for(int j=0;j<theLists.length;j++)
			theLists[j] = new LinkedList<>();
		currentSize = 0;
		for(int i=0;i<oldLists.length;i++)
			for(T item : oldLists[i])
				insert(item);
	}
	
	private int myhash(T x){
		int hashVal = x.hashCode();
		hashVal %= theLists.length;
		if(hashVal < 0){
			hashVal += theLists.length;
		}
		return hashVal;
		
	}
	
	private static int nextPrime(int n){
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2);
		return n;		
	}
	
	private static boolean isPrime(int n){
	if (n == 2 || n == 3)
      return true;
    if (n == 1 || n % 2 == 0)
      return false;
    for (int i = 3; i * i <= n; i += 2)
      if (n % i == 0)
        return false;
    return true;		
	}
}
