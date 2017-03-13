import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author sparida
 * 
 *         A certain item can be purchased in boxes of 6, 9, or 20. Write a
 *         function that, given an integer n, returns whether exactly n items
 *         can be purchased.
 * 
 *         Examples:
 * 
 *         f(6) = true 
 *         f(9) = true 
 *         f(20) = true 
 *         f(21) = true (two boxes of 6 and one box of 9) 
 *         f(1) = false 
 *         f(10) = false
 *
 */
public class FindCorrectItem {

	private static Set<Integer> set = new HashSet<>();

	static {

		set.add(6);

		set.add(9);

		set.add(20);

	}

	static Map<Integer, Boolean> map = new HashMap<>();

	public static void main(String[] args) {

		// change this value and test for different input

		int target = 21;

		for (int i = 1; i <= target; i++) {

			boolean found = false;

			for (int j = 1; j <= i; j++) {

				int rest = i - j;

				if (rest == 0 && (map.containsKey(j) || set.contains(j))) {

					map.put(j, true);

					found = true;

					break;

				} else if (rest != 0 && isValid(j) && isValid(rest)) {

					map.put(i, true);

					found = true;

					break;

				}

			}

			if (!found) {

				map.put(i, false);

			}

		}

		boolean result = map.get(target);

		System.out.println(result);

	}

	private static boolean isValid(int i) {

		return set.contains(i) || (map.get(i) != null && map.get(i) == true);

	}

}