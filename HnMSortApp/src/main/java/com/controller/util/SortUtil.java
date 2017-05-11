package com.controller.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.controller.model.SortDataInfo;
import com.controller.model.SortItem;



@Repository
public class SortUtil {
     
    private int lengthOfArray;
    private int shuffleCount;
    private int [] sortedNumberArray;
    private long startTime;
    private long endTime;
    
 
    public SortDataInfo sort(int[] inputArray) {
    	SortDataInfo sortDataInfoBean = null;
    	sortedNumberArray = Arrays.copyOf(inputArray, inputArray.length);
        if (sortedNumberArray == null || sortedNumberArray.length == 0) {
            sortDataInfoBean = null;
        }
        else{
        	lengthOfArray = sortedNumberArray.length;
        	shuffleCount=0;
        	startTime = System.nanoTime();
            quickSort(0, lengthOfArray - 1);
            endTime = System.nanoTime();
            
            sortDataInfoBean = new SortDataInfo();
            sortDataInfoBean.setOriginaNumberArray(convertNumberArrayToString(inputArray));
            sortDataInfoBean.setSortedNumberArray(convertNumberArrayToString(sortedNumberArray));
            sortDataInfoBean.setShuffleCount(shuffleCount);
            sortDataInfoBean.setTotalTimeConsumed(endTime - startTime);
            
            
            System.out.println("shuffle count :"+shuffleCount);
        }
        
        
        return sortDataInfoBean;
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = sortedNumberArray[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (sortedNumberArray[i] < pivot) {
                i++;
            }
            while (sortedNumberArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = sortedNumberArray[i];
        sortedNumberArray[i] = sortedNumberArray[j];
        sortedNumberArray[j] = temp;
        shuffleCount ++;
    }
     
    public static int[] getArrayOfNumberFromItemList(List<SortItem> sortItemList){
    	
		int[] inputNumberArray;
		int itemListSize;
		int index = 0;
		
		itemListSize = sortItemList.size();
		inputNumberArray = new int[itemListSize];
		
    	for(SortItem item : sortItemList){
			inputNumberArray[index] = Integer.parseInt(item.getValue());
			index++;
		}
    	return inputNumberArray;
    }
    
    public String convertNumberArrayToString(int[] inputNumberArray){
		StringBuilder numberStringBuilder = new StringBuilder();
		
		for(int index = 0; index <inputNumberArray.length; index++){
			numberStringBuilder.append(inputNumberArray[index]);
			if(!(index == (inputNumberArray.length-1))){
				numberStringBuilder.append(",");
			}
		}
		return numberStringBuilder.toString();
    }
}
