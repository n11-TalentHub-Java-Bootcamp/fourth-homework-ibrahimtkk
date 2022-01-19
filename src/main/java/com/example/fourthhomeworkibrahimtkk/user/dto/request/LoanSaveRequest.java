package com.example.fourthhomeworkibrahimtkk.user.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

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
