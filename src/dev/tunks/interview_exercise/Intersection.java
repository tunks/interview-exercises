package dev.tunks.interview_exercise;

/*
 * 1. Intersection of 2 sorted arrays
 * **/
public class Intersection {

	public static void main(String[] args) {
		int arr1[] = { 1, 5, 6, 7, 8, 9, 20, 21, 23 };
		int arr2[] = { 2, 3, 6, 8, 9, 10, 18, 23 };
		Intersection intersect = new Intersection();
		int count = intersect.countIntersections(arr1, arr2);
		System.out.println("\n Number of intersections: " + count);
	}

	public int countIntersections(int arr1[], int arr2[]) {
		int i = 0;
		int j = 0;
		int count = 0;

		// Find intersections
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				System.out.print(" " + arr1[i]);
				i++;
				j++;
				count++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else
				j++;
		}

		return count;
	}

}
