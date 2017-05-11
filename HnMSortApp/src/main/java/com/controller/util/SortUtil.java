package com.controller.util;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.controller.model.SortDataInfo;
import com.controller.model.SortItem;

/**
 * This is the utility class for the sort functionalities
 * @author Tayab Hussain
 * @version 1.0
 */
@Repository
public class SortUtil {

	/**
	 * int variable to hold the the length of the arary
	 */
	private int lengthOfArray;
	/**
	 * int variable to hold the count of movements while doing the sort
	 */
	private int shuffleCount;
	/**
	 * This array contains the sorted output
	 */
	private int[] sortedNumberArray;
	/**
	 * this variable holds the start time of the sorting algorithm, time is
	 * stored in nano seconds
	 */
	private long startTime;
	/**
	 * this variable holds the end time of the sorting algorithm, time is stored
	 * in nano seconds
	 */
	private long endTime;

	/**
	 * Sorts the given input array list, and stores the output in the
	 * SortDataInfo object
	 * @param inputArray
	 * @return SortDataInfo - this object contains various information related
	 *  	to the sort e.g. sorted output, time, shuffles
	 */
	public SortDataInfo sort(int[] inputArray) {
		SortDataInfo sortDataInfoBean = null;
		sortedNumberArray = Arrays.copyOf(inputArray, inputArray.length);
		if (sortedNumberArray == null || sortedNumberArray.length == 0) {
			sortDataInfoBean = null;
		} else {
			lengthOfArray = sortedNumberArray.length;
			shuffleCount = 0;
			startTime = System.nanoTime();
			quickSort(0, lengthOfArray - 1);
			endTime = System.nanoTime();

			sortDataInfoBean = new SortDataInfo();
			sortDataInfoBean.setOriginaNumberArray(convertNumberArrayToString(inputArray));
			sortDataInfoBean.setSortedNumberArray(convertNumberArrayToString(sortedNumberArray));
			sortDataInfoBean.setShuffleCount(shuffleCount);
			sortDataInfoBean.setTotalTimeConsumed(endTime - startTime);
		}
		return sortDataInfoBean;
	}

	/**
	 * This is the implementation of the quick sort
	 * @param lowerIndex
	 * @param higherIndex
	 */
	private void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		/* calculate pivot number here middle index number is taken as pivot */
		int pivot = sortedNumberArray[lowerIndex + (higherIndex - lowerIndex) / 2];
		/* Divide the array into two arrays */
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (sortedNumberArray[i] < pivot) {
				i++;
			}
			while (sortedNumberArray[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				i++;
				j--;
			}
		}
		/* call quickSort() method recursively */
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	/**
	 * This methods exchanges the position of two elements in the array, used in
	 * quick sort
	 * @param i
	 * @param j
	 */
	private void exchangeNumbers(int i, int j) {
		int temp = sortedNumberArray[i];
		sortedNumberArray[i] = sortedNumberArray[j];
		sortedNumberArray[j] = temp;
		shuffleCount++;
	}

	/**
	 * This method accepts the list of numbers and produces the array of numbers
	 * this array is used in quick sort, as array are faster than the list
	 * @param sortItemList
	 * @return array of numbers
	 */
	public static int[] getArrayOfNumberFromItemList(List<SortItem> sortItemList) {

		int[] inputNumberArray;
		int itemListSize;
		int index = 0;

		itemListSize = sortItemList.size();
		inputNumberArray = new int[itemListSize];

		for (SortItem item : sortItemList) {
			inputNumberArray[index] = Integer.parseInt(item.getValue());
			index++;
		}
		return inputNumberArray;
	}

	/**
	 * This method accepts a array of numbers and generates an string of
	 * concatenated numbers separated by column this is required to persist the
	 * information int the database
	 * @param inputNumberArray
	 * @return
	 */
	public String convertNumberArrayToString(int[] inputNumberArray) {
		StringBuilder numberStringBuilder = new StringBuilder();

		for (int index = 0; index < inputNumberArray.length; index++) {
			numberStringBuilder.append(inputNumberArray[index]);
			if (!(index == (inputNumberArray.length - 1))) {
				numberStringBuilder.append(",");
			}
		}
		return numberStringBuilder.toString();
	}
}
