package com.nissan.service;

import java.util.List;

import com.nissan.entity.SalesVisit;


public interface ISalesVisit {
	//list of all asset
	List<SalesVisit> getAllSalesVisit();
	
	//Find By Asset Id
	SalesVisit searchSalesById(Integer id);
	
	//Add new Asset Data
	SalesVisit addSalesVisit(SalesVisit salesVisit);	
	
	//Delete by Id
	boolean deleteSalesVisitById(Integer id);
	
	//Update by Id
	SalesVisit updateSalesVisitById(SalesVisit salesVisit);

}
