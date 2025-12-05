package com.Loan.RiskAnalysis.RestApi.repository;

import com.Loan.RiskAnalysis.RestApi.model.PredictionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequestResponseRepository extends JpaRepository<PredictionRecord, Long> {
}









