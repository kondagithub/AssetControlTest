Feature: Pet purchase order service feature

  Scenario: Pet purchase order service test for sucess response
  	Given Loded purchase order details
  	When Placed purchase order request
  	Then Verified for succes response
  	And Verified responde details
