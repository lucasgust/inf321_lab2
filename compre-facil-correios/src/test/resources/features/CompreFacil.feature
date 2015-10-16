Feature: Freight Calculator
	As a User
  	I want to inform my zip code to know the price and how many days to receive my product
  	So that I do not need to calculate myself

Scenario Outline: Calculating freight and deadline - API Integration
	Given All items from sales order are settled
	And User types "<sCepDestino>"
	When User press button to calculate freight
	And system connects to Correios API
	And system sends the file with all mandatory tags "<nCdEmpresa>" "<sDsSenha>" "<nCdServico>" "<sCepOrigem>" "<sCepDestino>" "<nVlPeso>" "<nCdFormato>" "<nVlComprimento>" "<nVlAltura>" "<nVlLargura>" "<nVlDiametro>" "<sCdMaoPropria>" "<nVlValorDeclarado>" "<sCdAvisoRecebimento>"
	Then correios API returns "<valor>" "<prazoEntrega>" "<cErro>" "<msgErro>"
	And save data in database "<prazoEntrega>" "<valor>"
	
		Examples:
		|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|  valor	| prazoEntrega 	| cErro | msgErro |
		|		   |		|40010     |13495000  | 13417780  | 10    |1		 |20			|5		  |12		 |8			 |N			   |0				 |N					 |	31,30	|		2		|  0   |          |
		|		   |		|40010	   |13084971  | 13083872  | 15	  |2		 |30			|5		  |13		 |8			 |N			   |0				 |N					 |	46,30	|		1		|  0   |          |
		
Scenario Outline: Calculating freight and deadline - API Integration returns Error
	Given All items from sales order are settled
	And User types "<sCepDestino>"
	And at least one field is not valid
	When User press button to calculate freight
	And system connects to Correios API
	And system sends the file with all mandatory tags "<nCdEmpresa>" "<sDsSenha>" "<nCdServico>" "<sCepOrigem>" "<sCepDestino>" "<nVlPeso>" "<nCdFormato>" "<nVlComprimento>" "<nVlAltura>" "<nVlLargura>" "<nVlDiametro>" "<sCdMaoPropria>" "<nVlValorDeclarado>" "<sCdAvisoRecebimento>"
	Then correios API returns "<valor>" "<prazoEntrega>" "<cErro>" "<msgErro>"
	
	Examples:
		|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|  valor	| prazoEntrega 	| cErro | msgErro                                  |
		|		   |		|40010     |          | 13417780  | 10    |1		 |20			|5		  |12		 |8			 |N			   |0				 |N					 |	0	    |		0		| -888  |   Erro ao calcular tarifa                |
		|		   |		|40010	   |13084971  | 13083872  | 15	  |2		 |30			|5		  |13		 |8			 |S			   |0				 |S			    	 |	0	    |		0		|   7   |   Servico indisponivel, tente mais tarde |  
        |		   |		|40010	   |130c497a  | 13083872  | 15	  |2		 |30			|5		  |13		 |8			 |S			   |0				 |S			    	 |	0	    |		0		|  -2   |   CEP de origem invalido                 |  
        |		   |		|40010	   |13084971  | 130c497a  | 15	  |2		 |30			|5		  |13		 |8			 |S			   |0				 |S			    	 |	0	    |		0		|  -3   |   CEP de destino invalido                |  

	
Scenario Outline: Getting address - API Integration
	Given I have a valid and registered zip code "<cep>"
	When I press button to search
	And system connects to Correios API
	And system sends the file with the mandatory tag "<cep>"
	Then ViaCEP API returns "<cep>" "<logradouro>" "<complemento>" "<bairro>" "<localidade>" "<uf>" "<ibge>" "<gia>"

	Examples:
	|cep		|logradouro			|complemento				|bairro		|localidade		|uf	|ibge	|gia	|
	|01001000	|Praca da Se		|lado impar					|Se			|Sao Paulo		|SP	|3550308|1004	|
	|01311300	|Avenida Paulista	|de 1867 ao fim - lado impar|Bela Vista	|Sao Paulo		|SP	|3550308|1004	|
	
	
Scenario Outline: Invalid zip code
	Given I have an invalid zip code "<cep>"
	When I press button to search 
	And system connects to Correios API
	And system sends the file with the mandatory tag "<cep>"
	And system returns an empty address object
	Then should show an error with a message: "O CEP nao foi informado ou eh invalido. O formato correto eh composto por 8 digitos."
	
	Examples:
	|cep		|
	|			|
	|0000000X	|
	
	
Scenario Outline: Address not found
	Given I have a valid but not registered zip code "<cep>"
	When I press button to search
	And system connects to Correios API
	And system sends the file with the mandatory tag "<cep>"
	And system returns an empty address object
	Then should show an error with a message: "O CEP informado nao foi encontrado."
	
	Examples:
	|cep		|
	|88888888	|
	|99999999	|

	
Scenario Outline: CEP address endpoint is unavailable
	Given I have a valid and registered zip code "<cep>"
	When I press button to search
    And Correios API is unavailable
    And system sends the file with the mandatory tag "<cep>"
	And system returns an empty address object
    Then should show an error with a message: "Servico indisponivel. Por favor, tente mais tarde."
	
	Examples:
	|cep		|
	|01010000	|

