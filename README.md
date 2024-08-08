##### Cenário: Eu como usuário administrativo preciso consultar os pagamentos por intervalo de datas de no máximo 30 dias.

##### Requisito: Criar um algoritimo de validação de um intervalo entre duas datas onde:

	1. Se a data inicial for informada, a data final se torna obrigatória
	2. Se a data final for informada, a data inicial se torna obrigatória
	3. A data inicial não pode ser superior a data final
	4. O intervalo das datas NÃO pode ser superior a 30 dias
	5. Todas as inconsistencias deverão lançar uma IllegalArgumentException

##### Testes unitários com JUnit 5 com tratamento de exceções