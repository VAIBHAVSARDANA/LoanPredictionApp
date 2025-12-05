import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-prediction',
  standalone: true,   // standalone component
  imports: [IonicModule, CommonModule, FormsModule],
  templateUrl: './prediction.page.html',
  styleUrls: ['./prediction.page.scss']
})
export class PredictionPage {

  form = {
    age: null,
    Monthly_Income: null,
    Loan_Tenure_Applied: null,
    cibil_score: null,
    Existing_EMI: null,
    Loan_Amount_Applied: null
  };

  result: any;

  constructor(private http: HttpClient) {}

  predict() {
    console.log('Sending:', this.form);

    this.http.post('/api/predict', this.form)   // 🔹 relative path
      .subscribe({
        next: (response) => {
          this.result = response;
          console.log('Prediction result:', this.result);
        },
        error: (err) => {
          console.error('Prediction failed', err);
        }
      });
  }
}
