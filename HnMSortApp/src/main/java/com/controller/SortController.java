package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.controller.model.SortDataInfo;
import com.controller.model.SortItem;
import com.controller.service.SortService;

/**
 * This is the controller for the sort services
 * @author Tayab Hussain
 * @version 1.0
 */

@RestController
public class SortController {

	@Autowired
	private SortService sortService;

	/**
	 * gets the list of the sorts history
	 * 
	 * @return SortDataInfo - The list of sorted data information object
	 */
	@RequestMapping(value = "/sort/getSortHistory", method = RequestMethod.GET)
	public List<SortDataInfo> getSortHistory() {
		return sortService.getSortHistory();
	}

	/**
	 * sorts the item list passed
	 * @param sortItemList list of items to be sorted
	 * @return SortDataInfo - The sorted data information object
	 */
	@RequestMapping(value = "/sort/sortdata", method = RequestMethod.POST)
	public @ResponseBody SortDataInfo sortData(@RequestBody List<SortItem> sortItemList) {
		return sortService.sortItemNumberList(sortItemList);
	}
}
