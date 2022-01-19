package com.example.fourthhomeworkibrahimtkk.collection.controller;

import com.example.fourthhomeworkibrahimtkk.collection.dto.request.BetweenDates;
import com.example.fourthhomeworkibrahimtkk.collection.entity.Loan;
import com.example.fourthhomeworkibrahimtkk.collection.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/collection")
@CrossOrigin
@RequiredArgsConstructor
public class CollectionController {
    final private CollectionService collectionService;

    @PostMapping("/{id}")
    public ResponseEntity makeCollection(@PathVariable String id){

        collectionService.makeCollection(id);

        return ResponseEntity.ok("");
    }

    @PostMapping("/date")
    public ResponseEntity getCollectionsByBetweenDates(@RequestBody BetweenDates betweenDates){
        final List<Loan> loanList = collectionService.getCollectionsByDate(betweenDates.getStartDate(), betweenDates.getEndDate());

        return ResponseEntity.ok(loanList);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity getCollectionsByUsername(@PathVariable String username){
        final List<Loan> loanList = collectionService.getCollectionsByUsername(username);

        return ResponseEntity.ok(loanList);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity getPaidCollectionsByUsername(@PathVariable String username){
        final Integer totalPaidCollections = collectionService.getPaidCollectionsByUsername(username);

        return ResponseEntity.ok(totalPaidCollections);
    }




}
