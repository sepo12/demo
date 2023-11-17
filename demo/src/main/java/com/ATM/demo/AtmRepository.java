package com.ATM.demo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AtmRepository extends  JpaRepository<AtmModal,Long> {

    AtmModal findByAccountNumberAndStatus(String accountNumber, String status );

    AtmModal findById(Long Id);

    
    
}
