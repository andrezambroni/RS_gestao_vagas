package br.com.az.gestao_vagas.modules.candidate.company.entities.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.az.gestao_vagas.exceptions.UserFoundException;
import br.com.az.gestao_vagas.modules.candidate.company.entities.CompanyEntity;
import br.com.az.gestao_vagas.modules.candidate.company.entities.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
                .findByUsernameOREmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);

    }
}
