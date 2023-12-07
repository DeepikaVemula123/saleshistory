package com.sprint.saleshistory.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.dao.entities.Country;
 
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
   
 
}





