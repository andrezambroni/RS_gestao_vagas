package br.com.az.gestao_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

    // pq e quando é bom usar Optional
    Optional<CandidateEntity> findByUsernameOREmail(String username, String email);

}

//Optional<CandidateEntity>: O método retorna um Optional de CandidateEntity.
//Optional é uma classe que pode conter um valor ou estar vazia (null). Ele ajuda a evitar problemas com null.

//findByUsernameOREmail: Nome do método.
// De acordo com a convenção do Spring Data JPA, ele vai gerar uma consulta que procura por um
//CandidateEntity com username ou email correspondentes.

//Parâmetros (String username, String email): Esses são os valores que serão usados na consulta.
