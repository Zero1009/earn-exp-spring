package com.theerakan.earnexpspring.dto.batch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String userName;
    private int userId;
    private Date transactionDate;
    private double transactionAmount;
}
