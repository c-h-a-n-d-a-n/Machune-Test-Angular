package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.SalesVisit;
@Repository
public interface SalesVisitDao extends JpaRepository<SalesVisit, Integer> {

}
