# VetPulse Backend

API para sistema de agendamento e telemedicina veterinária.

## Tecnologias

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven
- Lombok
- Swagger/OpenAPI

## Arquitetura

O projeto segue uma arquitetura inspirada em Hexagonal Architecture / Ports and Adapters.

### Principais pacotes

- `domain`: modelos e regras de negócio.
- `ports`: contratos de entrada e saída.
- `application`: implementação dos casos de uso.
- `adapters`: controllers, DTOs, entities, repositories e adapters.
- `shared`: recursos compartilhados, como tratamento global de exceções.
- `config`: configurações da aplicação.

## Endpoints iniciais

### Tutores

- `POST /tutores`
- `GET /tutores`
- `GET /tutores/{idTutor}`
- `PUT /tutores/{idTutor}`
- `DELETE /tutores/{idTutor}`

### Pets

- `POST /pets`
- `GET /pets`
- `GET /pets/{idPet}`
- `PUT /pets/{idPet}`
- `DELETE /pets/{idPet}`

### Veterinários

- `POST /veterinarios`
- `GET /veterinarios`
- `GET /veterinarios/{idVeterinario}`
- `PUT /veterinarios/{idVeterinario}`
- `DELETE /veterinarios/{idVeterinario}`

### Agendamentos

- `POST /agendamentos`
- `GET /agendamentos`
- `GET /agendamentos/{idAgendamento}`
- `PATCH /agendamentos/{idAgendamento}/cancelar`
- `DELETE /agendamentos/{idAgendamento}`

## Como compilar

```bash
./mvnw clean compile
