/**
 * Ordered linked list implementation of the SimpleMap ADT.
 *
 * @author  Mike Jacobson
 * @version 1.0
 */
public class LinkedListMap <K extends Comparable <K>, V> implements SimpleMap <K, V> {
    private Node <K, V> head;
    private int llsize;
    private int numSearch;
    private int numCompare;
    
    public LinkedListMap () {
        head = null;
        llsize = 0;
        numSearch = 0;
        numCompare = 0;
    }


    /**
     * Returns the current number of calls to search.
     *
     * @return current number of calls to search
     */
    public int getNumSearch() {
        return numSearch;
    }


    /**
     * Returns the total number of comparisons of keys in search.
     *
     * @return current number of iterations of the while loop in  search
     */
    public int getNumCompare() {
        return numCompare;
    }



    @Override
    public boolean isEmpty() {
	return (llsize == 0);
    }


    
    @Override
    public int size () {
        return llsize;
    }


    @Override
    public V search (K key) throws KeyNotFoundException {
        ++numSearch;

        Node <K, V> current = head;

	int comp = 0;
	if (current != null) {
	    ++numCompare;
	    comp = (current.key).compareTo(key);
	}
		
        while (current != null && (comp <= 0)) {
            if (comp == 0)
                return current.value;

	    current = current.next;
	    if (current != null) {
		++numCompare;
		comp = (current.key).compareTo(key);
	    }
        }
        throw new KeyNotFoundException ();
    }
    

    
    @Override
    public void modify (K key, V value) throws KeyNotFoundException {
        Node <K, V> current = head;
        while (current != null && (current.key).compareTo(key) <= 0) {
            if ((current.key).compareTo(key) == 0) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        throw new KeyNotFoundException ();
    }




    @Override
    public void insert (K key, V value) throws KeyFoundException {
        Node <K, V> current = head;
        Node <K, V> previous = null;
        while (current != null && (current.key).compareTo(key) <= 0) {
            if ((current.key).compareTo(key) == 0)
		throw new KeyFoundException ();
            previous = current;
            current = current.next;
	}

        Node <K, V> n = new Node <K, V> (key, value, current);
        if (previous == null)
	    head = n;
        else
	    previous.next = n;
        llsize++;
    }


    
    @Override
    public void delete (K key) throws KeyNotFoundException {
        Node <K, V> current = head;
        if ((current != null) && ((current.key).compareTo(key) == 0)) {
            head = head.next;
            llsize--;
            return;
        }

        while (current.next != null && ((current.next).key).compareTo(key) <= 0) {
            if (((current.next).key).compareTo(key) == 0) {
                current.next = (current.next).next;
                llsize--;
                return;
            }    
            current = current.next;
        }
        throw new KeyNotFoundException ();
    }
    


    private class Node <K extends Comparable <K>, V> {
        private K key;
        private V value;
        private Node <K, V> next;
           
        public Node (K k, V v, Node <K, V> n) {
            key = k;
            value = v;
            next = n;
        }
    }    


    public static void main (String [] args) {
        LinkedListMap <Integer, String> ll = new LinkedListMap <Integer, String> ();
        ll.insert (1, "hello");
        ll.insert (2, "test");
        System.out.println(ll.search (1).toString());
        System.out.println(ll.search (2).toString());
        ll.delete(2);
        System.out.println(ll.search (2).toString());
    }
}
