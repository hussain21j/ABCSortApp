package com.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.controller.model.SortDataInfo;
import com.controller.util.SortUtil;

/**
 * Comprises Unit test cases for the SortUtil class
 * @author Tayab Hussain
 * @version 1.0
 */
public class SortUtilTests {
	private int[] inputArray = {4,3,5,1};
	private SortUtil sortUtil;
	private SortDataInfo sortDataInfo;
	
	@Before
	public void setUp() {
		sortUtil = new SortUtil();
	}
	
	@Test
	public void testSort(){
		sortDataInfo = sortUtil.sort(inputArray);
		Assert.assertEquals("1,3,4,5", sortDataInfo.getSortedNumberArray());
		Assert.assertEquals("4,3,5,1", sortDataInfo.getOriginaNumberArray());
	}
	
	@After
	public void cleanUp(){
		sortUtil = null;
		sortDataInfo = null;
	}
}
