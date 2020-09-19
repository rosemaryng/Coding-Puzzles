package Arrays;

public class MaxXORof2Nums {
	public int findMaximumXORON2(int[] nums) {
		int max = 0;

		// Calculating xor of each pair
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				max = Math.max(max,
								nums[i] ^ nums[j]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("abd", "abc"));
	}
}
