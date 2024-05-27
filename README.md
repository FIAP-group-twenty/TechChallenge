# TechChallenge

Esta API é projetada para gerenciar clientes, produtos e seus pedidos, permitindo a criação, consulta e manipulação de dados relacionados a esses domínios.

Obs: O .env está fora do .gitignore para que possa ser testado pelos professores, mas a ideia é esconder a senhas.

Pré-requisitos
Certifique-se de ter o seguinte instalado na sua máquina:

    Docker Desktop: https://www.docker.com/products/docker-desktop/

Siga os passos abaixo para clonar e executar o projeto:

# 1. Clonar o Repositório
   Primeiro, clone o repositório para sua máquina local usando o comando abaixo:

    git clone https://github.com/FIAP-group-twenty/TechChallenge.git

# 2. Navegar até o Diretório do Projeto
   Vá para o diretório do projeto recém-clonado:

    cd TechChallenge

# 3. Subir os Contêineres com Docker Compose
   Use o comando abaixo para iniciar os contêineres Docker definidos no arquivo docker-compose.yml:

    docker-compose up

Este comando irá baixar as imagens necessárias (se ainda não estiverem no cache), criar e iniciar os contêineres definidos no docker-compose.yml.

# 4. Acessar a Aplicação
   Após executar o comando docker-compose up, o swagger estará disponível em http://localhost:8080/api/v1/swagger-ui/index.html

# Parar os Contêineres
Para parar os contêineres, pressione Ctrl + C no terminal onde o comando docker-compose up está sendo executado, ou execute o comando abaixo em outro terminal:

    docker-compose down