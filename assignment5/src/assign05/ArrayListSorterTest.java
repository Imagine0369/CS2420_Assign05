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
		assertEquals(ArrayListSorter.generateAscending(1), arr);
	}
	
	@Test
	void TestTwoMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(2);
		ArrayListSorter.mergesort(arr);
		assertEquals(ArrayListSorter.generateAscending(2), arr);
	}
	
	@Test
	void TestThreeMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(3);
		ArrayListSorter.mergesort(arr);
		assertEquals(ArrayListSorter.generateAscending(3), arr);
	}
	
	@Test
	void TestFourMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(4);
		ArrayListSorter.mergesort(arr);
		assertEquals(ArrayListSorter.generateAscending(4), arr);
	}
	
	@Test
	void TestFiveMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(5);
		ArrayListSorter.mergesort(arr);
		assertEquals(ArrayListSorter.generateAscending(5), arr);
	}
	
	@Test
	void TestManyMergeIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(100);
		ArrayListSorter.mergesort(arr);
		assertEquals(ArrayListSorter.generateAscending(100), arr);
	}
	
	@Test
	void TestAlreadySortedIntegersMerge() {
		ArrayList<Integer> arr = ArrayListSorter.generateAscending(100);
		ArrayListSorter.mergesort(arr);
		assertEquals(ArrayListSorter.generateAscending(100), arr);
	}
	
	@Test
	void TestDescendingIntegersMerge() {
		ArrayList<Integer> arr = ArrayListSorter.generateDescending(10);
		ArrayListSorter.mergesort(arr);
		assertEquals(ArrayListSorter.generateAscending(10), arr);
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
		
		assertEquals(expected, arr);
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
		
		assertEquals(expected, arr);
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
		
		assertEquals(expected, arr);
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
		
		assertEquals(expected, arr);
	}
	
	@Test
	void TestAlreadySortedMergeStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Apple");
		arr.add("Ben");
		arr.add("Cameron");
		arr.add("Mike");
		arr.add("Seth");
		expected.add("Apple");
		expected.add("Ben");
		expected.add("Cameron");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.mergesort(arr);
		
		assertEquals(expected, arr);
	}
	
	@Test
	void TestDescendingMergeStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		arr.add("Cameron");
		arr.add("Ben");
		arr.add("Apple");
		expected.add("Apple");
		expected.add("Ben");
		expected.add("Cameron");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.mergesort(arr);
		
		assertEquals(expected, arr);
	}
	
//--------------------------------Merge Sort Tests End-------------------------------------------
	
	
	
//--------------------------------Quick Sort Tests Begin-----------------------------------------
	
	@Test
	void EmptyQuick() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayListSorter.quicksort(arr);
		assertTrue(arr.isEmpty());
	}
	
	@Test
	void TestOneQuickIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(1);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(1), arr);
	}
	
	@Test
	void TestTwoQuickIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(2);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(2), arr);
	}
	
	@Test
	void TestThreeQuickIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(3);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(3), arr);
	}
	
	@Test
	void TestFourQuickIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(4);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(4), arr);
	}
	
	@Test
	void TestFiveQuickIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(5);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(5), arr);
	}
	
	@Test
	void TestManyQuickIntegers() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(100);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(100), arr);
	}
	
	@Test
	void TestAlreadySortedIntegersQuick() {
		ArrayList<Integer> arr = ArrayListSorter.generateAscending(10);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(10), arr);
	}
	
	@Test
	void TestDescendingIntegersQuick() {
		ArrayList<Integer> arr = ArrayListSorter.generateDescending(10);
		ArrayListSorter.quicksort(arr);
		assertEquals(ArrayListSorter.generateAscending(10), arr);
	}
	
	@Test
	void TestOneQuickStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Mike");
		ArrayListSorter.quicksort(arr);
		assertEquals(arr, arr);
	}
	
	@Test
	void TestTwoQuickStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.quicksort(arr);
		
		assertEquals(expected, arr);
	}
	
	@Test
	void TestThreeQuickStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		arr.add("Apple");
		expected.add("Apple");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.quicksort(arr);
		
		assertEquals(expected, arr);
	}
	
	@Test
	void TestFourQuickStrings() {
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
		ArrayListSorter.quicksort(arr);
		
		assertEquals(expected, arr);
	}
	
	@Test
	void TestFiveQuickStrings() {
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
		ArrayListSorter.quicksort(arr);
		
		assertEquals(expected, arr);
	}
	
	@Test
	void TestAlreadySortedQuickStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Apple");
		arr.add("Ben");
		arr.add("Cameron");
		arr.add("Mike");
		arr.add("Seth");
		expected.add("Apple");
		expected.add("Ben");
		expected.add("Cameron");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.quicksort(arr);
		
		assertEquals(expected, arr);
	}
	
	@Test
	void TestDescendingQuickStrings() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		arr.add("Seth");
		arr.add("Mike");
		arr.add("Cameron");
		arr.add("Ben");
		arr.add("Apple");
		expected.add("Apple");
		expected.add("Ben");
		expected.add("Cameron");
		expected.add("Mike");
		expected.add("Seth");
		ArrayListSorter.quicksort(arr);
		
		assertEquals(expected, arr);
	}
	
	
//--------------------------------Quick Sort Tests End-----------------------------------------
	
}
