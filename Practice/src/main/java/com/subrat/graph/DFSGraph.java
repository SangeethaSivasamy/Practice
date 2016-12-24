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
public class DFSGraph {
	
	private static Integer V;
	private LinkedList<Integer> adj[];
	private static boolean[] visited = new boolean[V];
	
	public DFSGraph(Integer v){
		this.V=v;
		adj=new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i]=new LinkedList<>();
		}
	}
	
	private void addEdge(Integer v,Integer w){
		adj[v].add(w);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		DFSGraph dFSGraph = new DFSGraph(4);
		dFSGraph.addEdge(0, 1);
		dFSGraph.addEdge(0, 2);
		dFSGraph.addEdge(1, 2);
		dFSGraph.addEdge(2, 0);
		dFSGraph.addEdge(2, 3);
		dFSGraph.addEdge(3, 3);
		for (int i = 0; i < 4; i++) {
			if(visited[i]==false)
			dFSGraph.DFS(i);
		}
		
		
	}

	private void DFS(int i) {
		
		DFS(i,visited);
		
		
	}

	private void DFS(int i, boolean[] visited) {
		System.out.print(i+",");
		visited[i]=true;
		Iterator<Integer> itr=adj[i].listIterator();
		while(itr.hasNext()){
			int n=itr.next();
			if(visited[n]==false){
				DFS(n, visited);
			}
		}
		
	}

}
