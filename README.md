<!-- TOC -->
* [Doctor](#doctor)
* [Patient](#patient)
* [Medical Report](#medical-report-)
* [Prescription](#prescription-)
<!-- TOC -->

# Doctor

| HTTP Method | URL Path      | HTTP Status Code | Description         | Sample Request         | Sample Response                                                                                     |
|-------------|---------------|------------------|---------------------|------------------------|-----------------------------------------------------------------------------------------------------|
| GET         | /doctors/{id} | 200 OK           | Get doctor by ID    | `GET /doctors/{id}`    | `200 OK` `{"name": "ishaq Doe", "specialization": "Cardiology", "rank": "Senior", "salary": 10000}` |
|             |               | 404 Not Found    | Doctor not found    | `GET /doctors/{id}`    | `404 Not Found`                                                                                     |
| POST        | /doctors      | 201 Created      | Create a new doctor | `POST /doctors`        | `{"name": "ishaq Don", "specialization": "Cardiology", "rank": "Senior", "salary": 10000}`          |
| PUT         | /doctors/{id} | 200 OK           | Update doctor by ID | `PUT /doctors/{id}`    | `200 OK` `{"name": "ishaq Doe", "specialization": "Cardiology", "rank": "Senior", "salary": 10000}  |
|             |               | 404 Not Found    | Doctor not found    | `PUT /doctors/{id}`    | `404 Not Found`                                                                                     |
| DELETE      | /doctors/{id} | 204 No Content   | Delete doctor by ID | `DELETE /doctors/{id}` | `204 No Content`                                                                                    |
|             |               | 404 Not Found    | Doctor not found    | `DELETE /doctors/{id}` | `404 Not Found`                                                                                     |


# Patient


| HTTP Method | URL Path           | HTTP Status Code | Description               | Sample Request              | Sample Response                                                                             |
|-------------|--------------------|------------------|---------------------------|-----------------------------|---------------------------------------------------------------------------------------------|
| GET         | /patient-data/{id} | 200 OK           | Get patient data by ID    | `GET /patient-data/{id}`    | `200 OK``{"NicNumber": 112333441, "sickness": "heart attack", "Phone_Number": +9727679876}` |
|             |                    | 404 Not Found    | Patient data not found    | `GET /patient-data/{id}`    | `404 Not Found`                                                                             |
| POST        | /patient-data      | 201 Created      | Create a new patient data | `POST /patient-data`        | `{"NicNumber": 112333441, "sickness": "heart attack", "Phone_Number": +9727279876}`         |
| PUT         | /patient-data/{id} | 200 OK           | Update patient data by ID | `PUT /patient-data/{id}`    | `200 OK` `{"NicNumber": 1, "sickness": "heart attack", "Phone_Number": +9727679876}`        |
|             |                    | 404 Not Found    | Patient data not found    | `PUT /patient-data/{id}`    | `404 Not Found`                                                                             |
| DELETE      | /patient-data/{id} | 204 No Content   | Delete patient data by ID | `DELETE /patient-data/{id}` | `204 No Content`                                                                            |
|             |                    | 404 Not Found    | Patient data not found    | `DELETE /patient-data/{id}` | `404 Not Found`                                                                             |


# Medical Report 

| HTTP Method | URL Path              | HTTP Status Code | Description                 | Sample Request                 | Sample Response                                                                                                        |
|-------------|-----------------------|------------------|-----------------------------|--------------------------------|------------------------------------------------------------------------------------------------------------------------|
| GET         | /medical-reports/{id} | 200 OK           | Get medical report by ID    | `GET /medical-reports/{id}`    | `200 OK``{"id": 1, "patientData": {"NicNumber": 112333441, "sickness": "heart attack", "Phone_Number": +9727679876}`}` |
|             |                       | 404 Not Found    | Medical report not found    | `GET /medical-reports/{id}`    | `404 Not Found`                                                                                                        |
| POST        | /medical-reports      | 201 Created      | Create a new medical report | `POST /medical-reports`        | `{"patientData": { {"NicNumber": 112333441, "sickness": "heart attack", "Phone_Number": +9727679876}`}`                |
| PUT         | /medical-reports/{id} | 200 OK           | Update medical report by ID | `PUT /medical-reports/{id}`    | `200 OK``{"id": 1, "patientData": {"NicNumber": 112333441, "sickness": "heart attack", "Phone_Number": +9727679876}`}` |
|             |                       | 404 Not Found    | Medical report not found    | `PUT /medical-reports/{id}`    | `404 Not Found`                                                                                                        |
| DELETE      | /medical-reports/{id} | 204 No Content   | Delete medical report by ID | `DELETE /medical-reports/{id}` | `204 No Content`                                                                                                       |
|             |                       | 404 Not Found    | Medical report not found    | `DELETE /medical-reports/{id}` | `404 Not Found`                                                                                                        |

#   Prescription 


| HTTP Method | URL Path            | HTTP Status Code | Description               | Sample Request            | Sample Response                                                                                                  |
|-------------|---------------------|------------------|---------------------------|---------------------------|------------------------------------------------------------------------------------------------------------------|
| GET         | /prescriptions/{id} | 200 OK           | Get prescription by ID    | `GET /prescriptions/1`    | `200 OK``{"id": 1, "patientData": {"nicNumber": "123456789", "sickness": "Headache", "phone": "1234567890"}}`    |
|             |                     | 404 Not Found    | Prescription not found    | `GET /prescriptions/999`  | `404 Not Found`                                                                                                  |
| POST        | /prescriptions      | 201 Created      | Create a new prescription | `POST /prescriptions`     | `201 Created` `{"id": 2, "patientData": {"nicNumber": "987654321", "sickness": "Fever", "phone": "9876543210"}}` |
| PUT         | /prescriptions/{id} | 200 OK           | Update prescription by ID | `PUT /prescriptions/1`    | `200 OK` `{"id": 1, "patientData": {"nicNumber": "123456789", "sickness": "Headache", "phone": "1234567890"}}`   |
|             |                     | 404 Not Found    | Prescription not found    |                           |                                                                                                                  |
| DELETE      | /prescriptions/{id} | 204 No Content   | Delete prescription by ID | `DELETE /prescriptions/1` | `204 No Content`                                                                                                 |
|             |                     | 404 Not Found    | Prescription not found    |                           |                                                                                                                  |

