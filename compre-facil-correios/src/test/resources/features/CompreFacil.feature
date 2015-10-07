Feature: Freight Calculator
	As a User
  	I want to use know the price and how many days to receive my product
  	So that I do not need to calculate myself

Scenario: Calculating freight cost and time
	Given User types the CEP for the deliverable address
	When  User press button to calculate freight cost and time for delivery
	Then  System should send the required info for integrating with Correios API
	And   System Should return correct date and price of deliver presented by the API

Scenario Outline: Calculating freight cost and time - API Integration
	Given System collects the information needed of all order items <Wheight> <Width> <Height> <Length>
	When  User press button to calculate freight cost and time for delivery
	And   System connects to Correios API
	And   System sends the file with all mandatory tags <nCdEmpresa> <sDsSenha> <nCdServico> <sCepOrigem> <sCepDestino> <nVlPeso>
			<nCdFormato> <nVlComprimento> <nVlAltura> <nVlLargura> <nVlDiametro> <sCdMaoPropria> <nVlValorDeclarado> <sCdAvisoRecebimento>
	Then  Correios API returns <FreightCost> and <Deadline>

	Example - Oubound File: 
	|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|
	|		   |		|40010	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |
	|		   |		|40010	   |13495-000 |13417-780  |100	  |2		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	
	|		   |		|40010	   |13495-000 |13417-780  |100	  |3		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	
	|		   |		|40045	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |
	
	Example - Inbound File:
	|codigo|FreightCost|Deadline|
	|40010 |16,50	   |1		|
	|40010 |20,50	   |1		|
	|40010 |16,50	   |3		|
	|40010 |16,50	   |1		|

Scenario Outline: Search Address 
	Given User types the <CEP>
	When  System connects to Correios API
	And   System make a validation
	Then  System Should return a string <address> of CEP

	Examples: 
		| CEP 			| address
		|	13495-000   |	Iracemápolis - São Paulo
		|	13417-780	|	Nova América - Piracicaba - São Paulo
		|	13407-417	|	Piracicamirim - Piracicaba - São Paulo
		|   13044-500   |   Antonio Vomzubem - Campinas - São Paulo
