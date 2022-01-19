package com.example.fourthhomeworkibrahimtkk.user.repository;

import com.example.fourthhomeworkibrahimtkk.user.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findAllByCreatedDateGreaterThanAndCreatedDateLessThan(Date startDate, Date endDate);

    List<Loan> findAllByUsername(String username);

    List<Loan> findAllByUsernameAndDueDateBefore(String username, Date now);
}
