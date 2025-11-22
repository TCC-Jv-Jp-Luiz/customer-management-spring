# 📘 API de Gerenciamento de Pessoas — Spring Boot

Este repositório contém a implementação da API de Gerenciamento de Pessoas desenvolvida em **Spring Boot 3.4.4**, utilizada no Trabalho de Conclusão de Curso *“Análise Comparativa de Desempenho entre Frameworks Java para APIs: Spring Boot vs. Quarkus”*.

A API permite o cadastro, consulta, atualização e remoção de pessoas e seus endereços, incluindo informações de auditoria.

---

## 📄 Contexto do Projeto

Esta aplicação foi desenvolvida como parte do experimento comparativo entre frameworks Java modernos.  
Ambas as APIs (Spring Boot e Quarkus) foram implementadas com:

- **Java 21**
- **Arquitetura em camadas** (`controller`, `service`, `repository`)
- **Funcionalidades CRUD**
- **Banco de dados PostgreSQL 17.4**
- **Mesmos modelos, endpoints e regras de negócio**

### 🔗 Repositórios relacionados

- **API em Quarkus:** https://github.com/TCC-Jv-Jp-Luiz/costumer-management-quarkus
- **Documentação completa dos endpoints:** https://github.com/TCC-Jv-Jp-Luiz/documentation

---

## 🚀 Tecnologias Utilizadas

- **Spring Boot 3.4.4**
- **Java 21**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate ORM**
- **PostgreSQL 17**

---

## 🛠 Como Executar o Projeto

### ▶️ Pré-requisitos
- Docker

### ▶️ Rodar com Docker

```bash
docker-compose up --build
```
