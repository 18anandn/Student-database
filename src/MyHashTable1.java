import java.lang.Math; 

public class MyHashTable1<K extends Comparable<K>, T> implements MyHashTable_<K, T> {
	int size;
	Pair<K, T>[] hashtable;
	@SuppressWarnings("unchecked")
	MyHashTable1(int s) {
		size = s;
		hashtable = new Pair[s];
	}

	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	public static long sdbm(String str, int hashtableSize) {
	    long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
	@Override
	public int insert(K key, T obj) {
		int h1 = (int) djb2(key.toString(), size);
		int h2 = (int) sdbm(key.toString(), size);
		int i = 0;
		while((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].obj != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) != 0)) {
			i++;
			if(i == size) {
				break;
			}
		}
		if(hashtable[(h1 + i*h2) % size] == null) {
			hashtable[(h1 + i*h2) % size] = new Pair<K, T>(key, obj);
			return i + 1;
		}
		else if(hashtable[(h1 + i*h2) % size].obj == null) {
			hashtable[(h1 + i*h2) % size].key = key;
			hashtable[(h1 + i*h2) % size].obj = obj;
			return i + 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public int update(K key, T obj) {
		int h1 = (int) djb2(key.toString(), size);
		int h2 = (int) sdbm(key.toString(), size);
		int i = 0;
		while((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) != 0)){
				i++;
				if(i == size) {
					break;
				}
		}
		if((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) == 0) && (hashtable[(h1 + i*h2) % size].obj != null)) {
			Pair<K, T> p = new Pair<K, T>(key, obj);
			hashtable[(h1 + i*h2) % size] = p;
			return i + 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public int delete(K key) {
		int h1 = (int) djb2(key.toString(), size);
		int h2 = (int) sdbm(key.toString(), size);
		int i = 0;
		while(hashtable[(h1 + i*h2) % size] != null && hashtable[(h1 + i*h2) % size].key().compareTo(key) != 0) {
				i++;
				if(i == size) {
					break;
				}
		}
		if(hashtable[(h1 + i*h2) % size] != null && hashtable[(h1 + i*h2) % size].key().compareTo(key) == 0 && (hashtable[(h1 + i*h2) % size].obj != null)) {
			hashtable[(h1 + i*h2) % size].obj = null;
			return i + 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean contains(K key) {
		int h1 = (int) djb2(key.toString(), size);
		int h2 = (int) sdbm(key.toString(), size);
		int i = 0;
		while((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) != 0)) {
			i++;
			if(i == size) {
				break;
			}
		}
		if((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) == 0) && (hashtable[(h1 + i*h2) % size].obj() != null)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public T get(K key) throws NotFoundException {
		int h1 = (int) djb2(key.toString(), size);
		int h2 = (int) sdbm(key.toString(), size);
		int i = 0;
		while((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) != 0)) {
				i++;
				if(i == size) {
					break;
				}
		}
		if((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) == 0) && (hashtable[(h1 + i*h2) % size].obj != null)) {
			return hashtable[(h1 + i*h2) % size].obj();
		}
		else {
			throw new NotFoundException("E");
		}
	}

	@Override
	public String address(K key) throws NotFoundException {
		int h1 = (int) djb2(key.toString(), size);
		int h2 = (int) sdbm(key.toString(), size);
		int i = 0;
		while((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) != 0)) {
				i++;
				if(i == size) {
					break;
				}
		}
		if((hashtable[(h1 + i*h2) % size] != null) && (hashtable[(h1 + i*h2) % size].key().compareTo(key) == 0) && (hashtable[(h1 + i*h2) % size].obj != null)) {
			return String.valueOf((h1 + i*h2) % size);
		}
		else {
			throw new NotFoundException("E");
		}
	}
}