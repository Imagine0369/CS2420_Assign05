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
	@Test
	void testGenerateAscendingEmpty() {
		ArrayList<Integer> testArray = ArrayListSorter.generateAscending(0);
		ArrayList<Integer> empty = new ArrayList<Integer>();
		assertEquals(empty, testArray);
	}
	
	@Test
	void testGenerateAscendingNegative() {
		ArrayList<Integer> testArray = ArrayListSorter.generateAscending(-10);
		ArrayList<Integer> empty = new ArrayList<Integer>();
		assertEquals(empty, testArray);
	}
	
	@Test
	void testGenerateAscendingOne() {
		ArrayList<Integer> testArray = ArrayListSorter.generateAscending(1);
		ArrayList<Integer> oneArr = new ArrayList<Integer>();
		oneArr.add(1);
		assertEquals(oneArr, testArray);
	}
	
	@Test
	void testGenerateAscendingBig() {
		ArrayList<Integer> testArray = ArrayListSorter.generateAscending(1240);
		assertEquals(1240, testArray.size());
		for(int k = 1; k <= 1240; k++)
			assertEquals(k, testArray.get(k-1));
	}
}
