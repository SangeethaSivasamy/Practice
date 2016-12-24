/**
 * 
 */
package com.subrat.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author sparida
 *
 */
public class DFSInAGraphPractice {
	
	private Integer V;
	private LinkedList<Integer> adj[];
	
	public DFSInAGraphPractice(Integer v){
		this.V=v;
		this.adj=new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
			
		}
	}
	
	void addEdge(int v,int w){
		adj[v].add(w);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DFSInAGraphPractice dFSInAGraphPractice = new DFSInAGraphPractice(4);
		dFSInAGraphPractice.addEdge(0, 1);
		dFSInAGraphPractice.addEdge(0, 2);
		dFSInAGraphPractice.addEdge(1, 2);
		dFSInAGraphPractice.addEdge(2, 0);
		dFSInAGraphPractice.addEdge(2, 3);
		dFSInAGraphPractice.addEdge(3, 3);
		dFSInAGraphPractice.DFS(2);

	}

	private void DFS(int i) {
		boolean[] visited = new boolean[V];
		DFS(i,visited);
		
	}

	private void DFS(int i, boolean[] visited) {
		visited[i]=true;
		System.out.print(i+",");
		Iterator<Integer> itr = adj[i].listIterator();
		while(itr.hasNext()){
			int n=itr.next();
			if(!visited[n]){
				DFS(n,visited);
			}
		}
		
	}

}
