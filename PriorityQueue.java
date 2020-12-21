
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure. 
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
        numElements = 1;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	*/
	public void insert(Interval k) { 
     		if (numElements == size) {
			// Expand the buffer allocated for the heap to another buffer that is twice as big.
		    size = size * 2;
            Interval [] newheap = new Interval[size + 1];
            for (int i = 1; i < heap.length; i++){
                newheap[i] = heap[i];
            }
            heap = newheap;
        }
		// Insert without buffer expansion here.
        
        heap[numElements] = k;
        siftUp(numElements);
        numElements++;
	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null; // Retuns null if heap is empty.
		// Remove_max code here.
	    Interval root = heap[1];
        swap(1, numElements - 1);
        numElements--;
        siftDown(1);	
		return root; // Replace this statement with returning the max element (root) in the heap.
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
    private int parent(int i){
        return i / 2;
    }
    private int left(int i){
        return 2 * i;
    }
    private int right(int i){
        return 2 * i + 1;
    }
    public Interval[] getHeap(){
        return heap;
    }
    private void swap(int i, int p){
        Interval pVal = heap[p];
        heap[p] = heap[i];
        heap[i] = pVal; 
    }
    private void siftUp(int i){
        int p = parent(i);
        
        while (p != 0 && heap[i].compareTo(heap[p]) > 1){
            swap(i, p);
            i = p;
            p = parent(p);
        }
    }
    private void siftDown(int i){
        int l = left(i);
        int r = right(i);
        
        int b;
       if (l >= heap.length || r >= heap.length){
            return;
       }
       else if(l >= heap.length)
            b = r;
       else if (r >= heap.length)
            b = l;
       if (heap[r] == null && heap[l] == null){
            return;
       }
        else if(heap[r] == null)
            b = l;
        else if (heap[l] == null)
            b = r;
        else {
            if (heap[l].compareTo(heap[r]) > 0)
                  b = l;
            else
                  b = r;
            }
        
        while (b < numElements && heap[i].compareTo(heap[b]) < 1){

        swap(i, b);
        i = b;
        l = left(i);
        r = right(i);

            if (l >= heap.length || r >= heap.length){
                break;
            }
            else if(l >= heap.length)
                b = r;
            else if (r >= heap.length)
                b = l;
            else if (heap[r] == null && heap[l] == null){
                break;
            }
            else if(heap[r] == null)
                b = l;
            else if (heap[l] == null)
                b = r;
            else {
                if (heap[l].compareTo(heap[r]) > 0)
                    b = l;
                else
                    b = r;
            }
        
        }


}
}
