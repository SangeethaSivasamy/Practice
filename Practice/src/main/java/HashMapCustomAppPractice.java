
/**
 * 
 */

/**
 * @author sparida
 *
 */
public class HashMapCustomAppPractice<K,V> {
	private Entry<K,V>[] table;
	private int capacity = 4;
	
	public HashMapCustomAppPractice(){
		table = new Entry[capacity];
	}
	
	private void put(K newKey,V data){
		
	}
	
	private V getKey(K newKey){
		if(newKey==null){
			return null;
		}
		int hashValue = hash(newKey);
		if(table[hashValue]==null){
			return null;
		}else{
			Entry<K,V> current = table[hashValue];
		}
		return null;
		
	}
	
	private Boolean remove(K deleteKey){
		return null;
		
	}
	
	private void display(){
		
	}
	
	private int hash(K newKey){
		return Math.abs(newKey.hashCode()%capacity);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMapCustomAppPractice<Integer,Integer> map = new HashMapCustomAppPractice<Integer,Integer>();

	}
	
	static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;
    
        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}

