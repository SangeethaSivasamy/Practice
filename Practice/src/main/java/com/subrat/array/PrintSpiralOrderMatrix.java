	/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sparida
 * 
 * https://www.youtube.com/watch?v=siKFOI8PNKM
 *
 */
public class PrintSpiralOrderMatrix {
	
	private static void printSpiral(int[][] arr, int m,int n){ //m is no of rows and n is no of columns
		
		int T=0,B=m-1,L=0,R=n-1,dir=0;
		while(T<=B && L<=R){
			if(dir==0){
				for (int i = L; i <=R; i++) {
					System.out.print(arr[T][i]);
					T++;
					//dir=1;
				}
			}else if(dir==1){
				for (int i = T; i <=B; i++) {
					System.out.print(arr[i][R]);
					R--;
					//dir=2;
				}
			}else if(dir==2){
				for (int i = R; i >= L; i--) {
					System.out.print(arr[B][i]);
					B--;
					//dir=3;
				}
			}else if(dir==3){
				for (int i = B; i >=T; i--) {
					System.out.print(arr[i][L]);
					L++;
					//dir=0;
					
				}
			}
			dir=(dir+1)%4;
		}
		
	}

    public static List<Integer> formSpiral(int[][] arr){

        int nRows = arr.length;
        int nCols = arr[0].length;
        List<Integer> result = new ArrayList<>();

        if(arr == null || arr.length == 0) 
        	return result;

        int top = 0;
        int bottom = nRows - 1;
        int left = 0;
        int right = nCols - 1;
        int dir = 0; // 0 - left to right, 1- top to bottom, 2 - right to left, 3 - bottom to up


        while (left <= right && top <= bottom){

            if (dir == 0){
                for (int i = left; i <= right; i++){
                    result.add(arr[top][i]);
                }
                top++;
            }

            if (dir == 1){
                for (int i = top; i <= bottom; i++){
                    result.add(arr[i][right]);
                }
                right--;
            }

            if (dir == 2){
                for (int i = right; i >= left; i--){
                    result.add(arr[bottom][i]);
                }
                bottom--;
            }

            if (dir == 3){
                for (int i = bottom; i >= top; i--){
                    result.add(arr[i][left]);
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }

        return result;
    }


    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        List<Integer> result = formSpiral(matrix);

        for (int i: result){
            System.out.print(i + "-");
        }

    }

}
