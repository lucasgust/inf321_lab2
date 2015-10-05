Feature: Freight Calculator
	As a User
  	I want to use know the price and how many days to received my product
  	So that I do not need to calculate myself

Scenario: User start calculation 
	Given Sends a CEP 
	When  System calculate the date-time and price 
	Then  Should return correct date and price of deliver 

Scenario Outline: Search Address 
	Given System sends a <CEP>
	When  System connects to Correios API
	And   System make a validation
	Then  Should return a string <address> of CEP

	Examples: 
		| CEP 			| address
		|	13495-000   |	Iracemápolis - São Paulo
		|	13417-780	|	Nova América - Piracicaba - São Paulo
		|	13407-417	|	Piracicamirim - Piracicaba - São Paulo
		|   13044-500   |   Antonio Vomzubem - Campinas - São Paulo

#Devemos definir talvez mais 2 cenarios!
		
#Scenario: Division by zero 
#	Given I have a calculator 
#	When I divide 7 with 0 
#	Then should show an error with a message: 
#	"""
#	/ by zero
#	"""
#	
#	Scenario: Divide two numbers
#	Given I have a calculator 
#	When I divide 9 with 3 
#	Then the result should be 3