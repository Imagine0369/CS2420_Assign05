package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class utilizes mergesort and quicksort algorithms to sort arrays of any
 * type.
 * 
 * @author Mike Phelps and Seth Polevoi
 *
 */
public class ArrayListSorter {

	private final static int smallArrayThreshold = 30;

	/**
	 * This is the mergesort method that users would actually interact with. It
	 * takes in the array to be sorted, creates the temp array to be used in
	 * mergesortRecursive, and passes the start and end values need for
	 * mergesortRecursive.
	 * 
	 * @param <T>
	 * @param arr generic array to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
		// Create temp ArrayList
		ArrayList<T> temp = new ArrayList<T>();

		// Ensure temp has right capacity
		for (int i = 0; i < arr.size(); i++) {
			temp.add(null);
		}
		// Call mergesortRecursive
		mergesortRecursive(arr, temp, 0, arr.size() - 1);

	}

	/**
	 * Sorts an array of generic type T using insertion sort. This version of
	 * insertion sort is adapted to only sort the sub-array defined by start and
	 * end. The sub-array will be divided into two sections, a sorted section and an
	 * unsorted section. The sorted section will ultimately grow to the size of the
	 * entire array/sub-array by inserting each value from the unsorted section into
	 * the proper position within the sorted section. The proper ordering of
	 * elements is determined by comparable.
	 * 
	 * @param <T>
	 * @param arr   array to be sorted
	 * @param start the index where the sub-array starts
	 * @param end   the index where the sub-array ends
	 */
	private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> arr, int start, int end) {

		// loop through unsorted section of array
		for (int i = start; i <= end; i++) {
			// Set key to first value in unsorted array
			T key = arr.get(i);
			// Compare it to each value in the sorted array.
			// Place it in a position where it is greater than the value to its left
			// But less than the value to its right. (Or at the lowest index if it is the
			// smallest value in the sorted section
			while (i != start && key.compareTo(arr.get(i - 1)) < 0) {
				arr.set(i, arr.get(i - 1));
				i--;
			}
			arr.set(i, key);
		}
	}

	/**
	 * This method recursively calls itself in order to divide an array into smaller
	 * and smaller sub-arrays. Once a sub-array becomes smaller than our threshold
	 * value, this method will utilize insertion sort to sort the sub array and
	 * return. Once the base case returns the process of merging begins. This
	 * process is repeated until an entire array is sorted.
	 * 
	 * @param <T>
	 * @param arr   array to be sorted
	 * @param temp  array used for carrying merged values at their final position
	 * @param start beginning index of sub-array
	 * @param end   final index of sub-array
	 */
	private static <T extends Comparable<? super T>> void mergesortRecursive(ArrayList<T> arr, ArrayList<T> temp,
			int start, int end) {
		// Checks if sub-array is smaller than our threshold value. If it is, insertion
		// sorts
		// the sub array and returns. (BASE CASE)
		if ((start - end) < smallArrayThreshold) {
			insertionSort(arr, start, end);
			return;
		}

		int mid = start + (end - start) / 2;
		// Recursive call to split first half of array
		mergesortRecursive(arr, temp, start, mid);
		// Recursive call used to split second half of array
		mergesortRecursive(arr, temp, mid + 1, end);
		// Method used to combine two array halves
		merge(arr, temp, start, mid, end);

	}

	/**
	 * This method
	 * 
	 * @param <T>
	 * @param arr   array to be sorted
	 * @param temp  array to hold the newly merged values
	 * @param start beginning index of sub-array
	 * @param mid   middle index of sub-array
	 * @param end   final index of sub-array
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int start, int mid,
			int end) {
		int i = start;
		int j = mid + 1;
		int mergePos = start;

		// compare each value in the sub-arrays and place the smaller values in temp
		// array at mergePos
		// (mergePos starts at 0 and increments every time an item is added to temp).
		// if a value from a sub-array is added, increment the index pointer (i or j)
		// used for that sub-array. Continue that process until one of the pointers has
		// looked at
		// all values in its respective sub-array.
		while (i <= mid && j <= end) {
			if (arr.get(i).compareTo(arr.get(j)) <= 0)
				temp.set(mergePos++, arr.get(i++));
			else
				temp.set(mergePos++, arr.get(j++));
		}

		// If all values in left side have been added to temp, add the rest of the
		// values
		// from the right side to temp.
		if (i > mid) {
			for (int k = j; k <= end; k++) {
				temp.set(mergePos++, arr.get(k));
			}
		}
		// If all values in the right side have been added to temp, add the rest of the
		// values
		// from the left side to temp.
		else {
			for (int l = i; l <= mid; l++) {
				temp.set(mergePos++, arr.get(l));
			}
		}
		// copy temp values to arr
		for (int m = start; m <= end; m++) {
			arr.set(m, temp.get(m));
		}
	}

	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
		quicksortRecursive(arr, 0, arr.size() - 1);
	}

	private static <T extends Comparable<? super T>> void quicksortRecursive(ArrayList<T> arr, int leftBound,
			int rightBound) {

		if (leftBound < rightBound) {
			int partitionIndex = partition(arr, leftBound, rightBound);

			// partition left half
			quicksortRecursive(arr, leftBound, partitionIndex - 1);
			// partition right half
			quicksortRecursive(arr, partitionIndex + 1, rightBound);

		} // end if

	}

	private static <T extends Comparable<? super T>> int partition(ArrayList<T> arr, int leftBound, int rightBound) {
		int L = leftBound;
		int R = rightBound - 1;

		// select a pivot
		int pivotIndex = findPivotBetter(arr, leftBound, rightBound);
		T pivot = arr.get(pivotIndex);

		// swap pivot to far right position
		swapReferences(arr, rightBound, pivotIndex);

		// find elements to swap locations
		while (L <= R) {
			while (L < rightBound && (arr.get(L).compareTo(pivot) <= 0)) {
				L++;
			}
			while (R >= leftBound && (arr.get(R).compareTo(pivot) >= 0)) {
				R--;
			}

			if (L < R)
				swapReferences(arr, L, R);
		}

		// adds pivot back in
		swapReferences(arr, L, rightBound);
		return L;
	}

	/**
	 * Switches two elements in a generic ArrayList
	 * 
	 * @param <T>              generic type
	 * @param arr              array list where all the data is
	 * @param leftSwitchIndex  index of element on the left that needs to switch
	 * @param rightSwitchIndex index of element on the right that needs to switch
	 */
	private static <T> void swapReferences(ArrayList<T> arr, int leftSwitchIndex, int rightSwitchIndex) {
		T temp = arr.get(leftSwitchIndex);
		arr.set(leftSwitchIndex, arr.get(rightSwitchIndex));
		arr.set(rightSwitchIndex, temp);
	}

	private static <T> int findPivotRight(ArrayList<T> arr, int leftBound, int rightBound) {
		return rightBound;
	}

	private static <T> int findPivotLeft(ArrayList<T> arr, int leftBound, int rightBound) {
		return leftBound;
	}

	private static <T> int findPivotMiddle(ArrayList<T> arr, int leftBound, int rightBound) {
		int middle = leftBound + (rightBound - leftBound) / 2;
		return middle;
	}

	private static <T extends Comparable<? super T>> int findPivotBetter(ArrayList<T> arr, int leftBound,
			int rightBound) {
		// random generate 3 indexes from within bounds
		Random generator = new Random();
		int index1 = generator.nextInt(rightBound - leftBound) + leftBound;
		int index2 = generator.nextInt(rightBound - leftBound) + leftBound;
		int index3 = generator.nextInt(rightBound - leftBound) + leftBound;

		// add the values of each index into an ArrayList
		ArrayList<T> values = new ArrayList<T>();
		values.add(arr.get(index1));
		values.add(arr.get(index2));
		values.add(arr.get(index3));

		// sort the values
		insertionSort(values, 0, 2);

		// return the index that matches the middle value of the sorted array
		if (values.get(1).compareTo(arr.get(index1)) == 0) {
			return index1;
		} else if (values.get(1).compareTo(arr.get(index2)) == 0) {
			return index2;
		} else {
			return index3;
		}
	}

