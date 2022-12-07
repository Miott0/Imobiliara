## Restrições e Regras de Negócio
#
O objetivo do sistema é gerir o fluxo de compras e vendas de imóveis, funcionando como intermediário entre cliente e corretora. No site será mostrado os imóveis com suas informações.
Para realizar as operações o cliente, corretor e administrador precisam estar previamente logados.

Toda vez que um imóvel for cadastrado, um corretor deverá verificar a autenticidade do imóvel, caso for autêntico, deverá ser aprovado e ele entrará no sistema que enviará uma mensagem de confirmação. Caso o imóvel não seja autêntico será reprovado e o sistema deverá enviar uma notificação informando a rejeição. O processo de autenticação passa pelas etapas de verificação dos dados do imóvel e do cliente, se o imóvel realmente existe e se já possui cadastro no site.

* O sistema deve possibilitar a consulta de imóvel para qualquer tipo de usuário, logado ou não.

* O sistema deve possibilitar o cadastro do corretor: nome, sobrenome,e-mail, senha. O cadastro do corretor deverá ser feito por um administrador. 

* O sistema deve possibilitar o cadastro do administrador, que deverá ser feito de forma interna no sistema. 

* O sistema deve possibilitar o cadastro do cliente: nome, sobrenome,e-mail, senha.

* O sistema deve possibilitar cadastro do imóvel: endereço (rua, número, cidade, estado), tipo do imóvel (terreno, apartamento, casa), área do imóvel, valor de venda,valor de aluguel, quantidade de quartos, quantidade de banheiros, descrição do imóvel, tipo do negócio (aluguel ou venda), negociado.

* valor de venda e aluguel deverão ser preenchidos de acordo com a modalidade do negócio escolhido. 

* O sistema deve possibilitar que o cliente agende uma visita ao imóvel.  

 

## Atributos em geral :
    Aceita valor nulo ou não - Campos que poderão ser nulos serão especificados na sua declaração
    Será permitido alteração futura?
    Deverá ser único?
    Padrão (regex)-> um formato específico com CPF, CEP, CNPJ.

## Usuario :
    -nome: max varchar(15)
    -sobrenome: max varchar(30)
    -email: max varchar(40)
    
## Cliente : 
    -senha: min char(8) - (na camada de persistência deverá ser armazenado com  como hash)

## Corretor :
    -senha: min char(8) - (na camada de persistência deverá ser armazenado com  como hash)

## Agendamento: 
    -dia: int
    -mes: int
    -ano: int
    -nome_cliente: String 

## Endereço: 
    -rua: max char(30) 
    -numero: int
    -cidade: max char(30) 
    -estado: max char(30) 

## Imovel: 
    -tipo_imovel: (os valores já serão pré-selecionados, podendo escolher entre eles: CASA, APARTAMENTO, TERRENO)

    -area: int 

    -valor_venda: float (valor poderá ser nulo no BD, mas o preenchimento será obrigatório no cadastro do imóvel pelo cliente. A depender da opção escolhida em 'aluguel_venda')

    -valor_aluguel: float (valor poderá ser nulo BD, mas o preenchimento será obrigatório no cadastro do imóvel pelo cliente. A depender da opção escolhida em 'aluguel_venda')

    -qtd_quartos: int

    -observacao: varchar(300)

    -qtd_banheiros: int

    -aluguel_venda: (os valores já serão pré-selecionados, podendo escolher entre eles: ALUGUEL, VENDA, AMBOS)

    -negociado: bollean (valor default FALSE, o valor do atributo não deverá ser adicionado durante o cadastro do imóvel, valor controlado pelo corretor)

    -valido: bollean (valor default FALSE, o valor do atributo não deverá ser adicionado durante o cadastro do imóvel, valor controlado pelo corretor)