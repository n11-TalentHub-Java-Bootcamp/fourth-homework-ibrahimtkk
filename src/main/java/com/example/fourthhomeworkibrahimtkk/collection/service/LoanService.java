package com.example.fourthhomeworkibrahimtkk.collection.service;

import com.example.fourthhomeworkibrahimtkk.collection.dto.request.LoanSaveRequest;
import com.example.fourthhomeworkibrahimtkk.collection.entity.Loan;
import com.example.fourthhomeworkibrahimtkk.collection.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;

    @SneakyThrows
    public Loan save(LoanSaveRequest loanRequest) {
        final Loan loan = Loan.builder()
                .mainLoanId(loanRequest.getMainLoanId())
                .createdDate(new SimpleDateFormat("dd/MM/yyyy").parse(loanRequest.getCreatedDate()))
                .mainAmount(loanRequest.getMainAmount())
                .receiptDate(new SimpleDateFormat("dd/MM/yyyy").parse(loanRequest.getReceiptDate()))
                .id(loanRequest.getId())
                .remainingAmount(loanRequest.getRemainingAmount())
                .username(loanRequest.getUsername())
                .type(loanRequest.getType())
                .dueDate(new SimpleDateFormat("dd/MM/yyyy").parse(loanRequest.getDueDate()))
                .build();

        return loanRepository.save(loan);
    }

    @SneakyThrows
    public List<Loan> getLoansByDate(String startDateString, String endDateString) {
        final Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
        final Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateString);
        List<Loan> loanList = loanRepository.findAllByCreatedDateGreaterThanAndCreatedDateLessThan(startDate, endDate);
        return loanList;
    }

    public List<Loan> getLoansByUsername(String username) {
        List<Loan> loanList = loanRepository.findAllByUsername(username);
        return loanList;
    }

    public List<Loan> getLoansByUsernameDueDate(String username) {
        final Date date = new Date();
        List<Loan> loanList = loanRepository.findAllByUsernameAndDueDateBefore(username, date);
        return loanList;
    }

    public Integer getTotalLoanOfUsername(String username) {
        return loanRepository.findAllByUsername(username)
                .stream()
                .map(loan -> loan.getMainAmount())
                .reduce(0, (subtotal, element) -> subtotal+element);
    }

    public Integer getTotalLoanOfUsernameDueDate(String username) {
        final Date date = new Date();
        return loanRepository.findAllByUsernameAndDueDateBefore(username, date)
                .stream()
                .map(loan -> loan.getMainAmount())
                .reduce(0, (subtotal, element) -> subtotal+element);
    }

    public double getTotalLoanOfUsernameLateFee(String username) {
        final Date date = new Date();
        final Date limitDate = new GregorianCalendar(2018, Calendar.JANUARY, 1).getTime();
        final Integer beforeLimitDate = loanRepository.findAllByUsernameAndDueDateBefore(username, date)
                .stream()
                .filter(loan -> loan.getDueDate().before(limitDate))
                .map(loan -> loan.getMainAmount())
                .reduce(0, (subtotal, element) -> subtotal+element);

        final Integer afterLimitDate = loanRepository.findAllByUsernameAndDueDateBefore(username, date)
                .stream()
                .filter(loan -> loan.getDueDate().after(limitDate))
                .map(loan -> loan.getMainAmount())
                .reduce(0, (subtotal, element) -> subtotal+element);


        return beforeLimitDate*1.5 + afterLimitDate*2;
    }

}
