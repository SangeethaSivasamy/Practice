/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 * https://www.youtube.com/watch?v=ZzpJgRvqSJQ
 * Given a boolean matrix, update it so that if any cell is true, all the cells in that row and column are true.
 *    [true,  false, false]      [true,  true,  true ]
	  [false, false, false]  ->  [true,  false, false]
      [false, false, false]      [true,  false, false]
 *
 */
public class ZeroMatrix {

	
	public static void main(String[] args) {
		Boolean[][] array=new Boolean[][]{
				{true, false, false},
				{false, false, false},
				{false, false, true}
		};
		ZeroMatrix zeroMatrix = new ZeroMatrix();
		zeroMatrix.zeroMatrix(array);
		
	}

	private void zeroMatrix(Boolean[][] array) {
		// Verify the input array is nonzero
		if(array==null || array.length==0 || array[0].length==0){
			return;
		}
		
		boolean zeroRow=false;
		boolean zeroColumn=false;
		// Determine whether the first row or first column is true
		for (Boolean booleanValue : array[0]) {
			zeroRow |=booleanValue;
		}
		
		for (Boolean[] booleanValue : array) {
			zeroColumn |=booleanValue[0];
		}
		// For each cell not in the first row/column, if it is true, set the 
        // cell in the first row/same column and first column/same row to be 
        // true
		for(int i=1;i<array.length;i++){
			for(int j=1; j<array[0].length;j++){
				if(array[i][j]){
					array[i][0]=true;
					array[0][j]=true;
				}
				
			}
		}
		
		// Go through the first column and set each row to true where cell in
        // the first column is true
        for (int i = 1; i < array.length; i++) {
            if (array[i][0]) {
                for (int j = 1; j < array[i].length; j++) {
                	array[i][j] = true;
                }
            }
        }
        
        // Repeat for the rows
        for (int j = 1; j < array[0].length; j++) {
            if (array[0][j]) {
                for (int i = 1; i < array.length; i++) {
                	array[i][j] = true;
                }
            }
        }
     // Set first row/column to true if necessary
        if (zeroRow) {
            for (int i = 0; i < array[0].length; i++) {
            	array[0][i] = true;
            }
        }
        
        if (zeroColumn) {
            for (int i = 0; i < array.length; i++) {
            	array[i][0] = true;
            }
        }
		
	}

}
