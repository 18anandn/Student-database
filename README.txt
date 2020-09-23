COL106
Assignment 3:

1. Double Hashing Implementation:
	Elements are stored in an array of pairs(pair of key and object).

1.a)Insert: An element in the array is inserted at an index of array calculated with the help of the given hash functions(applied on the key) only when either if there is nothing at that position or that position has a pair with no object. Since the computation of index from the hash functions((h1 + h2) % size) is instantaneous, the object is given its position and inserted at that index value(assuming no collision). Hence the best case time complexity is O(1) since computing the index is almost same for any key. If collision occurs, a different index is calculated by incrementing i by 1. Since the size is a prime number, we will get different values of index for different i upto size-1 for calculating the same h1 and h2 for the same key. The worst case is when almost all the positions in the array are occupied which results in O(n) time complexity. But in the average case it's O(1) since the array size is very large and hence the load factor becomes very small.

1.b)Update: The time complexity is same as insert in double hashing implementation. The index is computed by applying hash funtions on the given key which takes a very small amount time for any key. The value is computed and if this matches with the key stored in the pair, the object stored in the pair is replaced with the given object. If keys don't match, a different index is calculated by incrementing i by 1. Since the size is a prime number, we will get different values of index for different i upto size-1 for calculating the same h1 and h2 for the same key. The element in this index is checked whether the key match or not. Since comparing also takes a very small time for any key, the time complexity in best case for update is O(1). O(n) in worst case where the that object was inserted for a large i. O(1) in average case.

1.c)Delete: The time complexity is same as insert in double hashing implementation. The index is computed by applying hash funtions on the given key which takes a very small amount time for any key. If the key in the pair at this index matches with the given key it is deleted. Time complexity is cases is same as above.

1.d)Contains:	{				      }
1.e)Get:	{Time complexity is same as in update.}
1.f)Address:	{				      }

2. Separate chaining implementation:
	Elements are stored in an array of BSTs(Binary Search Trees). It consists of a root(which is a node having 2 pointers). The root can point to other nodes. The key and object is stored in this node. The size of this array is generally smaller than the amount of data to be inserted.

2.a)Insert: The index is calculated using single hashfuntion(h1 % size). If that index does not have any BST or has a BST with null root, the given key and pair are stored in a BST and put in this position. The best complexity is O(1) when no collision occurs. Worst case is when all the roots are stored like a link list in one direction. In this case time complexity is O(n) where n is the number of nodes traversed in that BST. This is so because it has to compare the key stored in every node traversed with the given key. Average case time complexity is O(1) where all objects are stored at different index positions in the array.

2.b)Update: The index is calculated using single hashfuntion(h1 % size) on the given key. In that BST the object is searched by comparing the given key with each key. Hence the time complexity cases are same as insert.

2.c)Delete: The index is calculated using single hashfuntion(h1 % size) on the given key. We traverse to the given node by comparing the given key with the key stored in the node. Time complexity cases is same as insert.

1.d)Contains:	{			      	      }
1.e)Get:	{Time complexity is same as in insert.}
1.f)Address:	{				      }

3. Interesting findings:

3.1) The time complexities for each method in both the implementations arec same in every case. This does not mean that we can choose any one of them irrespective of our requirements. Both have their advantages and disadvantages. Unlike Double Hashing implementation, Separate chaining will work even after the hashtable is full. But space is lost in Separate chaining because there can be such places in the array which are not used and the trees keep on increasing in height.

3.1) In double hashing implementation, in deletion, if the key given matches with the key stored in the pair, the object's value in the pair is set null rather than setting the whole pair as null. This comes in handy when using other operations. When only the object is set null, the key remains along with the pair. This can be thought of as a notice put on the board saying 'the object with the given key is deleted'. When inserting, if the index comes on a position which is not null but has a pair whose object is null, this pair will be replaced by a new pair containing the object to be inserted. The 'contains' opertion need not traverse through the whole array because upon reaching the key to be searched, it will also check if the object is still stored in the pair. If it's not, it'll return false. Similarly, it'll show throw the 'NotFoundException' in 'get' and 'address' operations.

3.2) In Separate Chaining implementation, the count is returned by assigning a count parameter to BST. Each operation in it is performed by calling two methods. This has two advantages. The first one is that the second method has less inputs than the first one and calls the first method. The second is that the second method sets the count equal to 1 and then performs the operation. We need this because if we don't do it, the count would contain the count of the previous method called and will continue adding from there instead from 1.

3.3) In the Separate Chaining implementation, the key for node is the first name. But if the first name are same, we have to consider the last name. So, I have created the compareTo() method in the Pair class such that, it'll compare the first name only in the two keys unless both first name are same.

3.4) Exception is not used in the following cases:
	i. Inserting an object which is already present.
	ii. Deleting an object which is not in the hashtable.
	iii. Updating an object which is not in the hashtable.
	In such cases the count is returned 0 which will then be used in the driver class to print E.

4. Classes used:
All the classes except 'assignment3' is generic class with 2 type parameters.

4.1)Pair:
	This class is used to use to different types of objects to be stored in a tuple. It implements the interface 'Comparable' which enables us to compare two keys directly.

4.2)Node:
	Node class is used in the BST class to create nodes. This class is stored to store 2 different(not necessarily) types - key and object for Separate Chaining implementation. It has two pointers namely left and right which can point to other nodes. It extends the 'Comparable' class on the key.

4.3)BST:
	This class is used to create binary search tree. This class basically uses node class and hass root as its parameter. All the basic input, update delete, etc methods for the tree is used in this class. It extends the 'Comparable' class on the key.

4.4)MyHashTable1:
	This class implements 'MyHashTable_' interface. It extends the 'Comparable' class on the key. It is used for Separate Chaining implementation. It inserts every element in the array of BSTs. This class uses BST class. All of its methods use the methods in the BST class.

4.5)MyHashTable2:
	This class implements 'MyHashTable_' interface. It extends the 'Comparable' class on the key. It is used for Double Hashing implementation. Only the pair class is used in this. Since the key and object are stored in the pair.

4.6)NotFoundException:
	This class is used to throw exception in case there is not a particular object in the hashtable but we still apply a particular method.

4.7)Student:
	This class implements the Student interface. This is the object type to be used in the hashtable.

4.8)assignment3:
	This is the driver class containing the main function.