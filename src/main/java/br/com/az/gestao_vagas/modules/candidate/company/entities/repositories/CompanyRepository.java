package br.com.az.gestao_vagas.modules.candidate.company.entities.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.az.gestao_vagas.modules.candidate.company.entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUsernameOREmail(String username, String email);

}
