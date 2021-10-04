package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArrayListSorterTest {
	
	final static int THRESHOLD = 0;
	
	//TEST GENERATE DESCENDING...
	//TEST GENERATE ASCENDING

	@Test
	void EmptyMerge() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayListSorter.mergesort(arr);
		assertTrue(arr.isEmpty());
	}
	
//	@Test
//	void EmptyQuick() {
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		ArrayListSorter.quicksort(arr);
//		assertTrue(arr.isEmpty());
//	}
	
	@Test
	void OneMerge() {
		ArrayList<Integer> arr = ArrayListSorter.generateDescending(1);
		ArrayListSorter.mergesort(arr);
		assertTrue(arr.isEmpty());
	}
	
	//TEST 2Merge 2Quick etc.

}
