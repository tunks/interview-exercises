package dev.tunks.interview_exercise;

import java.util.HashMap;
import java.util.Map;

/****
 * Transform integers to words
 * 
 * @author ebrimatunkara
 ***/
public class TransformIntegerToString {
	private static int UNIT_ONE = 1;
	private static int UNIT_TEN = (int) Math.pow(10, 1);
	private static int UNIT_TWENTY = UNIT_TEN + UNIT_TEN;
	private static int UNIT_HUNDRED = (int) Math.pow(10, 2);
	private static int UNIT_THOUSAND = (int) Math.pow(10, 3);
	private static int UNIT_MILLION = (int) Math.pow(10, 6);
	private static int UNIT_BILLION = (int) Math.pow(10, 9);

	public static void main(String[] args) {
		int num = 2110;
		String result = figuresToWords(num);
		System.out.println("Int words: " + result);
	}

	public static String figuresToWords(int num) {
		Map<Integer, String> intUnits = getWordUnit();
		String result = getWord(intUnits, num);
		StringBuilder builder = new StringBuilder();

		if (result != null) {
			return builder.append(" ").append(result).toString();
		}

		int d = 0;
		int r = 0;
		int unit = 0;
		String seperator = "";
		do {
			if (num >= UNIT_ONE && num < UNIT_TWENTY) {
				d = 0;
				r = num % UNIT_TWENTY;
				unit = UNIT_ONE;
			} else if (num >= UNIT_TWENTY && num < UNIT_HUNDRED) {
				d = num / UNIT_TEN;
				r = num % UNIT_TEN;
				unit = UNIT_TEN;
			} else if (num >= UNIT_HUNDRED && num < UNIT_THOUSAND) {
				d = num / UNIT_HUNDRED;
				r = num % UNIT_HUNDRED;
				unit = UNIT_HUNDRED;
			} else if (num >= UNIT_THOUSAND && num < UNIT_MILLION) {
				d = num / UNIT_THOUSAND;
				r = num % UNIT_THOUSAND;
				unit = UNIT_THOUSAND;
			} else if (num >= UNIT_MILLION && num < UNIT_BILLION) {
				d = num / UNIT_MILLION;
				r = num % UNIT_MILLION;
				unit = UNIT_MILLION;
			} else {
				d = num / UNIT_BILLION;
				r = num % UNIT_BILLION;
				unit = UNIT_BILLION;
			}

			if (d != 0) {
				if (intUnits.containsKey(unit * d)) {
					result = (d == UNIT_ONE && unit >= UNIT_HUNDRED) ? getWord(intUnits, d) : null;
					appendToBuilder(builder, result);
					result = getWord(intUnits, unit * d);
					appendToBuilder(builder, result);
				} else {
					result = (intUnits.containsKey(d)) ? getWord(intUnits, d) : figuresToWords(d);
					appendToBuilder(builder, result);
					result = getWord(intUnits, unit);
					appendToBuilder(builder, result);
				}
			} else if (r != 0) {
				result = getWord(intUnits, r);
				appendToBuilder(builder, result);
			}

			num = r;
		} while (d != 0);

		return builder.toString();
	}

	private static String getWord(Map<Integer, String> intUnits, int n) {
		String result = null;
		result = intUnits.get(n);
		if (result == null) {

		}
		return result;
	}

	private static void appendToBuilder(StringBuilder builder, String... result) {
		if (result != null) {
			builder.append(" ");
			builder.append((result[0] != null) ? result[0] : "");
			builder.append((result.length > 1) ? " " + result[1] : "");
		}
	}

	private static Map<Integer, String> getWordUnit() {
		String unit1[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "tweleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen" };

		String unit2[] = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		String unit3[] = { "hundred", "thousand", "million", "billion" };

		Map<Integer, String> intUnits = new HashMap();
		// setup the hash units
		for (int i = 0; i < unit1.length; i++) {
			intUnits.put(i, unit1[i]);
		}

		int unit = 20;
		for (int i = 0; i < unit2.length; i++) {
			intUnits.put(unit, unit2[i]);
			unit += 10;
		}

		unit = 100;
		int k = 3;
		for (int i = 0; i < unit3.length; i++) {
			intUnits.put(unit, unit3[i]);
			unit = (int) Math.pow(10, k);
			k += 3;
		}
		return intUnits;
	}
}
