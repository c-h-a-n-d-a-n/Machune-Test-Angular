package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dao.SalesVisitDao;
import com.nissan.entity.SalesVisit;
import com.nissan.service.SalesVisitService;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/Sales")
public class SalesVisitController {
	@Autowired
	private SalesVisitDao salesVisitDao;
	@Autowired
	private SalesVisitService salesVisitService;
	@GetMapping
	public ResponseEntity<?> getAllSalesVisit(){
		List<SalesVisit> salesList=salesVisitService.getAllSalesVisit();
		
		if(salesList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Database is empty!!!");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(salesList);
		}
	}
	@PostMapping
	public ResponseEntity<?> addSalesVisit(@RequestBody SalesVisit sales) {
		SalesVisit assests = salesVisitService.addSalesVisit(sales);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Sales Visit added to the database successfully!!!");
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSalesVisitById(@PathVariable Integer id) {
		SalesVisit sales=salesVisitDao.findById(id).orElse(null);
		salesVisitService.deleteSalesVisitById(id);
		if (sales == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Sales Visit with " + id + " not found in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("sales Data has been successfully removed from the database!!!");
		}
	}
	@GetMapping("{id}")
	public ResponseEntity<?> searchSalesById(@PathVariable Integer id) {
		SalesVisit findsalessById = salesVisitService.searchSalesById(id);

		if (findsalessById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sales with id" + id + " is not available in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(findsalessById);
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<?> updateSalesVisitById(@PathVariable Integer id,@RequestBody SalesVisit salesVisit) {
		SalesVisit sales=salesVisitDao.findById(id).orElse(null);
		
		if(sales==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sales with id" + id + " is not available in the database!!!");
		}else {
			sales.setCust_Name(salesVisit.getCust_Name());
			salesVisitDao.save(sales);
			return ResponseEntity.status(HttpStatus.OK).body("sales Data has been successfully update the database!!!");
		}	
	}
}



