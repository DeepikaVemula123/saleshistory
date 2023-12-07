package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.dao.entities.CostsEntity;

public class CostRepository {
	
	@Repository
	public interface CostsRepository extends JpaRepository<CostsEntity, Integer> {
	    // Add custom query methods if needed
	}
	

}
