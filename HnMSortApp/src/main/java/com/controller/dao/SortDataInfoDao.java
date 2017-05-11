package com.controller.dao;

import java.util.List;
import com.controller.model.SortDataInfo;

/**
 * This interface declares all the methods for the DAO layer
 * @author Tayab Hussain
 * @version 1.0
 */
public interface SortDataInfoDao {
	public void insertRecord(SortDataInfo sortDataInfo);
	public List<SortDataInfo> getAllRecords();
	public SortDataInfo getRecord(Long id);
}
