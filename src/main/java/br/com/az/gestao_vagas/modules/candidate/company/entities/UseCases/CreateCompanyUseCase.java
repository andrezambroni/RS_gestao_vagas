package br.com.az.gestao_vagas.modules.candidate.company.entities.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.az.gestao_vagas.exceptions.UserFoundException;
import br.com.az.gestao_vagas.modules.candidate.company.entities.CompanyEntity;
import br.com.az.gestao_vagas.modules.candidate.company.entities.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    //Um repositório JPA que fornece métodos para acessar e manipular dados da tabela company no banco de dados.
    private CompanyRepository companyRepository;

    // Método principal que contém a lógica para criar uma nova empresa. Recebe um objeto CompanyEntity e retorna o mesmo objeto após a criação.
    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
                // Método do repositório que procura uma empresa no banco de dados com o mesmo nome de usuário ou e-mail fornecido.
                .findByUsernameOREmail(companyEntity.getUsername(), companyEntity.getEmail())
                //ifPresent: Método opcional que executa a lógica se um resultado for encontrado (ou seja, se uma empresa com o mesmo nome de usuário ou e-mail já existir)
                .ifPresent((user) -> {
                    //throw new UserFoundException(): Lança uma exceção personalizada se já existir uma empresa com os mesmos dados, prevenindo a duplicação.
                    throw new UserFoundException();
                });

                //Método do repositório que salva a nova empresa no banco de dados.
        return this.companyRepository.save(companyEntity);

    }
}
