package com.controller.service;

import java.util.List;
import com.controller.model.SortDataInfo;
import com.controller.model.SortItem;


/**
 * This interface declares all the methods for the sort service
 * @author Tayab Hussain
 * @version 1.0
 */
public interface SortService {
	public SortDataInfo sortItemNumberList(List<SortItem> sortItemList);
	public List<SortDataInfo> getSortHistory();
}
