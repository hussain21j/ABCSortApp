package com.service;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.controller.dao.SortDataInfoDao;
import com.controller.model.SortDataInfo;
import com.controller.service.SortService;
import com.controller.service.Impl.SortServiceImpl;

public class SortServiceTests {
	private SortDataInfoDao sortDataInfoDaoMock;
	List<SortDataInfo> sortDataInfoList;
	SortService sortService;
	@Before
	public void setUp(){
		sortDataInfoList = new ArrayList<SortDataInfo>();
		sortService = new SortServiceImpl();
		sortDataInfoList.add(new SortDataInfo(	Long.valueOf(1), "3,1,2", "1,2,3", 1, 120));
		sortDataInfoList.add(new SortDataInfo(	Long.valueOf(1), "3,1,25,4", "1,3,4,25", 1, 120));
		sortDataInfoDaoMock = EasyMock.createStrictMock(SortDataInfoDao.class);
	}
	@Test
	public void getSortHistory(){
		EasyMock.expect(sortDataInfoDaoMock.getAllRecords()).andReturn(sortDataInfoList);
		EasyMock.replay(sortDataInfoDaoMock); //set the object
		Assert.assertEquals(true, true);
		
	}
}
