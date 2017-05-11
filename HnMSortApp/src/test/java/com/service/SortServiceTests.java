package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.When;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.controller.dao.SortDataInfoDao;
import com.controller.model.SortDataInfo;
import com.controller.service.SortService;
import com.controller.service.Impl.SortServiceImpl;

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
		//sortDataInfoDaoMock = EasyMock.createStrictMock(SortDataInfoDao.class);
		sortDataInfoDaoMock = Mockito.mock(SortDataInfoDao.class);
	}
	@Test
	public void getSortHistory(){
		
		Mockito.when(sortDataInfoDaoMock.getAllRecords()).thenReturn(sortDataInfoList);
		sortService.getSortHistory();
		Assert.assertEquals(3, sortService.getSortHistory().size());
	}
}
