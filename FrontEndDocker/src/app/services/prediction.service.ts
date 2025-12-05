import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

export interface PredictionRequest {
  age: number;
  monthlyIncome: number;
  loanTenureApplied: number;
  cibilScore: number;
  existingEMI: number;
  loanAmountApplied: number;
}

export interface PredictionResponse {
  prediction: string;
  probability: number;
}

@Injectable({
  providedIn: 'root'
})
export class PredictionService {
  private apiUrl = `${environment.apiUrl}/predict`; // 🔹 relative path

  constructor(private http: HttpClient) {}

  getPrediction(data: PredictionRequest): Observable<PredictionResponse> {
    return this.http.post<PredictionResponse>(this.apiUrl, data);
  }
}
