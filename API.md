Documentação da API do Aplicativo All4Ocean
Autenticação
1. Endpoint: /login
	Método: POST
	Descrição: Este endpoint é utilizado para autenticar um usuário no sistema.

	Parâmetros:
		email (string): O email do usuário.
		password (string): A senha do usuário.

	Exemplo de Requisição:
		POST /login
	
	       {
  		"email": "usuario@example.com",
	  	"password": "senha123"
       		}

	Resposta:
		Status: 200 OK
		Corpo da Resposta:
			{
 	 	       	   "user_id": "abc123",
	  		   "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiYWJjMTIzIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
			}


2.Endpoint: /signup
	Método: POST
	Descrição: Este endpoint é utilizado para registrar um novo usuário no sistema.
	Parâmetros:
		email (string): O email do usuário.
		password (string): A senha do usuário.

	Exemplo de Requisição:
		POST /signup
		{
	  	   "email": "novo_usuario@example.com",
  		   "password": "nova_senha123"
		}
	
	Resposta:
		Status: 201 Created
		Corpo da Resposta:
			{
  			     "message": "Usuário criado com sucesso."
			}

			
Perfil do Usuário
3. Endpoint: /user
	Método: GET
	Descrição: Este endpoint é utilizado para obter informações do perfil do usuário logado.
	Parâmetros:
		token (string): Token de autenticação do usuário.

	Exemplo de Requisição:
		GET /user
		Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiYWJjMTIzIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

	Resposta:
		Status: 200 OK
		Corpo da Resposta:
			{
			  "user_id": "abc123",
			  "email": "usuario@example.com",
			  "nome": "Nome do Usuário",
			  "telefone": "(11) 1234-5678"
			}

4. Endpoint: /user/update
	Método: PUT
	Descrição: Este endpoint é utilizado para atualizar as informações do perfil do usuário logado.
	Parâmetros:
		token (string): Token de autenticação do usuário.
		nome (string): Novo nome do usuário.
		telefone (string): Novo telefone do usuário.
		
		Exemplo de Requisição:
			
			PUT /user/update
			Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiYWJjMTIzIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
			{
			  "nome": "Novo Nome",
			  "telefone": "(11) 9876-5432"
			}

	Resposta:
		Status: 200 OK
		Corpo da Resposta:
			{
			  "message": "Perfil do usuário atualizado com sucesso."
			}
