package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.SalesVisitDao;
import com.nissan.entity.SalesVisit;
@Service
public class SalesVisitService implements ISalesVisit {
	@Autowired
	SalesVisitDao salesVisitDao;
	@Override
	public List<SalesVisit> getAllSalesVisit() {
		// TODO Auto-generated method stub
		return salesVisitDao.findAll();
	}

	@Override
	public SalesVisit searchSalesById(Integer id) {
		SalesVisit searchSalesById=salesVisitDao.findById(id).orElse(null);
		if (searchSalesById==null) {
			return null;
		}else {
			return searchSalesById;
		}
	}

	@Override
	public SalesVisit addSalesVisit(SalesVisit salesVisit) {
		// TODO Auto-generated method stub
		return salesVisitDao.save(salesVisit);
	}

	@Override
	public boolean deleteSalesVisitById(Integer id) {
		SalesVisit findID=salesVisitDao.findById(id).orElse(null);
		salesVisitDao.deleteById(id);
		if (findID==null) {
			return false;
		}else {
			salesVisitDao.deleteById(id);
			return true;
		}
	}

	@Override
	public SalesVisit updateSalesVisitById(SalesVisit salesVisit) {
		// TODO Auto-generated method stub
		return salesVisitDao.save(salesVisit);
	}

}
