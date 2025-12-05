package com.Loan.RiskAnalysis.RestApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PredictionResponse {
    private int prediction;
    private double probability;
}
