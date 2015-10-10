Feature: Freight Calculator
	As a User
  	I want to inform my zip code to know the price and how many days to receive my product
  	So that I do not need to calculate myself

Scenario Outline: Calculating freight price - API Integration
	Given Items <Wheight> <Width> <Height> <Length>
	When User press button to calculate
	And system connects to Correios API
	And system sends the file with all mandatory tags <nCdEmpresa> <sDsSenha> <nCdServico> <sCepOrigem> 
	And <sCepDestino> <nVlPeso> <nCdFormato> <nVlComprimento>
	And <nVlAltura> <nVlLargura> <nVlDiametro> <sCdMaoPropria> <nVlValorDeclarado> <sCdAvisoRecebimento>
	Then system connects to Correios API
	And correios API returns <sCodigo> <sValor> <sValorMaoPropria> <sValorAvisoRecebimento> <sValorDeclarado>
	
	Examples:
		|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|sCodigo 		| sValor	| sValorMaoPropria | sValorAvisoRecebimento	| sValorDeclarado|
		|		   |		|40010	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	0,00		   |	 0,00				| 	0,00		 |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |2		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	0,00		   |	 0,00				| 	0,00		 |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |3		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	0,00		   |	 0,00				| 	0,00		 |	
		|		   |		|40045	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010   	|	13,20	|	0,00		   |	 0,00				| 	0,00		 |
	
Scenario Outline: Calculating freight deadline - API Integration
	Given User types the <sCepOrigem>
	And System provides <sCepDestino>
	And System provides <nCdServico>
	When User press button to calculate
	And System connects to Correios API
	Then Correios API returns <sCodigo> <sPrazoEntrega> <sEntregaDomiciliar> <sEntregaSabado>
	
	Examples:
		| sCepOrigem	| sCepDestino	| nCdServico		|  sCodigo 		| sPrazoEntrega	| sEntregaDomiciliar | sEntregaSabado|
		|	13495000	|	13480000    |	40010			|	40010   	|	1			|	S				 |	 S			 |
		|	13480000	|	13495000    |	40010			|	40010   	|	1			|	S				 |	 S			 |
		|	13490013	|	05311900    |	40010			|	40010   	|	1			|	S				 |	 S			 |
		|	05311900	|	13490013    |	40010			|	40010   	|	1			|	S				 |	 S			 |

Scenario Outline: Calculating freight price and deadline - API Integration
	Given Items <Wheight> <Width> <Height> <Length>
	When User press button to calculate
	And system connects to Correios API
	And system sends the file with all mandatory tags <nCdEmpresa> <sDsSenha>
	And <nCdServico> <sCepOrigem> <sCepDestino> <nVlPeso> <nCdFormato> <nVlComprimento>
	And <nVlAltura> <nVlLargura> <nVlDiametro> <sCdMaoPropria> <nVlValorDeclarado> <sCdAvisoRecebimento>
	Then Correios API returns <FreightCost> and <Deadline>

	Examples: 
	|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento| sCodigo |FreightCost	|Deadline	|
	|		   |		|40010	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010  |	16,50	|	1		|
	|		   |		|40010	   |13495-000 |13417-780  |100	  |2		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010  |	16,50	|	1		|
	|		   |		|40010	   |13495-000 |13417-780  |100	  |3		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010  |	16,50	|	1		|	
	|		   |		|40045	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	40010  |	16,50	|	1		|
	
Scenario Outline: Getting address - API Integration
	Given I have a valid and registered zip code <cep>
	When I press button to search
	And system connects to Correios API
	And system sends the file with the mandatory tag <cep>
	Then Correios API returns <cep> <logradouro> <complemento> <bairro> <localidade> <uf> <ibge> <gia>

	Examples: 
	|cep		|logradouro			|complemento				|bairro		|localidade		|uf	|ibge	|gia	|
	|01001000	|Pra�a da S�		|lado �mpar					|S�			|S�o Paulo		|SP	|3550308|1004	|
	|01311300	|Avenida Paulista	|de 1867 ao fim - lado �mpar|Bela Vista	|S�o Paulo		|SP	|3550308|1004	|
	|22041080	|Rua Anita Garibaldi|							|Copacabana	|Rio de Janeiro	|RJ	|3304557|		|
	
Scenario: Empty zip code 
	Given I do not have a zip code <cep> 
	When I press button to search 
	Then should show an error with a message: 
	"""
	O campo CEP n�o foi informado.
	"""
	
Scenario: Invalid zip code 
	Given I have an invalid zip code <cep> 
	When I press button to search 
	Then should show an error with a message: 
	"""
	O CEP informado � inv�lido. O formato correto � compsoto por {8} d�gitos.
	"""
	
Scenario: Address not found 
	Given I have a valid but not registered zip code <cep> 
	When I press button to search 
	And system connects to Correios API
	And system sends the file with the mandatory tag <cep>
	And system returns an empty address object
	Then should show an error with a message: 
	"""
	O CEP informado n�o foi encontrado.
	"""