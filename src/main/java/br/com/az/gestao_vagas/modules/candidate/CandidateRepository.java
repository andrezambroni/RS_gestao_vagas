package br.com.az.gestao_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    
    // pq e quando é bom usar Optional
    Optional<CandidateEntity> findByUsernameOREmail(String username, String email);

}
