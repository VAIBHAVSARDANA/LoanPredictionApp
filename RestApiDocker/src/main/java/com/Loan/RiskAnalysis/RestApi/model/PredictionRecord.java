package com.Loan.RiskAnalysis.RestApi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PredictionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private double Monthly_Income;
    private int Loan_Tenure_Applied;
    private int cibil_score;
    private double Existing_EMI;
    private double Loan_Amount_Applied;

    private int prediction;
    private double probability;
}








