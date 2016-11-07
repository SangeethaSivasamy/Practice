/**
 * 
 */

/**
 * @author sparida
 *
 */
public class StepsPossiblePathsRecur {
	
	public int poosibleWaysDyna(int n, int[] dyn) {

		if (n < 1) {
			return 0;
		}
		if (dyn[n] > 0) {
			return dyn[n];
		}
		dyn[n] = 1 + poosibleWaysDyna(n - 1, dyn) + poosibleWaysDyna(n - 2, dyn)
				+ poosibleWaysDyna(n - 3, dyn);
		return dyn[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		StepsPossiblePathsRecur s = new StepsPossiblePathsRecur();
		int[] dyn = new int[n + 1];
		System.out.println(s.poosibleWaysDyna(n, dyn));

	}

}
