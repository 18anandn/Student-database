
public class Node<K extends Comparable<K>, T> {
	K key;
	T obj;
	Node<K,T> left, right = null;
	Node(K k, T t){
		key = k;
		obj = t;
		left = null;
		right = null;
	}
	public K key() {
		return key;
	}
	public T obj() {
		return obj;
	}
	public Node<K, T> left() {
		return left;
	}
	public Node<K, T> right() {
		return right;
	}
}