/**
 * 
 */
package com.subrat.practice.sorting;

/**
 * @author sparida
 *
 */
public class QuickSortPractice2nd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//QuickSortPractice2nd sorting = new QuickSortPractice2nd();
		String result =QuickSortPractice2nd.sortCharacters("edbcfd");
		System.out.println(result);

	}

	static String sortCharacters(String inString) {
        if(inString.length()==0 || inString.length()==1){
            return inString;
        }
        
        int start = 0;
        int end = inString.length()-1;
        String sorting = sorting(inString,start,end);
		return sorting;
        
    }

static String sorting(String inString,int start,int end){
    if(start<end){
        int partitionIndex = partitionIndex(inString,start,end);
        sorting(inString,start,partitionIndex-1);
        sorting(inString,partitionIndex+1,end);
        System.out.println(inString);
        }
	return inString;
}

static int partitionIndex(String string, int start, int end){
    char[] array = string.toCharArray();
    char pivot = array[end];
    int i=start;
    for(int j=start;j<=end-1;j++){
        if(array[j]<pivot){
            char temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            i++;
        }
    }
    array[end] = array[i];
    array[i] = pivot;
    return i;
}
}
