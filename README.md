# TechChallenge

Este serviço é projetado para gerenciar clientes, produtos e pedidos, permitindo a criação, consulta e manipulação de
dados relacionados a esses domínios.

Pré-requisitos <br/>
Certifique-se de ter o seguinte instalado na sua máquina:

    Docker Desktop: https://www.docker.com/products/docker-desktop/

Siga os passos abaixo para clonar e executar o projeto:

## 1. Configuração K8s

1.1 Abrir docker desktop <br/>
1.2 Clicar em configurações <br/>
1.3 Clicar em Kubernets <br/>
1.4 Clicar em "enable kubernets" <br/>
1.5 Clicar em "apply & restart" <br/><br/>

Conforme imagem abaixo: <br/>

<img src="/setup-k8s.png">

## 2. Clonar o Repositório

Primeiro, clone o repositório para sua máquina local usando o comando abaixo:

    git clone https://github.com/FIAP-group-twenty/TechChallenge.git

## 3. Navegar até o Diretório do Projeto

Vá para o diretório do projeto recém-clonado:

    cd TechChallenge

## 4. Setup Kubernetes

Use os comandos abaixo para configurar o ambiente kubernetes:

```
kubectl apply -f mysql-secret.yaml
kubectl apply -f mysql-pv.yaml
kubectl apply -f mysql-pvc.yaml
kubectl apply -f mysql-svc.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f hpa.yaml
kubectl apply -f app-svc.yaml
kubectl apply -f app-deployment.yaml
```

## 5. Acessar a Aplicação

Após executar os comandos o swagger estará disponível em http://localhost:30005/api/v1/swagger-ui/index.html

## Parar a aplicação

Para parar a aplicação execute o comando abaixo em outro terminal:

```
kubectl delete -f mysql-secret.yaml
kubectl delete -f mysql-pv.yaml
kubectl delete -f mysql-pvc.yaml
kubectl delete -f mysql-svc.yaml
kubectl delete -f mysql-deployment.yaml
kubectl delete -f hpa.yaml
kubectl delete -f app-svc.yaml
kubectl delete -f app-deployment.yaml
```

## Arquitetura do projeto

As imagens abaixo ilustram como é a arquitetura do projeto.

<img src="/arquitetura-1.png">
<img src="/arquitetura-2.png">

## Apresentação do projeto
Vídeo para a apresentação do projeto
https://www.youtube.com/watch?v=QlvNxpPrik8.

