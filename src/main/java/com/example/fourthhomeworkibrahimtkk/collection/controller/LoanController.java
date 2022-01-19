package com.example.fourthhomeworkibrahimtkk.collection.controller;

import com.example.fourthhomeworkibrahimtkk.collection.dto.request.BetweenDates;
import com.example.fourthhomeworkibrahimtkk.collection.dto.request.LoanSaveRequest;
import com.example.fourthhomeworkibrahimtkk.collection.entity.Loan;
import com.example.fourthhomeworkibrahimtkk.collection.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loan")
@CrossOrigin
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity create(@RequestBody LoanSaveRequest loan){

//        final ValidationResult validationResult = saveUserValidationService.validate(userSaveRequest);
//        if (!validationResult.getIsValid()) {
//            // TODO: error dondur
//            ResponseEntity.ok();
//        }

        final Loan savedLoan = loanService.save(loan);

        return ResponseEntity.ok(savedLoan);
    }

    @PostMapping("/date")
    public ResponseEntity getByBetweenDates(@RequestBody BetweenDates betweenDates){
        final List<Loan> loanList = loanService.getLoansByDate(betweenDates.getStartDate(), betweenDates.getEndDate());

        return ResponseEntity.ok(loanList);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity getByUsername(@PathVariable String username){
        final List<Loan> loanList = loanService.getLoansByUsername(username);

        return ResponseEntity.ok(loanList);
    }

    @GetMapping("/duedate/{username}")
    public ResponseEntity getByUsernameDueDate(@PathVariable String username){
        final List<Loan> loanList = loanService.getLoansByUsernameDueDate(username);

        return ResponseEntity.ok(loanList);
    }

    @GetMapping("/totalloan/{username}")
    public ResponseEntity getByUsernameTotalLoan(@PathVariable String username){
        final Integer totalLoan = loanService.getTotalLoanOfUsername(username);

        return ResponseEntity.ok(totalLoan);
    }

    @GetMapping("/duedatetotalloan/{username}")
    public ResponseEntity getByUsernameDueDateTotalLoan(@PathVariable String username){
        final Integer totalLoanOfUsernameDueDate = loanService.getTotalLoanOfUsernameDueDate(username);

        return ResponseEntity.ok(totalLoanOfUsernameDueDate);
    }

    @GetMapping("/latefeetotalloan/{username}")
    public ResponseEntity getByUsernameLateFeeTotalLoan(@PathVariable String username){
        final double totalLoanOfUsernameDueDate = loanService.getTotalLoanOfUsernameLateFee(username);

        return ResponseEntity.ok(totalLoanOfUsernameDueDate);
    }




}
