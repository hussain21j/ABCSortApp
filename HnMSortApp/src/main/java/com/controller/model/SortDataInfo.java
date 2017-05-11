package com.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This Entity class which is mapped to a table in database
 * @author Tayab Hussain
 * @version 1.0
 */
@Entity
@Table(name = "TBL_SORT_INFO")
public class SortDataInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "UNSORTED_NUMBER")
	private String originaNumberArray;
	@Column(name = "SORTED_NUMBER")
	private String sortedNumberArray;
	@Column(name = "SHUFFLE_COUNT")
	private int shuffleCount;
	@Column(name = "TOTAL_TIME")
	private long totalTimeConsumed;

	public SortDataInfo() {
		super();
	}

	public SortDataInfo(Long id, String originaNumberArray, String sortedNumberArray, int shuffleCount,
			long totalTimeConsumed) {
		super();
		this.id = id;
		this.originaNumberArray = originaNumberArray;
		this.sortedNumberArray = sortedNumberArray;
		this.shuffleCount = shuffleCount;
		this.totalTimeConsumed = totalTimeConsumed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginaNumberArray() {
		return originaNumberArray;
	}

	public void setOriginaNumberArray(String originaNumberArray) {
		this.originaNumberArray = originaNumberArray;
	}

	public String getSortedNumberArray() {
		return sortedNumberArray;
	}

	public void setSortedNumberArray(String sortedNumberArray) {
		this.sortedNumberArray = sortedNumberArray;
	}

	public int getShuffleCount() {
		return shuffleCount;
	}

	public void setShuffleCount(int shuffleCount) {
		this.shuffleCount = shuffleCount;
	}

	public long getTotalTimeConsumed() {
		return totalTimeConsumed;
	}

	public void setTotalTimeConsumed(long totalTimeConsumed) {
		this.totalTimeConsumed = totalTimeConsumed;
	}
}
