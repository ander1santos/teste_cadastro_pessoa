# Teste Cadastro de Pessoa - TOTVS
# ================================
# 
# Após o deploy da aplicação, para verificar os endpoints da aplicação, acessar o swagger-ui em http://[host]:[porta]/swagger-ui.html (ex: http://localhost:8080/swagger-ui.html)
#
# Apesar de que foi solicitado para não persistir em banco de dados, foi utilizado o H2 database engine para verificação de possíveis persistências e testes pontuais.
#
# Foi efetuado os endpoints do webservice apenas para cadastro de Pessoas, efetuando o CRUD, conforme indicado abaixo:
#
# Método HTTP: GET; URI: http://[host]:[porta]/api/pessoas; Descrição: Obter os dados de todas pessoas;  
#
# Método HTTP: GET; URI: http://[host]:[porta]/api/pessoa/{id}; Descrição: Obter os dados de uma determinada pessoa pelo código numérico "id";
#
# Método HTTP: POST; URI: http://[host]:[porta]/api/pessoa; Descrição: Criar uma nova pessoa;
#
# Método HTTP: PUT; URI: http://[host]:[porta]/api/pessoa/{id}; Descrição: Atualizar alguma pessoa específica;
#
# Método HTTP: DELETE; URI: http://[host]:[porta]/api/pessoa/{id}; Descrição: Excluir alguma pessoa específica;
#
# A aplicação proporciona realizar atividades para manipular os dados de uma pessoa, proporcionando diversos cadastros de Dependentes, Endereços e Telefones para o mesmo indivíduo.
#
# Desenvolvido por: Anderson - Contato: ander1santos@hotmail.com