
public class Pair<A, B> implements Comparable<Pair<A, B>> {
	public A key;
	public B obj;
	public Pair (A a, B b){
		key = a;
		obj = b;
	}
	public A key() {
		return key;
	}
	public B obj() {
		return obj;
	}
	public String toString() {
		return key.toString() + obj.toString();
	}
	public int compareTo(Pair<A, B> p) {
		if(key.toString().compareTo(p.key().toString()) < 0) {
			return -1;
		}
		else if(key.toString().compareTo(p.key().toString()) > 0) {
			return 1;
		}
		else if(obj.toString().compareTo(p.obj().toString()) < 0) {
			return -1;
		}
		else if(obj.toString().compareTo(p.obj().toString()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}