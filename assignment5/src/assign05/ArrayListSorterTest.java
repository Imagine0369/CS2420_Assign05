package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArrayListSorterTest {
	
	final static int THRESHOLD = 0;
	
	//TEST GENERATE DESCENDING...
	
//--------------------------------Generate Descending Tests Begin------------------------------------
	
	
//--------------------------------Generate Descending Tests End--------------------------------------	
	
	
	
//--------------------------------Generate Ascending Tests Begin-------------------------------------
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
	
	
//--------------------------------Generate Ascending Tests End-------------------------------------
	
	
//--------------------------------Merge Sort Tests Begin-------------------------------------------
	@Test
	void TestEmptyMerge() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayListSorter.mergesort(arr);
		assertTrue(arr.isEmpty());
	}
	
	@Test
	void TestOneMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(1);
		ArrayListSorter.mergesort(arr);
		assertEquals(arr, ArrayListSorter.generateAscending(1));
	}
	
	@Test
	void TestTwoMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(2);
		ArrayListSorter.mergesort(arr);
		assertEquals(arr, ArrayListSorter.generateAscending(2));
	}
	
	@Test
	void TestThreeMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(3);
		ArrayListSorter.mergesort(arr);
		assertEquals(arr, ArrayListSorter.generateAscending(3));
	}
	
	@Test
	void TestFourMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(4);
		ArrayListSorter.mergesort(arr);
		assertEquals(arr, ArrayListSorter.generateAscending(4));
	}
	
	@Test
	void TestFiveMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(5);
		ArrayListSorter.mergesort(arr);
		assertEquals(arr, ArrayListSorter.generateAscending(5));
	}
	
	@Test
	void TestManyMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(100);
		ArrayListSorter.mergesort(arr);
		assertEquals(arr, ArrayListSorter.generateAscending(100));
	}
	
	@Test
	void TestOneMergeStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Mike");
		ArrayListSorter.mergesort(arr);
		assertEquals(arr, arr);
	}
	
	@Test
	void TestTwoMergeStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.mergesort(arr);
		
		assertEquals(arr, expected);
	}
	
	@Test
	void TestThreeMergeStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		arr.add("Apple");
		expected.add("Apple");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.mergesort(arr);
		
		assertEquals(arr, expected);
	}
	
	@Test
	void TestFourMergeStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		arr.add("Apple");
		arr.add("Ben");
		expected.add("Apple");
		expected.add("Ben");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.mergesort(arr);
		
		assertEquals(arr, expected);
	}
	
	@Test
	void TestFiveMergeStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		arr.add("Apple");
		arr.add("Ben");
		arr.add("Cameron");
		expected.add("Apple");
		expected.add("Ben");
		expected.add("Cameron");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.mergesort(arr);
		
		assertEquals(arr, expected);
	}
	
//--------------------------------Merge Sort Tests End-------------------------------------------
	
	
	
//--------------------------------Quick Sort Tests Begin-----------------------------------------
	
//	@Test
//	void EmptyQuick() {
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		ArrayListSorter.quicksort(arr);
//		assertTrue(arr.isEmpty());
//	}
	
	
//--------------------------------Quick Sort Tests End-----------------------------------------
	
}
