Feature: Freight Calculator
	As a User
  	I want to use know the price and how many days to receive my product
  	So that I do not need to calculate myself

Scenario: Calculating freight price - API Integration
	Given Items <Wheight> <Width> <Height> <Length>
	When  User press button to calculate
	And   System connects to Correios API
	And	  System sends the file with all mandatory tags <nCdEmpresa> <sDsSenha> <nCdServico> <sCepOrigem> 
	And   <sCepDestino> <nVlPeso> <nCdFormato> <nVlComprimento>
	And	  <nVlAltura> <nVlLargura> <nVlDiametro> <sCdMaoPropria> <nVlValorDeclarado> <sCdAvisoRecebimento>
	Then  System connects to Correios API
	And   Correios API returns <sCodigo> <sValor> <sValorMaoPropria> <sValorAvisoRecebimento> <sValorDeclarado>

	Examples - Inbound File: 
		|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|
		|		   |		|40010	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |
		|		   |		|40010	   |13495-000 |13417-780  |100	  |2		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	
		|		   |		|40010	   |13495-000 |13417-780  |100	  |3		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	
		|		   |		|40045	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |
		
	Examples - Outbound File: 
		| sCodigo 		| sValor	| sValorMaoPropria | sValorAvisoRecebimento	| sValorDeclarado
		|	40010   	|	13,20	|	0,00		   |	 0,00				| 	0,00
		|	40045		|	20,10	|	0,00		   |	 0,00				|	0,00
		|	40290		|	19,10	|	0,00		   |	 0,00				|	0,00
		|   40215		|   30,20	|	0,00		   |	 0,00				|	0,00
	
Scenario Outline: Calculating freight deadline - API Integration
	Given User types the <sCepOrigem>
	And   System provides <sCepDestino>
	And   System provides <nCdServico>
	When  User press button to calculate
	And   System connects to Correios API
	Then  Correios API returns <sCodigo> <sPrazoEntrega> <sEntregaDomiciliar> <sEntregaSabado>
	
	Examples - Inbound File:
		| sCepOrigem	| sCepDestino	| nCdServico		|
		|	13495000	|	13480000    |	40010			|
		|	13480000	|	13495000    |	40010			|
		|	13490013	|	05311900    |	40010			|
		|	05311900	|	13490013    |	40010			|
	
	Examples - Outbound File: 
		| sCodigo 		| sPrazoEntrega	| sEntregaDomiciliar | sEntregaSabado
		|	40010   	|	1			|	S				 |	 S 
		|	40045		|	2			|	S				 |	 S
		|	40290		|	3			|	N				 |	 N
		|   40215		|   4			|	S				 |	 S

Scenario Outline: Calculating freight price and deadline - API Integration
	Given Items <Wheight> <Width> <Height> <Length>
	When  User press button to calculate
	And   System connects to Correios API
	And   System sends the file with all mandatory tags <nCdEmpresa> <sDsSenha> 
	And	  <nCdServico> <sCepOrigem> <sCepDestino> <nVlPeso> <nCdFormato> <nVlComprimento> 
	And	  <nVlAltura> <nVlLargura> <nVlDiametro> <sCdMaoPropria> <nVlValorDeclarado> <sCdAvisoRecebimento>
	Then  Correios API returns <FreightCost> and <Deadline>

	Examples - Inbound File: 
	|nCdEmpresa|sDsSenha|nCdServico|sCepOrigem|sCepDestino|nVlPeso|nCdFormato|nVlComprimento|nVlAltura|nVlLargura|nVlDiametro|sCdMaoPropria|nVlValorDeclarado|sCdAvisoRecebimento|
	|		   |		|40010	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |
	|		   |		|40010	   |13495-000 |13417-780  |100	  |2		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	
	|		   |		|40010	   |13495-000 |13417-780  |100	  |3		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |	
	|		   |		|40045	   |13495-000 |13417-780  |100	  |1		 |15			|5		  |6		 |8			 |N			   |0				 |N					 |
	
	Examples - Outbound File:
	|sCodigo   |FreightCost	|Deadline	|
	|	40010  |	16,50	|	1		|
	|	40010  |	20,50	|	1		|
	|	40010  |	16,50	|	3		|
	|	40010  |	16,50	|	1		|
