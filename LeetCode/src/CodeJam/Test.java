package CodeJam;

import java.util.Scanner;

public class Test {

	private static void ioInterpreter(int caseNum, String input) {
		int count = 0;
		int iCounter = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'I') {
				iCounter++;
			}
			if (input.charAt(i) == 'O' && iCounter > 0) {
				iCounter--;
				count++;
			}
		}
		System.out.println("Case #" + caseNum + ": " + count);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println(args.length);
//		for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
//			ioInterpreter(i, args[i]);
//		}
//
//		while (scanner.hasNextLine()) {
//			String line = scanner.nextLine();
//			if (counter > 0) {
//				ioInterpreter(counter, line);
//			}
//			counter++;
//		}
//		scanner.close();
	}
}
