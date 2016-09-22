package test2016.operator;

public class Test {

	/**
	 *@Description:运算符
	 *@data:上午8:47:44
	 *@author:wutp
	 *@param args
	 *@return void
	 */
	public static void main(String[] args) {
		
		suanShu();
		
		
	}
	//单目：+（取正）-（取负） ++（自增） - -（自减）
	//双目：+ - * / %（取余）
	//三目：a>b?true:false 说明：当a大于b的时候，为true（也就是冒号之前的值），
	//否则为false；这整个运算符包括一个关系运算符（可以是“>”"<""!="等等），一个“？”，一个“：”，
	//冒号前后需要有两个表达式或者是值或者是对象。	
	private static void suanShu(){
		
	}
	//等于符号:==，不等于符号:!= ，大于符号:>， 小于符号:<，大于等于符号:>= ，小于等于符号:<= 。
	private static void guanXi(){
		
	}
	//= += -= *= /= %= &= ^= |= <<= >>=
	private static void fuZhi(){
		
	}
	//位运算符 与（&）、非（~）、或（|）、异或（^）
	private static void weiYunSuan(){
		int c = 1100 ^ 1010;
		int d = ~1; 
		int e = 1010&1101;
		int f = 1100|1010;
	}
	//与（&&）、非（!）、或（||）
	private static void luoJiYunSuan(){
		int[] a={1,2,3};
		if(a[0]==2&a[3]==4){
			System.out.println("true");
		}
		
		int[] b={1,2,3};
		if(b[0]==2&&b[3]==4){
			System.out.println("true");
		}	
	}
	//<< 带符号左移 >>带符号右移 >>> 无号右移
	private static void weiYi(){
		int m=-7;
		System.out.println("m的二 进 制码是："+Integer.toBinaryString(m));
		System.out.println("m>>2的二进制码是："+Integer.toBinaryString(m>>2));
		System.out.println("(m>>2)="+(m>>2));
		System.out.println("m<<2的二进制码是："+Integer.toBinaryString(m<<2));
		System.out.println("(m<<2)=:"+(m<<2));
		System.out.println("m>>>24的二进制码是："+Integer.toBinaryString(m>>>24));
		System.out.println(" m>>>24 :"+ (m>>>24));
	}
	
/*	public Set<K> keySet() {
		if (keySet == null) {
		    keySet = new AbstractSet<K>() {
				public Iterator<K> iterator() {
				    return new Iterator<K>() {
						private Iterator<Entry<K,V>> i = entrySet().iterator();
				
						public boolean hasNext() {
						    return i.hasNext();
						}
				
						public K next() {
						    return i.next().getKey();
						}
				
						public void remove() {
						    i.remove();
						}
		            };
				}
		
				public int size() {
				    return AbstractMap.this.size();
				}
		
				public boolean contains(Object k) {
				    return AbstractMap.this.containsKey(k);
				}
		    };
		}
	return keySet;
	}*/

	
	

}
