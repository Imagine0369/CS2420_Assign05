package assign05;

import java.util.ArrayList;

public class ArrayListSorter {	
	
	/**
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
		
		  //Copy contents from temp into arr
		  for(int m = 0; m < arr.size(); m++) {
			  arr.set(m,temp.get(m));
		  }
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
		int mergePos = start;

		  while (i <= mid && j <= end) {
		    if (arr.get(i).compareTo(arr.get(j)) <= 0)
		    	temp.set(mergePos++, arr.get(i++));
		    else
		    	temp.set(mergePos++,arr.get(j++));
		  }
		  
		  //Add the remaining contents of whichever side has leftovers
		  if(i > mid) {
			  for(int k = j; k < end; k++) {
				  temp.set(mergePos++, arr.get(k));
			  }
		  }
		  
		  else {
			  for(int l = i; l < end; l++) {
				  temp.set(mergePos++, arr.get(l));
			  }  
		  }
		  
		  System.out.println("temp progress: " + temp.toString());
	}
	
//	
//	
//	
//	
//	
//	
//	
//	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
//		
//	}
//	
//	
//	
//	
//	public static ArrayList<Integer> generateAscending(int size){
//		
//	}
//	
//	
//	public static ArrayList<Integer> generatePermuted(int size){
//		
//	}
//	
//	public static ArrayList<Integer> generateDescending(int size){
//		
//	}
	
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList();
		test.add(5);
		test.add(3);
		test.add(0);

		
		System.out.println("BEFORE: " + test.toString());
		mergesort(test);
		System.out.println("AFTER: " + test.toString());
	}

	
}
