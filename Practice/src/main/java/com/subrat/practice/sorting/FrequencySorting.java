/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author sparida
 *
 */
public class FrequencySorting {
	
	
	public String frequencySort(String s) {
        int[] freq = new int [256];
        for (char ch: s.toCharArray()) 
        freq[ch]++;
        TreeMap<Integer, List<Character>> tree = new TreeMap<Integer, List<Character>>();
        System.out.println(freq.length);
        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (!tree.containsKey(freq[i])) {
                    tree.put(freq[i], new LinkedList<Character>());
                }
                tree.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(tree.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch: entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }
        return sb.toString();
    }

	//O(n)
	public String frequencySort_2ndWay(String s) {
	    char[] arr = s.toCharArray();
	    
	    // bucket sort
	    int[] count = new int[256];
	    for(char c : arr) count[c]++;
	    
	    // count values and their corresponding letters
	    Map<Integer, List<Character>> map = new HashMap<>();
	    for(int i = 0; i < 256; i++){
	        if(count[i] == 0) continue;
	        int cnt = count[i];
	        if(!map.containsKey(cnt)){
	            map.put(cnt, new ArrayList<Character>());
	        }
	        map.get(cnt).add((char)i);
	    }

	    // loop throught possible count values
	    StringBuilder sb = new StringBuilder();
	    for(int cnt = arr.length; cnt > 0; cnt--){ 
	        if(!map.containsKey(cnt)) continue;
	        List<Character> list = map.get(cnt);
	        for(Character c: list){
	            for(int i = 0; i < cnt; i++){
	                sb.append(c);
	            }
	        }
	    }
	    return sb.toString();
	}
	
	/*//O(nLogn)
	public String frequencySort_3rdWay(String str) {
        if (str == null || str.length() <= 2) return str;
        Map<Character, Integer> map = new HashMap<>();
        char[] list = str.toCharArray();
        for (char c : list) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<>(str.length(), new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return map.get(c2) - map.get(c1);
            }
        });
        
        for (char c : map.keySet()) {
            heap.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            int count = map.get(c);
            for (int i = 0; i < count; ++i) sb.append(c);
        }
        return sb.toString();
}*/
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FrequencySorting frequencySorting = new FrequencySorting();
		//String result = frequencySorting.frequencySort("hhhccaazzeessqs");
		String result = frequencySorting.frequencySort_2ndWay("hhhccaazzeessqs");
		System.out.println(result);

	}

}
