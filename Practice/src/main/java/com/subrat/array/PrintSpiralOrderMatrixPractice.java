/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sparida
 *
 */
public class PrintSpiralOrderMatrixPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },{10,11,12}};

		List<Integer> list = printSpiral(input);
		for(Integer data: list){
			System.out.print(data);
		}

	}

	private static List<Integer> printSpiral(int[][] input) {
		List<Integer> result = new ArrayList<Integer>();
		if (input == null || input.length == 0) {
			return result;
		}
		int left = 0;
		int right = input[0].length - 1;
		int top = 0;
		int bottom = input.length - 1;
		int dir = 0;
		while (left <= right && top <= bottom) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					result.add(input[top][i]);
				}
				top++;
			}
			if(dir==1){
				for(int i=top;i<=bottom;i++){
					result.add(input[i][right]);
				}
				right--;
				
			}
			
			if(dir==2){
				for(int i=right;i>=left;i--){
					result.add(input[bottom][i]);
				}
				bottom--;
			}
			if(dir==3){
				for(int i=bottom;i>=top;i--){
					result.add(input[i][left]);
				}
				left++;
			}
			
			dir=(dir+1)%input.length;
		}
		return result;
	}

}
