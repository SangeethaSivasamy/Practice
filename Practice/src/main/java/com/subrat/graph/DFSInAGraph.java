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
public class DFSInAGraph {

	private Integer V;
	private LinkedList<Integer> adj[];

	public DFSInAGraph(Integer v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DFSInAGraph dFSInAGraph = new DFSInAGraph(4);
		dFSInAGraph.addEdge(0, 1);
		dFSInAGraph.addEdge(0, 2);
		dFSInAGraph.addEdge(1, 2);
		dFSInAGraph.addEdge(2, 0);
		dFSInAGraph.addEdge(2, 3);
		dFSInAGraph.addEdge(3, 3);
		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		dFSInAGraph.DFS(2);
	}

	private void DFS(int v) {
		boolean visited[] = new boolean[V];
		DFSUtil(v, visited);

	}

	private void DFSUtil(int v, boolean[] visited) {

		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}

	}

}
