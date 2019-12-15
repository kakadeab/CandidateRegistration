# CandidateRegistration

Steps to Run the CandidateRegistration

#Note:- All Images are available in the "CandidateRegistration/Images" directory.
#Note:- All the request and response are available in the "CandidateRegistration/RequestResponse" directory

# Command to clone the project :- git clone https://github.com/kakadeab/CandidateRegistration.git

Step1. After git clone create a database schema with name "CANDIDATE_REGISTRATION" and change the username and password in the application.properties file.

Step2. Go to the "CandidateRegistration/candidate-registration" directory.

Step3. Open terminal in the candidate-registration directory (Refer image Terminal1.png).

Step4. Now we need to buils the project, So execute "sudo mvn clean install -DskipTests=true" command (Refer image Terminal2.png, Terminal3.png, 	Terminal4.png)

Step5. Once the build is success as shown in the Terminal4.png. our war file will be created on the path "CandidateRegistration/candidate-registration/target/CandidateRegistration.war"

Step6. Now run the application by using "java -jar ./target/CandidateRegistration.war" command (Refer image Terminal5.png, Terminal6.png, 	   Terminal7.png)

Step7. Once the application runs successfully, open the Postman.

# TO Create New Candidate Registration
Step8. To Create new candidate registration use the request and url from "CandidateRegistration/RequestResponse/CandidateRegister.json" (Refer   	Postman1.png, Postman2.png)

# To Get the details by using candidate ID.

Step9. To get details of candidate use the url from "CandidateRegistration/RequestResponse/CandidateDetails.json". (Refer Postman3.png)





















