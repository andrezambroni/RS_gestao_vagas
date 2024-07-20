package br.com.az.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.az.gestao_vagas.exceptions.UserFoundException;
import br.com.az.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.az.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    //pq eu tenho que passar CandidateEntity candidateEntity, o que é cada um
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOREmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);

    }

}
