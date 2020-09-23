
public class BST<K extends Comparable<K>, T> {
	Node<K, T> root;
	int count = 0;
	String address = "";
	public Node<K, T> root() {
		return root;
	}
	public int count() {
		return count;
	}
	public String address() {
		return address;
	}
	public Node<K, T> insert(Node<K, T> node, K key, T obj) {
		if(node == null) {
			node = new Node<K, T>(key, obj);
			return node;
		}
		else if(key.compareTo(node.key()) == 0) {
			count = 0;
			return node;
		}
		else {
			if(key.compareTo(node.key()) < 0) {
				count++;
				node.left = insert(node.left, key, obj);
			}
			if(key.compareTo(node.key()) > 0) {
				count++;
				node.right = insert(node.right, key, obj);
			}
		}
		return node;
	}
	public void insert(K key, T obj) {
		count = 1;
		root = insert(root, key, obj);
	}
	public Node<K, T> update(Node<K, T> node, K key, T obj){
		if(node == null) {
			count = 0;
			return node;
		}
		if(node.key().compareTo(key) == 0) {
			node.obj = obj;
			return node;
		}
		else {
			if(key.compareTo(node.key()) < 0) {
				count++;
				node.left = update(node.left, key, obj);
			}
			if(key.compareTo(node.key()) > 0) {
				count++;
				node.right = update(node.right, key, obj);
			}
		}
		return node;
	}
	public void update(K key, T obj) {
		count = 1;
		root = update(root, key, obj);
	}
	public Node<K, T> minkey(Node<K, T> node) {
		if(node.left == null) {
			return node;
		}
		else {
			return minkey(node.left);
		}
	}
	public Node<K, T> delete(Node<K, T> node, K key) {
        if(node == null) {
        	count = 0;
        	return node;
        }
        if(key.compareTo(node.key()) < 0) {
        	count++;
            node.left = delete(node.left(), key);
        } else if(key.compareTo(node.key()) > 0) {
        	count++;
            node.right = delete(node.right(), key);
        } else {
            if(node.left() == null && node.right() == null) {
            	return null;
            } else if(node.left() == null) {
            	count++;
                return node.right();
            } else if(node.right() == null) {
            	count++;
                return node.left();
            } else {
            	count++;
                Node<K, T> minNode = minkey(node.right());
                node.obj = minNode.obj();
                node.key = minNode.key();
                node.right = delete(node.right(), node.key());
            }
        }
        return node;
    }
	public void delete(K key) {
		count = 1;
		root = delete(root, key);
	}
    public Node<K, T> search(Node<K, T> node, K key) {
    	if(node == null) {
    		count = 0;
    		return node;
    	}
    	if(node.key().compareTo(key) == 0) {
    		return node;
    	}
    	else {
    		if(key.compareTo(node.key()) < 0) {
    			address = address + "L";
    			return search(node.left(), key);
    		}
    		else {
    			address = address + "R";
    			return search(node.right(), key);
    		}
    	}
    }
    public Node<K, T> search(K key) {
    	address = "-";
    	return search(root, key);
    }
}