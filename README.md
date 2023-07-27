# HospitalStaffManagement
**Description**\
Implemented  a Hospital staff management using SpringBoot with basic authentication. User have to authenticate  to access the endpoints.Every Staff Member  have to register first  to access the api using signup endpoint.This endpoint  can be access without authentication.\
After the Registration they can use the email and password to authenticate to access all other endpoints.

**FUNCTIONALITY OF ENDPOINTS**\
"/staff/signin"==>Authenticate the User\
"/staff/signup"==>Register  new User\
"/admit/insert"==> Admit new patient \
"/patient/listAll"==>list All the admitted patient details\
"/patient/discharge"==>Discharge the patient\
"/patient/expenses"==>Add the charges to current due of patient\
"/patient/problem"==>List down the patient problems and consulted details for that Problem\
