import java.util.*;

public class Lab7<Key extends Comparable <Key>, Value>
{
	private Node root;

	public class Node
	{
		private Key key;
		private Value val;
		private Node left,right;
		private int size;

		public Node(Key key, Value val, int size)
		{
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}

	public Lab7()
	{
		root = null;
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	public int size()
	{
		return size(root);
	}

	private int size(Node x)
	{
		if(x == null) return 0;
		else return x.size;
	}

	//To check wether the given key is in the symbol table or not.
	public boolean contains(Key key)
	{
		if(key == null) throw new IllegalArgumentException("The key to be contain is null.");
	
		return get(key) != null;
		
	}

	public Value get(Key key)
	{
		return get(root, key);
	}

	public Value get(Node x, Key key)
	{
		if(key == null) throw new IllegalArgumentException("key to be contained is null.");
		if(x == null) return null;
		int cmp = key.compareTo(x.key);

			if      (cmp < 0)    return get(x.left, key);
			else if (cmp > 0)    return get(x.right, key);
			else                 return x.val;
	}

	public void put(Key key, Value val)
	{
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val)
	{
		if(x == null)
		{ 
			x = new Node(key, val, 1);
		}
		int cmp = key.compareTo(x.key);
		
		if(cmp < 0)
		{     
			x.left = put(x.left, key, val);
		}
		else if(cmp > 0)
		{
			x.right = put(x.right, key, val);
		}
		else if(cmp == 0)
		{ 
			x.val = val;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Key min()
	{
		return min(root).key;
	}
	private Node min(Node x)
	{
		if(x.left == null) return x;
		return min(x.left);
	}

	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}

	private Node floor(Node x, Key key)
	{
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if  (cmp == 0) return x;
		if  (cmp < 0)  return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null) return t;
		else          return x;
	}

	public Key select(int k)
	{
		if (k < 0 || k >= size())
		{
			throw new IllegalArgumentException("key to be selected is null: "+k);
		}
		return select(root, k);
	}

	private Key select(Node x, int k)
	{
		if (x == null) return null;
		int leftsize = size(x.left);
		if       (leftsize > k) return select(x.left, k);
		else if  (leftsize < k) return select(x.right, k - leftsize - 1);
		else                    return x.key;
	}

	//public Iterable<Key> keys()
	//{
	//	return keys(min(), max());
	//}

	public Iterable<Key> keys(Key lo, Key hi)
	{
		if(lo == null) throw new IllegalArgumentException("lo key to get is null");
		if(hi == null) throw new IllegalArgumentException("hi key to get is null");

		ArrayList<Key> arr = new ArrayList<Key>();
		keys(root, arr, lo, hi);
		return arr;
	}

	private void keys(Node x, ArrayList<Key> arr, Key lo, Key hi)
	{
		if(x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo < 0) keys(x.left, arr, lo, hi);
		if(cmplo <= 0 && cmphi >=0) arr.add(x.key);
		if(cmphi > 0) keys(x.right, arr, lo, hi);
	}

}