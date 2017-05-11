package com.controller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.controller.dao.SortDataInfoDao;
import com.controller.model.SortDataInfo;

/**
 * Implementation class of the SortDataInfoDao interface. This is the repository
 * @author Tayab Hussain
 * @version 1.0
 */
@Repository
public class SortDataInfoDaoImpl implements SortDataInfoDao {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Fetches all records from DB of past sorts
	 * @return SortDataInfo - The List of sorted data information object
	 */
	@Override
	public List<SortDataInfo> getAllRecords() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SortDataInfo> criteriaQuery = builder.createQuery(SortDataInfo.class);
		Root<SortDataInfo> rootEntry = criteriaQuery.from(SortDataInfo.class);
		CriteriaQuery<SortDataInfo> allRecords = criteriaQuery.select(rootEntry);
		TypedQuery<SortDataInfo> query = entityManager.createQuery(allRecords);
		return query.getResultList();
	}

	/**
	 * Inserts the details of the sort done in the database
	 * @param sortDataInfo
	 */
	@Override
	public void insertRecord(SortDataInfo sortDataInfo) {
		entityManager.persist(sortDataInfo);
	}

	/**
	 * Fetches a selected records
	 * @param id primary key of the record to be fetched
	 * @return SortDataInfo - The List of sorted data information object
	 */
	@Override
	public SortDataInfo getRecord(Long id) {
		return entityManager.find(SortDataInfo.class, id);
	}
}
