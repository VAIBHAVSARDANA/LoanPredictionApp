package com.Loan.RiskAnalysis.RestApi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class PredictionRequest {

    private int age;

    @JsonProperty("Monthly_Income")
    private double monthlyIncome;

    @JsonProperty("Loan_Tenure_Applied")
    private int loanTenureApplied;

    @JsonProperty("cibil_score")
    private int cibilScore;

    @JsonProperty("Existing_EMI")
    private double existingEMI;

    @JsonProperty("Loan_Amount_Applied")
    private double loanAmountApplied;
}
