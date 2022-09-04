package CodeJam;

import java.util.*;

public class Pet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalCases = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= totalCases; i++) {
			int numPets = Integer.parseInt(scanner.nextLine());
			String[] petSizes = scanner.nextLine().split(" ");
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < petSizes.length; j++) {
				if (map.containsKey(petSizes[j])) {
					map.put(petSizes[j], map.get(petSizes) + 1);
				} else {
					map.put(petSizes[j], 1);
				}
			}
			Map<String, Integer> sortedMap = new TreeMap<>(map);
			int numTreats = 1;
			int sum = 0;
			for (Integer value: map.values()) {
				sum += numTreats * value;
				numTreats++;
			}
			System.out.println("Case #" + i + ": " + sum);
		}
		scanner.close();
	}
}
