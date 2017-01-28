/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class NutsAndBoltsMatch2ndWay {

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		char[] nuts = new char[]{'@', '#', '$', '%', '^', '&'};
        char[] bolts = new char[]{'$', '%', '&', '^', '@', '#'};

        nutsBolts(nuts, bolts);
        
        printArray(nuts);
        printArray(bolts);
	}
	
    private static void nutsBolts(char[] nuts, char[] bolts) {
        if ( nuts == null || bolts == null ) return;
        
        // to print the elements in the following order ! # $ % & * @ ^ ~ 
        char[] order = new char[]{'!', '#', '$', '%', '&', '*', '@', '^'};
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        // Add nuts and bolts to map
        addToMap(nuts, map);
        addToMap(bolts, map);

        int index = 0;
        for (char ch : order) {
            Integer count = map.get(ch);
            // problem states, no duplicates allowed in either nuts or bolts
            // so we can assume that if there is a match, there will be 
            // total of 2 instances
            if (count != null && count == 2) {
                nuts[index] = bolts[index] = ch;
                index++;
            }
        }

    }
    
    private static void addToMap(char[] A, Map<Character, Integer> map) {
        for (char ch : A) {
            Integer count = map.get(ch);
            if (count == null) {
                count = 0;
            }
            map.put(ch, count + 1);
        }
    }
    
    private static void printArray(char [] A) { 
        for ( char ch : A ) System.out.print(ch + " ");
        System.out.println("");
    }
}
