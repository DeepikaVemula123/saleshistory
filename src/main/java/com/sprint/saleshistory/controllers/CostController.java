package com.sprint.saleshistory.controllers;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sprint.saleshistory.models.CostPojo.CostsPojo;

public class CostController {
	
	@Autowired
    CostsService costsService;

    // http://localhost:8080/api/v1/costs
    @GetMapping
    List<CostsPojo> getAllCosts() {
        return costsService.getAllCosts();
    }

    // http://localhost:8080/api/v1/costs/1
    @GetMapping("/{prodId}")
    ResponseEntity<CostsPojo> getCostById(@PathVariable("prodId") int prodId) {
        Optional<CostsPojo> cost = costsService.getCostById(prodId);
        return cost.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // http://localhost:8080/api/v1/costs
    @PostMapping
    CostsPojo createCost(@RequestBody CostsPojo newCostPojo) {
        return costsService.createCost(newCostPojo);
    }

    // http://localhost:8080/api/v1/costs/1
    @PutMapping("/{prodId}")
    CostsPojo updateCost(@PathVariable("prodId") int prodId, @RequestBody CostsPojo updateCostPojo) {
        updateCostPojo.setProdId(prodId);
        return costsService.updateCost(updateCostPojo);
    }

    // http://localhost:8080/api/v1/costs/1
    @DeleteMapping("/{prodId}")
    void deleteCost(@PathVariable("prodId") int prodId) {
        costsService.deleteCost(prodId);
    }
}


