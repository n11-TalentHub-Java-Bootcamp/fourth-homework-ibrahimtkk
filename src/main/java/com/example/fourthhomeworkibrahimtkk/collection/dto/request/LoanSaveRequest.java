package com.example.fourthhomeworkibrahimtkk.collection.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanSaveRequest {

    private Long id;
    private String username;
    private Integer mainAmount;
    private Integer remainingAmount;
    private Long mainLoanId;
    private String createdDate;
    private String receiptDate;
    private String dueDate;
    private String type;
}
