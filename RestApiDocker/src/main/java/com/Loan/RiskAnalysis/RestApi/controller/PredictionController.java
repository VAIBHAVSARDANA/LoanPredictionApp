package com.Loan.RiskAnalysis.RestApi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loan.RiskAnalysis.RestApi.model.PredictionRequest;
import com.Loan.RiskAnalysis.RestApi.model.PredictionResponse;
import com.Loan.RiskAnalysis.RestApi.service.PredictionService;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/api/predict")
@RequiredArgsConstructor
public class PredictionController {

    private final PredictionService predictionService;
    //private final RequestResponseRepository repository;

    @PostMapping
    public PredictionResponse getPrediction(@RequestBody PredictionRequest request) {
        return predictionService.makePrediction(request);
    }

}
