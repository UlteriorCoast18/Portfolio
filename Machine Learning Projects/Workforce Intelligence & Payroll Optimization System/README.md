# Workforce Intelligence & Payroll Optimization System

A multidisciplinary project (Data Analytics + Data Science + Machine
Learning) to analyze, predict, and optimize workforce aspects: payroll,
attrition, absenteeism, and employee segmentation. Ideal for showcasing
an applied HR/Payroll case in your portfolio that combines EDA,
predictive models, clustering, and an interactive dashboard.

## Summary

This repository contains the necessary components to:

-   Explore and clean HR/payroll data
-   Build attrition and salary prediction models
-   Segment workforce using clustering
-   Provide an interactive dashboard for executive reports and
    optimization experiments

The project is designed to be reproducible, modular, and easy to extend
with other datasets (for example, your own dataset exported from SAP).

## Objectives

-   Perform comprehensive EDA that generates actionable KPIs for HR
-   Predict attrition probability and estimate salary adjustments
-   Segment employees into actionable groups (critical talent, flight
    risk, cost-efficient)
-   Implement a dashboard (Streamlit) to visualize results and test
    optimization scenarios
-   Publish the project on GitHub with good documentation for interviews

## Expected Outcomes

-   Executive dashboard for payroll KPIs
-   Classification model for attrition with metrics (ROC-AUC, Precision,
    Recall, F1)
-   Regression model for salary/prediction adjustment
-   Interpretable clusters and business rules per segment
-   Report with actionable recommendations

## Suggested Datasets (Sources)

You can start with any of these public datasets; you can also use an
anonymized extract from your real SAP ECP/ECC if available (recommended
to showcase work with real data):

-   IBM HR Analytics / Employee Attrition (Kaggle)
-   HR Employee Attrition (Kaggle)
-   Open payroll/employment data (government portals)

Place files in `data/raw/` and ensure not to upload sensitive data to
GitHub (use .gitignore for files with PII).

## Repository Structure

    workforce-intelligence-system/
    │── data/
    │   ├── raw/
    │   ├── processed/
    │── notebooks/
    │   ├── 01_eda_payroll.ipynb
    │   ├── 02_attrition_model.ipynb
    │   ├── 03_salary_prediction.ipynb
    │   ├── 04_workforce_clustering.ipynb
    │── src/
    │   ├── data/
    │   │   ├── preprocess.py
    │   │   └── load_data.py
    │   ├── features/
    │   │   └── fe_engineering.py
    │   ├── models/
    │   │   ├── train.py
    │   │   └── predict.py
    │   ├── evaluation/
    │   │   └── metrics.py
    │── dashboards/
    │   └── streamlit_app.py
    │── models/
    │── requirements.txt
    │── README.md

## Requirements & Installation

Assumes Python ≥ 3.9.

``` bash
git clone https://github.com/UlteriorCoast18/Portfolio.git
cd Portfolio/workforce-intelligence-system

python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

### Suggested minimum requirements.txt:

    pandas
    numpy
    scikit-learn
    matplotlib
    seaborn
    jupyterlab
    streamlit
    xgboost
    shap
    joblib
    sqlalchemy
    geopandas

## Getting Started (Workflow)

1.  Place dataset in `data/raw/`
2.  Run `01_eda_payroll.ipynb`
3.  Run `src/data/preprocess.py`
4.  Train models via notebooks
5.  Run clustering notebook
6.  Launch dashboard:

``` bash
streamlit run dashboards/streamlit_app.py
```

## Metrics & Evaluation

### Classification:

-   ROC-AUC
-   Precision, Recall, F1
-   Confusion Matrix

### Regression:

-   RMSE, MAE, R²

### Clustering:

-   Silhouette Score
-   Cluster interpretability

## Interpretability

Use SHAP or LIME for model explanations and convert them into business
insights.

## Future Extensions

-   SAP integration
-   Automated pipelines (Airflow/Prefect)
-   REST API for predictions
-   Time series forecasting

## Checklist

-   EDA notebook
-   Trained attrition model
-   Trained salary model
-   Preprocess script
-   Streamlit dashboard
-   README
-   License

## Additional Info

This dataset was sourced from Cook County Open Data: https://catalog.data.gov/dataset/employee-payroll. All personal identifying information was removed prior to publication. Employee identifiers are anonymized and do not correspond to real internal IDs.


## Contact

Cristo Daniel Alvarado --- cristo.daniel.alvarado@gmail.com\
GitHub: https://github.com/UlteriorCoast18
