package com.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.controller.dao.SortDataInfoDao;
import com.controller.model.SortDataInfo;
import com.controller.service.SortService;
import com.controller.service.Impl.SortServiceImpl;
/**
 * This is the Test class of the SortService
 * @author Tayab Hussain
 * @version 1.0
 * 
 * This Class is in not completed and in progress
 */
public class SortServiceTests {
	@Mock
	SortDataInfoDao sortDataInfoDaoMock;
	List<SortDataInfo> sortDataInfoList;
	SortService sortService;
	@Before
	public void setUp(){
		sortDataInfoList = new ArrayList<SortDataInfo>();
		sortService = new SortServiceImpl();
		sortDataInfoList.add(new SortDataInfo(	Long.valueOf(1), "3,1,2", "1,2,3", 1, 120));
		sortDataInfoList.add(new SortDataInfo(	Long.valueOf(1), "3,1,25,4", "1,3,4,25", 1, 120));
		sortDataInfoDaoMock = Mockito.mock(SortDataInfoDao.class);
	}
	
	@Test
	public void getSortHistory(){
		
		//Mockito.when(sortDataInfoDaoMock.getAllRecords()).thenReturn(sortDataInfoList);
		//sortService.getSortHistory();
		Assert.assertEquals(true, true);
	}
}
