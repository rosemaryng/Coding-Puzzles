package CodeJam;
import java.io.*;


import java.util.*;


public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalCases = Integer.parseInt(scanner.nextLine());
//		System.out.println(totalCases);
		for (int i = 1; i <= totalCases; i++) {
			int numPets = Integer.parseInt(scanner.nextLine());
			String[] petSizes = scanner.nextLine().split(" ");
//			System.out.println(Arrays.asList(petSizes));
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < petSizes.length; j++) {
				System.out.println(petSizes[j]);
				map.put(Integer.parseInt(petSizes[j]), map.get(Integer.parseInt(petSizes[j])) == null ? 1 : map.get(Integer.parseInt(petSizes[j])) + 1);
			}
			Map<Integer, Integer> sortedMap = new TreeMap<>(map);
//			System.out.println();
			int numTreats = 1;
			int sum = 0;
			for (Integer value: sortedMap.values()) {
				sum += numTreats * value;
				numTreats++;
			}
			System.out.println("Case #" + i + ": " + sum);
		}
		scanner.close();
	}
}



//public class Solution {
//
//	private static void ioInterpreter(int caseNum, String input) {
//		int count = 0;
//		int iCounter = 0;
//		for (int i = 0; i < input.length(); i++) {
//			if (input.charAt(i) == 'I') {
//				iCounter++;
//			}
//			if (input.charAt(i) == 'O' && iCounter > 0) {
//				iCounter--;
//				count++;
//			}
//		}
//		System.out.println("Case #" + caseNum + ": " + count);
//	}
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int counter = 0;
//		while (scanner.hasNextLine()) {
//			String line = scanner.nextLine();
//			if (counter > 0) {
//				ioInterpreter(counter, line);
//			}
//			counter++;
//		}
//		scanner.close();
//	}
//}