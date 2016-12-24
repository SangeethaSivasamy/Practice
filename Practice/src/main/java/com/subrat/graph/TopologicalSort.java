/**
 * 
 */
package com.subrat.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sparida
 *
 */
public class TopologicalSort {
	
	private Integer v;
	private LinkedList[] adjList;
	
	public TopologicalSort(Integer V){
		this.v=V;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int v, int e){
		adjList[v].add(e);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TopologicalSort topologicalSort = new TopologicalSort(6);
		topologicalSort.addEdge(5, 0);
		topologicalSort.addEdge(5, 2);
		topologicalSort.addEdge(4, 0);
		topologicalSort.addEdge(4, 1);
		topologicalSort.addEdge(2, 3);
		topologicalSort.addEdge(3, 1);
		topologicalSort.sort();

	}

	private void sort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if(visited[i]==false){
				sortUtil(i,visited,stack);
			}
			
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		
		
	}

	private void sortUtil(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i]=true;
		Iterator<Integer> itr = adjList[i].iterator();
		while(itr.hasNext()){
			int no = itr.next();
			if(visited[no]==false){
				sortUtil(no, visited, stack);
			}
		}
		
		stack.push(i);
		
	}

	
}
