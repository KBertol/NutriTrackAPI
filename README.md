# NutriTrack

Aplicativo de **Rastreamento Nutricional e Planejamento Dietético** (foco em
Bulking/Macros), desenvolvido em **Java puro + JDBC** sobre um banco de
dados relacional **PostgreSQL**, como projeto da disciplina de Banco de
Dados II.

## Domínio e Modelagem

O sistema permite que usuários registrem alimentos, montem refeições ao
longo do dia e acompanhem a evolução do peso corporal, comparando o que
consomem de calorias/proteína com as metas definidas para seu objetivo
(bulking, cutting ou manutenção).

### Modelo Relacional (6 tabelas relacionadas)

```
Usuario (id, nome, peso_atual, altura, meta_calorica, meta_proteina, objetivo)
Categoria (id, nome, descricao)
Alimento (id, nome, calorias_100g, proteina_100g, carboidrato_100g, gordura_100g, categoria_id -> Categoria)
Refeicao (id, usuario_id -> Usuario, nome, data, hora)
ItemRefeicao (id, refeicao_id -> Refeicao, alimento_id -> Alimento, quantidade_gramas)
RegistroPeso (id, usuario_id -> Usuario, data, peso_kg)
```

Relacionamentos:
- `Categoria 1:N Alimento`
- `Usuario 1:N Refeicao`
- `Usuario 1:N RegistroPeso`
- `Refeicao N:M Alimento`, materializado pela tabela associativa `ItemRefeicao`
  (com o atributo `quantidade_gramas`)

O script completo está em [`sql/schema.sql`](sql/schema.sql) e dados de
exemplo para teste em [`sql/dados_exemplo.sql`](sql/dados_exemplo.sql).

## Funcionalidades da aplicação

O menu (`Principal.java`) oferece:

1. **Inserir dados** – submenu para inserir uma nova tupla em qualquer uma
   das 6 tabelas.
2. **Remover dados** – submenu para remover (por id) uma tupla em qualquer
   uma das 6 tabelas.
3. **Listar todas as tuplas de todas as tabelas** – percorre e imprime o
   conteúdo de todas as 6 tabelas.
4. **Consulta com JUNÇÃO (JOIN) entre duas tabelas** – duas opções:
   - `Alimento JOIN Categoria`
   - `ItemRefeicao JOIN Alimento`
5. **Consulta com SUBCONSULTA + função(ões) de agregação** – para cada
   usuário, calcula (com `SUM`) o total de proteína consumida no dia mais
   recente em que ele registrou alguma refeição (esse "dia mais recente" é
   obtido por uma subconsulta correlacionada com `MAX`), e compara com a
   meta de proteína do usuário.

## Estrutura do projeto

```
NutriTrackAPI/
├── src/                       -> código-fonte Java (Beans, Models, Controllers, Principal)
├── lib/                       -> driver JDBC do PostgreSQL (postgresql-42.2.2.jre7.jar)
├── sql/
│   ├── schema.sql             -> criação das tabelas
│   └── dados_exemplo.sql      -> dados de exemplo para teste/demonstração
├── nbproject/                 -> configuração do projeto NetBeans
├── build.xml
└── manifest.mf
```

## Como executar

### Pré-requisitos
- JDK 8+
- PostgreSQL instalado e em execução
- NetBeans (opcional — o projeto também compila por linha de comando)

### 1. Criar o banco de dados

No `psql` ou em qualquer cliente PostgreSQL:

```sql
CREATE DATABASE bulking_db;
```

Depois, conectado ao banco `bulking_db`, execute os scripts:

```bash
psql -U postgres -d bulking_db -f sql/schema.sql
psql -U postgres -d bulking_db -f sql/dados_exemplo.sql
```

### 2. Configurar a conexão

Edite `src/Conexao.java` e ajuste usuário/senha/porta conforme sua
instalação do PostgreSQL:

```java
String user = "postgres";
String senha = "postgres";
String url = "jdbc:postgresql://localhost:5432/bulking_db";
```

### 3a. Abrir e rodar no NetBeans

1. Abra o NetBeans e use **File > Open Project**, selecionando a pasta
   `NutriTrackAPI`.
2. O NetBeans vai gerar automaticamente o `nbproject/build-impl.xml`.
3. Confirme que o driver `lib/postgresql-42.2.2.jre7.jar` está no
   classpath do projeto (Properties > Libraries). Ele já está referenciado
   em `nbproject/project.properties`.
4. Clique em **Run** (o `main.class` já está configurado como `Principal`).

### 3b. Ou rodar por linha de comando (sem NetBeans)

```bash
cd NutriTrackAPI
mkdir -p build
javac -cp lib/postgresql-42.2.2.jre7.jar -d build src/*.java
java -cp build:lib/postgresql-42.2.2.jre7.jar Principal
```
(No Windows, troque `:` por `;` no classpath.)

## Tecnologias

- Java 8 (JDBC puro — `java.sql.*`)
- PostgreSQL
- Sem uso de ORM/frameworks de abstração de banco de dados (conforme exigido)

## Equipe

- Integrantes: Karla Bertol & Vitor Cardoso Burgarelli
