Feature: Freight Calculator
	As a User
  	I want to inform my zip code to know the price and how many days to receive my product
  	So that I do not need to calculate myself

Scenario Outline: Calculating freight and deadline - API Integration
	Given All items from sales order are settled
	And User types "<sCepDestino>"
	When User press button to calculate freight
	And system connects to Correios API
	And system sends the file with all mandatory tags "<nCdEmpresa>" "<sDsSenha>" "<nCdServico>" "<sCepOrigem>" "<sCepDestino>" <nVlPeso> <nCdFormato> <nVlComprimento> <nVlAltura> <nVlLargura> <nVlDiametro> "<sCdMaoPropria>" <nVlValorDeclarado> "<sCdAvisoRecebimento>"
	Then correios API returns "<sCodigo>" <sValor> <sPrazoEntrega> <sValorMaoPropria> <sValorAvisoRecebimento> <sValorDeclarado> "<sEntregaDomiciliar>" "<sEntregaSabado>" "<sErro>" "<sMsgErro>"
	
	Examples:
		|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|sCodigo 		| sValor	| sPrazoEntrega | sValorMaoPropria | sValorAvisoRecebimento	| sValorDeclarado| sEntregaDomiciliar | sEntregaSabado | sErro | sMsgErro |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	1			|	 0,00		   | 	0,00		 		| 0,00			 |	S				  |	S			   |	   |	   	  |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |2		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	2			|	 0,00		   | 	0,00		 		| 0,00			 |	S				  |	S			   |	   |	   	  |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |3		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	1			|	 0,00		   | 	0,00		 		| 0,00			 |	S				  |	S			   |	   |	   	  |
		|		   |		|40045	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	1			|	 0,00	       | 	0,00		 		| 0,00		 	 |	S				  |	S			   |	   |	   	  |

Scenario Outline: Calculating freight and deadline - API Integration returns Error
	Given All items from sales order are settled
	And User types "<sCepDestino>"
	And at least one field is not valid
	When User press button to calculate freight
	And system connects to Correios API
	And system sends the file with all mandatory tags "<nCdEmpresa>" "<sDsSenha>" "<nCdServico>" "<sCepOrigem>" "<sCepDestino>" <nVlPeso> <nCdFormato> <nVlComprimento> <nVlAltura> <nVlLargura> <nVlDiametro> "<sCdMaoPropria>" <nVlValorDeclarado> "<sCdAvisoRecebimento>"
	Then correios API returns "<sCodigo>" <sValor> <sPrazoEntrega> <sValorMaoPropria> <sValorAvisoRecebimento> <sValorDeclarado> "<sEntregaDomiciliar>" "<sEntregaSabado>" "<sErro>" "<sMsgErro>"
	
	Examples:
		|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|sCodigo 		| sValor	| sPrazoEntrega | sValorMaoPropria | sValorAvisoRecebimento	| sValorDeclarado| sEntregaDomiciliar | sEntregaSabado | sErro | sMsgErro 													 |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |1		 |150			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	1			|	 0,00		   | 	0,00		 		| 0,00			 |	S				  |	S			   | -15   | O comprimento não pode ser maior que 105 cm				 |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |2		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	2			|	 0,00		   | 	0,00		 		| 0,00			 |	S				  |	S			   | -33   | Sistema temporariamente fora do ar. Favor tentar mais tarde |
		|		   |		|40010	   |13495-xx5 |13417-780  |100	  |3		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	1			|	 0,00		   | 	0,00		 		| 0,00			 |	S				  |	S			   | -2	   | CEP de origem inválido								   	     |
		|		   |		|40045	   |13495-000 |13417-780  |100	  |1		 |15			|-1	      |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	1			|	 0,00	       | 	0,00		 		| 0,00		 	 |	S				  |	S			   | -14   | Altura inválida	   								   	     |
	
	
Scenario Outline: Getting address - API Integration
	Given I have a valid and registered zip code "<cep>"
	When I press button to search
	And system connects to Correios API
	And system sends the file with the mandatory tag "<cep>"
	Then ViaCEP API returns "<cep>" "<logradouro>" "<complemento>" "<bairro>" "<localidade>" "<uf>" "<ibge>" <gia>

	Examples:
	|cep		|logradouro			|complemento				|bairro		|localidade		|uf	|ibge	|gia	|
	|01001000	|Praca da Se		|lado impar					|Se			|Sao Paulo		|SP	|3550308|1004	|
	
Scenario: Empty zip code 
	Given I do not have a zip code "<cep>"  
	When I press button to search 
	Then should show an error with a message: "O campo CEP nao foi informado."
	
Scenario Outline: Invalid zip code
	Given I have an invalid zip code "<cep>"
	When I press button to search 
	Then should show an error with a message "O CEP informado invalido. O formato correto eh compsoto por 8 digitos"
	
	Examples:
	|cep		|
	|010010XX	|
	|teste		|
	
Scenario Outline: Address not found
	Given I have a valid but not registered zip code "<cep>" 
	When I press button to search
	And system connects to Correios API
	And system sends the file with the mandatory tag "<cep>"
	And system returns an empty address object
	Then should show an error with a message: "O CEP informado nao foi encontrado."
	
	Examples:
	|cep		|
	|00000000	|
	|99999999	|