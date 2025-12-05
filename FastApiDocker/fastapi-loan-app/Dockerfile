FROM python:3.11-slim

WORKDIR /app

# Copy requirements and wheels
COPY requirements.txt .
COPY wheels/ /wheels/

# Install dependencies offline
RUN pip install --no-index --find-links=/wheels -r requirements.txt

# Copy model and app
COPY loan_model_v2.pkl scaler.pkl /app/
COPY app/ ./app/

EXPOSE 8000

CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]