package com.example.fourthhomeworkibrahimtkk.user.entity;

import com.example.fourthhomeworkibrahimtkk.generator.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LOAN")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Loan implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private Integer mainAmount;
    private Integer remainingAmount;
    private Long mainLoanId;
    private Date createdDate;
    private Date receiptDate;
    private String type;
    private Date dueDate;

}
