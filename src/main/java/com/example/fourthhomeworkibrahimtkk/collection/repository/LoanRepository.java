package com.example.fourthhomeworkibrahimtkk.collection.repository;

import com.example.fourthhomeworkibrahimtkk.collection.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findAllByCreatedDateGreaterThanAndCreatedDateLessThan(Date startDate, Date endDate);

    List<Loan> findAllByCreatedDateGreaterThanAndCreatedDateLessThanAndTypeEquals(Date startDate, Date endDate, String type);

    List<Loan> findAllByUsername(String username);

    List<Loan> findAllByUsernameAndTypeEquals(String username, String type);

    List<Loan> findAllByUsernameAndDueDateBefore(String username, Date now);

    Loan findAllById(Long id);
}
