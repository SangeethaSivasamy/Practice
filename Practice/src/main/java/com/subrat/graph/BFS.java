/**
 * 
 */
package com.subrat.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sparida
 *
 */
public class BFS {
	
	private Integer V;
	private LinkedList[] adj;
	
	public BFS(Integer v){
		this.V=v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	private void addEdge(int v, int e){
		adj[v].add(e);
	}
	
	private void BFSSearch(int no) {
		
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(no);
		visited[no]=true;
		
		while(!queue.isEmpty()){
			int data = queue.poll();
			System.out.print(data+",");
			Iterator<Integer> itr = adj[data].iterator();
			while(itr.hasNext()){
				int no1 = itr.next();
				if(visited[no1]==false){
					visited[no1]=true;
					queue.add(no1);
				}
			}
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BFS g = new BFS(4);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFSSearch(2);
	}

	

}
