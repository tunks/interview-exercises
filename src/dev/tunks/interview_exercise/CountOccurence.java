package dev.tunks.interview_exercise;

public class CountOccurence {
	public static void main(String[] args) {
		int target = 3;
		int[] nums = { 1, 2, 2, 2, 3, 4, 4, 5, 5, 6, 7, 8 };
		int count = countOccurence(nums, target);
		System.out.println("Target {" + target + "} count : " + count);
	}

	public static int countOccurence(int[] nums, int target) {
		return count(nums, target, 0, nums.length - 1);
	}

	private static int count(int[] nums, int target, int start, int end) {
		int mid = (end - start) / 2;
		System.out.println("mid: " + mid + ", start " + start + " end :" + end);

		if (start > end) {
			return 0;
		} else {
			int result = (nums[mid] == target) ? 1 : 0;
			if (nums[mid] == target) {
				return result + count(nums, target, start, mid - 1) + count(nums, target, mid + 1, end);
			} else if (nums[mid] < target) {
				return result + count(nums, target, start, mid - 1);
			} else {
				return result + count(nums, target, mid + 1, end);
			}
		}

	}
}
