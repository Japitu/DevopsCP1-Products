# Catálogo de Produtos API 📦

API RESTful de alta performance desenvolvida para a gestão de catálogos de produtos. O projeto utiliza o framework **Quarkus** e implementa uma arquitetura robusta em camadas com persistência direta via **JDBC** no banco de dados **Oracle**.

## 🚀 Tecnologias e Dependências

* **Java 21** (LTS)
* **Quarkus 3.19.1** (REST, Jackson, Arc)
* **Oracle JDBC Driver (OJDBC11)**
* **Apache Camel Bean Validator** (Validação de TOs)
* **Maven** (Gestão de Build)

## 🏗️ Arquitetura e Design

O projeto foi construído seguindo padrões de design de software para garantir escalabilidade e separação de responsabilidades:

* **Resource (Controller):** Gerencia as rotas REST e as respostas HTTP (JAX-RS).
* **BO (Business Object):** Concentra as regras de negócio e validações.
* **DAO (Data Access Object):** Gerencia o ciclo de vida das conexões e executa SQL puro via `PreparedStatement`.
* **TO (Transfer Object):** Objetos de transporte (DTO) para comunicação entre camadas e serialização JSON.
* **Connection Factory:** Centraliza a gestão de conexões com o banco de dados Oracle via JDBC.

## 🔌 API Endpoints

Abaixo estão os endpoints principais expostos em `/produto`:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/produto` | Lista todos os produtos (ordenados por ID). |
| **GET** | `/produto/{id}` | Busca um produto específico por ID. |
| **POST** | `/produto` | Cadastra um novo produto (JSON). |
| **PUT** | `/produto/{id}` | Atualiza um produto existente. |
| **DELETE** | `/produto/{id}` | Remove um produto do catálogo. |

### Exemplo de JSON (ProdutoTO):
```json
{
  "nome": "Smartphone",
  "descricao": "128GB, Preto",
  "preco": 2500.00
}
```

## 🗄️ Modelo de Dados (Oracle)

A persistência é realizada na tabela `t_produto` com a seguinte estrutura mapeada no DAO:
* `id_produto`: Identificador único (Primary Key).
* `nm_produto`: Nome do produto.
* `dc_produto`: Descrição detalhada.
* `prc_produto`: Preço decimal.

## ⚙️ Configuração e Execução

### Variáveis de Ambiente
O projeto utiliza a `ConnectionFactory` preparada para integração com variáveis de ambiente. Certifique-se de configurar as credenciais do seu banco Oracle no sistema ou no arquivo `application.properties`.

### Compilação e Execução
Para rodar em modo de desenvolvimento (Hot Reload):
```bash
./mvnw quarkus:dev
```

Para gerar o pacote de deploy (.jar):

```bash
./mvnw package
```

## 📦 Infraestrutura e VM

O projeto foi validado e implantado em um ambiente de **Máquina Virtual (VM)**. O artefato gerado pelo Maven foi testado para garantir a conectividade de rede com o servidor de banco de dados e a correta exposição dos serviços RESTful para consumo externo, demonstrando a portabilidade e robustez da aplicação.

---
**Desenvolvido por Felipe Ishii - 2025**
