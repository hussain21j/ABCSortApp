package com.controller.service.Impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.controller.dao.SortDataInfoDao;
import com.controller.model.SortDataInfo;
import com.controller.model.SortItem;
import com.controller.service.SortService;
import com.controller.util.SortUtil;

/**
 * Implementation class of the SortService interface
 * @author Tayab Hussain
 * @version 1.0
 */

@Service
@Transactional
public class SortServiceImpl implements SortService {
	@Autowired
	private SortUtil sortUtil;
	
	@Autowired
	private SortDataInfoDao sortInfoDao;

	/**
	 * Extract the numbers from the item list, sort the the list of numbers and persist the response 
	 * @param SortItem
	 * @return SortDataInfo - The sorted data information object
	 */
	@Override
	public SortDataInfo sortItemNumberList(List<SortItem> sortItemList) {
		int[] inputNumberArray;
		SortDataInfo sortDataInfo;

		inputNumberArray = SortUtil.getArrayOfNumberFromItemList(sortItemList);
		sortDataInfo = sortUtil.sort(inputNumberArray);
		
		sortInfoDao.insertRecord(sortDataInfo);
		
		return sortDataInfo;

	}

	/**
	 * gets the history of all the previous sorts done
	 * @return List SortDataInfo - The List of sorted data information object
	 */
	@Override
	public List<SortDataInfo> getSortHistory() {
		List<SortDataInfo> sortHistoryList;
		sortHistoryList = sortInfoDao.getAllRecords();
		return sortHistoryList;
	}

}
