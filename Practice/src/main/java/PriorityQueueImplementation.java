/**
 * 
 */

/**
 * @author sparida
 * 
 * http://www.javamadesoeasy.com/2015/01/priority-queues.html
 * 
 * Complexity of Priority Queues in java >
Insert - O(n) [as we insert element in middle of priority queue on basis of priority]
Remove - O(1) [as we remove element from front of priority queue in java]
 *
 */
public class PriorityQueueImplementation {
	
	private int[] priorityQueue;
	private int size;//Size of Queue
	private int number; //holds number of elements in Priority Queue, initialized with 0 by default

	public PriorityQueueImplementation(int size){
		this.size=size;
		this.number=0;
		priorityQueue = new int[size];
	}
	
	private Boolean isFull(){
		return (number==size);
	}
	
	private Boolean isEmpty(){
		return (number==0);
	}
	
	public static void main(String[] args) {
		PriorityQueueImplementation priorityQueue = new PriorityQueueImplementation(10); // Priority Queue holds 10 elements
        priorityQueue.insert(81);
        priorityQueue.insert(72);
        priorityQueue.insert(52);
        priorityQueue.insert(61);
        
        System.out.print("Deleted elements from queue: ");
        System.out.print(priorityQueue.remove()+" ");
        System.out.print(priorityQueue.remove()+" ");
        System.out.print(priorityQueue.remove()+" ");
        System.out.print(priorityQueue.remove()+" ");

	}
	
	private int remove() {
		
		if(isEmpty()){
			throw new QueueEmptyException("Queue is empty");
		}
		
		return priorityQueue[number--];
		
	}

	private void insert(int no) {
		int i;
		if (isFull()) {
			throw new QueueFullExcption("Cannot insert " + no + ", Queue is full");
		}
		if (number == 0) {
			priorityQueue[number++] = no;// If no values in PriorityQueue-
											// insert at starting position, i.e.
											// at 0th position.
		} else {
			for (i = number - 1; i >= 0; i--) {
				if (no > priorityQueue[i])
					priorityQueue[i + 1] = priorityQueue[i]; // if value is
																// larger, shift
																// elements
																// upward till
																// value is
																// larger.
				else
					break;
			}
			priorityQueue[++i] = no; // insert element in space created by
										// upward shift of elements.
			number++;
		}

	}

	class QueueFullExcption extends RuntimeException{
		
		public QueueFullExcption(){
			super();
		}
		
		public QueueFullExcption(String msg){
			super(msg);
		}
	}
	
	class QueueEmptyException extends RuntimeException{
		public QueueEmptyException(){
			super();
		}
		public QueueEmptyException(String msg){
			super(msg);
		}
	}

}
