package com.example.fourthhomeworkibrahimtkk.collection.service;

import com.example.fourthhomeworkibrahimtkk.collection.entity.Loan;
import com.example.fourthhomeworkibrahimtkk.collection.repository.LoanRepository;
import com.example.fourthhomeworkibrahimtkk.generator.Constants;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionService {
    private final LoanRepository loanRepository;

    @SneakyThrows
    public void makeCollection(String collectionId) {
        Long id = Long.getLong(collectionId);
        final Loan loan = loanRepository.findAllById(id);
        final Date today = new Date();
        final long diffDays = today.getTime() - loan.getReceiptDate().getTime();
        final float days = (diffDays / (1000*60*60*24));

        final float totalDebt = days*2;

        Loan saveLoan = Loan.builder()
                .mainLoanId(id)
                .createdDate(loan.getCreatedDate())
                .dueDate(loan.getDueDate())
                .mainAmount(Math.round(totalDebt) - loan.getMainAmount())
                .receiptDate(new Date())
                .remainingAmount(0)
                .type("GECIKME_ZAMMI")
                .build();

        loan.setMainAmount(0);

        loanRepository.save(saveLoan);
        loanRepository.save(loan);

    }

    @SneakyThrows
    public List<Loan> getCollectionsByDate(String startDateString, String endDateString) {
        final Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
        final Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateString);
        List<Loan> loanList = loanRepository.findAllByCreatedDateGreaterThanAndCreatedDateLessThanAndTypeEquals(startDate, endDate, Constants.gecikmeZammi);
        return loanList;
    }

    public List<Loan> getCollectionsByUsername(String username) {
        List<Loan> loanList = loanRepository.findAllByUsernameAndTypeEquals(username, Constants.gecikmeZammi);
        return loanList;
    }

    public Integer getPaidCollectionsByUsername(String username) {
        final List<Loan> loanList = getCollectionsByUsername(username);
        final Integer totalPaidCollections = loanList.stream()
                .map(Loan::getMainAmount)
                .reduce(0, (subtotal, element) -> subtotal+element);
        return totalPaidCollections;
    }

}
