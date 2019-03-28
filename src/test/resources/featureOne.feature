@tag
Feature: This feature is to verify SwiftTransferUI
 
@First 
Scenario: Verification of new User Registeration
Given open the GoogleChrome and Launch the application
When Enter the FirstName 
And Enter the LastName
And Enter the Mobile
And Enter the Email
And Click on Register button
Then Check the response message


@Second
Scenario: Verification of Transfer money
Given User is registered
When Click on Transact 
And From Account Number
And To Account Number
And Add Amount details
And Add Description note
And Click on Transfer button
Then Validate the message

@Third
Scenario: Verification of Transaction history
Given User is registered/logged in
When Click on TransferHistory 
Then Verify the TransactionReport 




