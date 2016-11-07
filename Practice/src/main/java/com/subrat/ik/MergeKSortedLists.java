/**
 * 
 */
package com.subrat.ik;

/**
 * @author sparida
 *
 */
public class MergeKSortedLists {
	
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = {{1,3,5,7},
				         {2,4,6,8},
				         {0,9,10,11}};

	}

}

pstatic class ListNode{
	
}
