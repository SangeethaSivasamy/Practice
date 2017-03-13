/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 *
 */
public class PurchaseItem {
	
	private static Boolean canBePurchased(int[] boxes, int target){
		
		int[] numWays = new int[target+1];
		for (int smallerTarget = 1; smallerTarget < numWays.length; smallerTarget++) {
			for (int box : boxes) {
				if(smallerTarget==box){
					numWays[smallerTarget] +=1;
				}else{
					if(box<smallerTarget){
						numWays[smallerTarget] +=numWays[smallerTarget-box];
					}
				}
			}
			
		}
		
		return numWays[target]!=0;
		
	}
	
	
	public static void main(String[] args) {
		int[] data = new int[]{6,9,20};
		Boolean flag = canBePurchased(data,21);
		System.out.println(flag);
	}

	
}







/*def canBePurchased(numSteps, numStairs):
	#print numSteps, numStairs
	numWays = [0] * (numStairs + 1)

	#numWays[0] = 0
	for stair in range(1, numStairs+1):
		for step in numSteps:
			if stair == step:
				numWays[stair] += 1
			else:
				if step < stair:
					numWays[stair] += numWays[stair - step]

	return numWays[numStairs] != 0


print canBePurchased([6, 9, 20], 21) == True
print canBePurchased([6, 9, 20], 6) == True
print canBePurchased([6, 9, 20], 9) == True
print canBePurchased([6, 9, 20], 20) == True
print canBePurchased([6, 9, 20], 10) == False*/

