package com.sprint.saleshistory.service;

import java.util.List;

import org.apache.el.stream.Optional;

import com.sprint.saleshistory.models.CostPojo.CostsPojo;

public class CostService {
	
	
	List<CostsPojo> getAllCosts();
    Optional<CostsPojo> getCostById(int prodId);
    CostsPojo createCost(CostsPojo newCost);
    CostsPojo updateCost(CostsPojo updateCost);
    void deleteCost(int prodId);
}


