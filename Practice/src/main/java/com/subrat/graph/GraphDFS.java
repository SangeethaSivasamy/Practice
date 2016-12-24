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
public class GraphDFS {
	
	private Integer V;
	private LinkedList[] adjList;
	
	public GraphDFS(Integer v){
		this.V=v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i]=new LinkedList<>();
		}
	}
	
	void addEdge(int v, int e){
		adjList[v].add(e);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GraphDFS graphDFS = new GraphDFS(4);
		graphDFS.addEdge(0, 1);
		graphDFS.addEdge(0, 2);
		graphDFS.addEdge(1, 2);
		graphDFS.addEdge(2, 0);
		graphDFS.addEdge(2, 3);
		graphDFS.addEdge(3, 3);
		graphDFS.DFSSearch(2);
	}

	private void DFSSearch(int i) {
		boolean[] visited = new boolean[V];
		DFSSearchUtil(i,visited);
		
	}

	private void DFSSearchUtil(int i, boolean[] visited) {
		System.out.print(i+",");
		visited[i]=true;
		Iterator<Integer> itr = adjList[i].listIterator();
		while(itr.hasNext()){
			int no = itr.next();
			if(!visited[no]){
			DFSSearchUtil(no, visited);
			}
		}
		
	}

}
