/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class SquareRootOfNumber {
	
	public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SquareRootOfNumber root = new SquareRootOfNumber();
		int result = root.mySqrt(18);
		System.out.println(result);

	}

}
