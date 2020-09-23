import java.lang.Math; 

public class MyHashTable2<K extends Comparable<K>, T> implements MyHashTable_<K, T> {
	int size;
	BST<K, T>[] hashtable;
	@SuppressWarnings("unchecked")
	MyHashTable2(int s) {
		size = s;
		hashtable = new BST[s];
	}
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	@Override
	public int insert(K key, T obj) {
		String str = key.toString();
		int j = (int) (djb2(str, size)) % size;
		if((hashtable[j] == null) || (hashtable[j].root == null)) {
			BST<K, T> b = new BST<K, T>();
			Node<K, T> n = new Node<K, T>(key, obj);
			b.root = n;
			hashtable[j] = b;
			return 1;
		}
		else{
			hashtable[j].insert(key, obj);
			return hashtable[j].count();
		}
	}

	@Override
	public int update(K key, T obj) {
		String str = key.toString();
		int j = (int) (djb2(str, size)) % size;
		if(hashtable[j] != null) {
			hashtable[j].update(key, obj);
			return hashtable[j].count();
		}
		else {
			return 0;
		}
	}

	@Override
	public int delete(K key) {
		String str = key.toString();
		int j = (int) (djb2(str, size)) % size;
		if(hashtable[j] != null) {
			hashtable[j].delete(key);
			return hashtable[j].count();
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean contains(K key) {
		String str = key.toString();
		int j = (int) (djb2(str, size)) % size;
		if(hashtable[j] == null || hashtable[j].root == null) {
			return false;
		}
		else if(hashtable[j].search(key) == null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public T get(K key) throws NotFoundException {
		String str = key.toString();
		int j = (int) (djb2(str, size)) % size;
		if(hashtable[j] != null && hashtable[j].search(key) != null) {
			return hashtable[j].search(key).obj();
		}
		else {
			throw new NotFoundException("E");
		}
	}

	@Override
	public String address(K key) throws NotFoundException {
		String str = key.toString();
		int j = (int) (djb2(str, size)) % size;
		String s = String.valueOf(j);
		if(hashtable[j] != null && hashtable[j].search(key) != null) {
			hashtable[j].search(key);
			return (s + hashtable[j].address());
		}
		else {
			throw new NotFoundException("E");
		}
	}

}