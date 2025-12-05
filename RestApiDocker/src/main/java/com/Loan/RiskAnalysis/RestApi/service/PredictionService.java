package com.Loan.RiskAnalysis.RestApi.service;

import com.Loan.RiskAnalysis.RestApi.model.PredictionRecord;
import com.Loan.RiskAnalysis.RestApi.model.PredictionRequest;
import com.Loan.RiskAnalysis.RestApi.model.PredictionResponse;
import com.Loan.RiskAnalysis.RestApi.repository.RequestResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PredictionService {

    private final RequestResponseRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    private final String fastApiUrl = System.getenv("FASTAPI_URL");


    public PredictionResponse makePrediction(PredictionRequest request) {
        // Call FastAPI
        PredictionResponse response = restTemplate.postForObject(fastApiUrl, request, PredictionResponse.class);

        if (response != null) {
            // Save to DB
            PredictionRecord record = new PredictionRecord();
            record.setAge(request.getAge());
            record.setMonthly_Income(request.getMonthlyIncome());
            record.setLoan_Tenure_Applied(request.getLoanTenureApplied());
            record.setCibil_score(request.getCibilScore());
            record.setExisting_EMI(request.getExistingEMI());
            record.setLoan_Amount_Applied(request.getLoanAmountApplied());
            record.setPrediction(response.getPrediction());
            record.setProbability(response.getProbability());

            repository.save(record);
        }

        return response;
    }
}
