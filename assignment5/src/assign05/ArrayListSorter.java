package assign05;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorter {	
	
	private final static int smallArrayThreshold = 30;
	
	/**
	 * Fill in here...
	 * @param <T>
	 * @param arr
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
		//Create temp ArrayList
		ArrayList<T> temp = new ArrayList<T>();
		
		//Ensure temp has right capacity
		for(int i = 0; i < arr.size(); i++) {
			temp.add(null);
		}
		System.out.println("THIS IS TEMP: " + temp.toString());
		
		mergesortRecursive(arr, temp, 0, arr.size()-1);
		 
	}
	
	private static <T extends Comparable<? super T>> void mergesortRecursive(ArrayList<T> arr, ArrayList<T> temp, int start, int end) {
		if(start >= end) {
			return;
			//Insertion Sort
		}
		
		  int mid = start + (end - start) / 2;
		  mergesortRecursive(arr, temp, start, mid);
		  mergesortRecursive(arr, temp, mid + 1, end);
		  merge(arr, temp, start, mid, end);
		
	}
	
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int start, int mid, int end) {
		int i = start; 
		int j = mid + 1; 
		int mergePos = start;//test

		  while (i <= mid && j <= end) {
		    if (arr.get(i).compareTo(arr.get(j)) <= 0)
		    	temp.set(mergePos++, arr.get(i++));
		    else
		    	temp.set(mergePos++,arr.get(j++));
		  }
		  
		  //Add the remaining contents of whichever side has leftovers
		  if(i > mid) {
			  for(int k = j; k <= end; k++) {
				  temp.set(mergePos++, arr.get(k));
			  }
		  }
		  
		  else {
			  for(int l = i; l <= mid; l++) {
				  temp.set(mergePos++, arr.get(l));
			  }  
		  }
		  
		  System.out.println("temp progress: " + temp.toString());
		  for(int m = start; m <= end; m++) {
			  arr.set(m,temp.get(m));
		  }
	}
	
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
		quicksortRecursive(arr, 0, arr.size()-1 );
	}
	
	private static <T extends Comparable<? super T>> void quicksortRecursive(ArrayList<T> arr, int leftBound, int rightBound) {
		
		if (leftBound < rightBound) {
			int partitionIndex = partition(arr, leftBound, rightBound);
			
			//partition left half
			quicksortRecursive(arr, leftBound, partitionIndex-1);
			//partition right half
			quicksortRecursive(arr, partitionIndex+1, rightBound);
			
		}//end if

	}
	
	private static <T extends Comparable<? super T>> int partition(ArrayList<T> arr, int leftBound, int rightBound ) {
		int L = leftBound;
		int R = rightBound - 1;
		
		int pivotIndex = findPivotLeft(arr, leftBound, rightBound);
		T pivot = arr.get(pivotIndex);
		swapReferences(arr, rightBound, pivotIndex);

		while(L <= R){
		  while(L < rightBound && ( arr.get(L).compareTo(pivot) <= 0 ) ) {
			  L++;  
		  }
		  while(R >= leftBound && ( arr.get(R).compareTo(pivot) >= 0) ) {
			  R--;  
		  }

		  if(L < R)
			  swapReferences(arr, L, R);
		}
		//adds pivot back in
		swapReferences(arr, L, rightBound);
		return L;
	}
	
	private static <T> void swapReferences(ArrayList<T> arr, int leftSwitchIndex, int rightSwitchIndex ) {
		T temp = arr.get(leftSwitchIndex);
		arr.set( leftSwitchIndex, arr.get(rightSwitchIndex));
		arr.set( rightSwitchIndex, temp);
	}
	
	private static <T> int findPivotRight(ArrayList<T> arr, int leftBound, int rightBound) {
		return rightBound;
	}
	
	private static <T> int findPivotLeft(ArrayList<T> arr, int leftBound, int rightBound) {
		return leftBound;
	}
	
	private static <T> int findPivotMiddle(ArrayList<T> arr, int leftBound, int rightBound) {
		int middle = leftBound + (rightBound - leftBound)/2;
		return middle;
	}
	
	private static <T> T findPivotBetter(ArrayList<T> arr, int leftBound, int rightBound) {
		//random generate 3 indexes from within bounds
		//average the 3 indexes
		//return the average of the 3 indexes
		return arr.get(leftBound);
	}
//	
//	
	public static ArrayList<Integer> generateAscending(int size){
		ArrayList<Integer> ascendingList = new ArrayList<Integer>();
		
		for(int i = 1; i <= size; i++) {
			ascendingList.add(i);
		}
		
		return ascendingList;
	}
//	
//	
	public static ArrayList<Integer> generatePermuted(int size){
		ArrayList<Integer> shuffledArray = generateAscending(size);
		Collections.shuffle(shuffledArray);
		return shuffledArray;
	}
//	
	public static ArrayList<Integer> generateDescending(int size){
		ArrayList<Integer> descendingArray = new ArrayList<>;
		for(int k = 0; k < size; k++) {
			descendingArray.add(size-k);
		}
		return descendingArray;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList();
		test.add(5);
		test.add(3);
		test.add(0);
		test.add(6);
		test.add(-2);
		test.add(2);
		test.add(1);
		
		test.add(0);
		test.add(3);
		test.add(2);
		test.add(1);

		
		System.out.println("BEFORE: " + test.toString());
		mergesort(test);
		System.out.println("AFTER: " + test.toString());
	}

	
}
