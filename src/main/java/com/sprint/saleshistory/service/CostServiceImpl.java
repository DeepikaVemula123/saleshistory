package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.saleshistory.dao.CostRepository.CostsRepository;
import com.sprint.saleshistory.dao.entities.CostsEntity;
import com.sprint.saleshistory.models.CostPojo.CostsPojo;

public class CostServiceImpl {
	@Autowired
    private CostsRepository costsRepository;

    @Override
    public List<CostsPojo> getAllCosts() {
        List<CostsEntity> allCostsEntity = costsRepository.findAll();
        List<CostsPojo> allCostsPojo = new ArrayList<>();
        for (CostsEntity costsEntity : allCostsEntity) {
            CostsPojo costsPojo = new CostsPojo();
            BeanUtils.copyProperties(costsEntity, costsPojo);
            allCostsPojo.add(costsPojo);
        }
        return allCostsPojo;
    }

    @Override
    public Optional<CostsPojo> getCostById(int prodId) {
        Optional<CostsEntity> costsEntityOptional = costsRepository.findById(prodId);

        if (costsEntityOptional.isPresent()) {
            CostsPojo costsPojo = new CostsPojo();
            BeanUtils.copyProperties(costsEntityOptional.get(), costsPojo);
            return Optional.of(costsPojo);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public CostsPojo createCost(CostsPojo newCost) {
        CostsEntity costsEntity = new CostsEntity();
        BeanUtils.copyProperties(newCost, costsEntity);
        CostsEntity savedCostsEntity = costsRepository.save(costsEntity);
        CostsPojo savedCostsPojo = new CostsPojo();
        BeanUtils.copyProperties(savedCostsEntity, savedCostsPojo);

        return savedCostsPojo;
    }

    @Override
    public CostsPojo updateCost(CostsPojo updateCost) {
        Optional<CostsEntity> existingCostOptional = costsRepository.findById(updateCost.getProdId());

        if (existingCostOptional.isPresent()) {
            CostsEntity existingCostEntity = existingCostOptional.get();
            BeanUtils.copyProperties(updateCost, existingCostEntity);
            CostsEntity updatedCostEntity = costsRepository.save(existingCostEntity);
            CostsPojo updatedCostPojo = new CostsPojo();
            BeanUtils.copyProperties(updatedCostEntity, updatedCostPojo);

            return updatedCostPojo;
        } else {
            return null;
        }
    }

    @Override
    public void deleteCost(int prodId) {
        Optional<CostsEntity> existingCostOptional = costsRepository.findById(prodId);

        if (existingCostOptional.isPresent()) {
            costsRepository.deleteById(prodId);
        } else {
            System.out.println("Cost with ID " + prodId + " not found. Unable to delete.");
        }
    }
}