//	
//	
	/**
	 * Generates an ascending ArrayList of Integers from 1 to size
	 * 
	 * @param size the peak value that all numbers ascend to
	 * @return an ArrayList of ascending integers
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		// ArrayList that will hold ascending values
		ArrayList<Integer> ascendingList = new ArrayList<Integer>();

		// Add ascending values to ascendingList starting at 1, going to size (including
		// size)
		for (int i = 1; i <= size; i++) {
			ascendingList.add(i);
		}

		return ascendingList;
	}

	/**
	 * Generates an ArrayList of numbers between 1 and size in a random order.
	 * 
	 * @param size highest number in permuted ArrayList
	 * @return ArrayList of numbers from 1 to size in a random order
	 */
	public static ArrayList<Integer> generatePermuted(int size) {
		// Create ArrayList of ascending integers from 1 to size
		ArrayList<Integer> shuffledArray = generateAscending(size);
		// Shuffle the index locations of the ascending array
		Collections.shuffle(shuffledArray);
		// return the shuffled array
		return shuffledArray;
	}

	/**
	 * Generates an ArrayList of numbers in descending order from size to 1.
	 * 
	 * @param size beginning number to descend from
	 * @return ArrayList of integers in descending order
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		// Create ArrayList to hold descending integers
		ArrayList<Integer> descendingArray = new ArrayList<Integer>();
		// Add numbers to ArrayList starting with 7, moving towards 1.
		for (int k = 0; k < size; k++) {
			descendingArray.add(size - k);
		}
		// return array of descending integers
		return descendingArray;
	}

}
