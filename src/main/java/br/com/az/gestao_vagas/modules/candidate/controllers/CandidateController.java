package br.com.az.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.az.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.az.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;

// Indica que esta classe é um controlador REST
@RestController
// Define a URL base para todas as rotas deste controlador
@RequestMapping("/candidate")
public class CandidateController {

    // Injeta uma instância de CreateCandidateUseCase no controlador
    // CreateCandidateUseCase é o tipo da variável
    // createCandidateUseCase é o nome da variável
    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    //Este método recebe uma solicitação (pedido) para criar um novo candidato e tenta fazer isso. 
    // Dependendo se tudo deu certo ou se houve um erro, ele retorna uma resposta dizendo se conseguiu ou não.
    // Este é um sinal para o Spring dizendo que este método deve ser chamado quando alguém enviar um pedido do tipo POST para a URL /candidate/.
    @PostMapping("/")

    //ResponseEntity<Object>: Este método vai devolver uma resposta HTTP. A resposta pode conter qualquer tipo de objeto (Object).
    // create: Este é o nome do método
    // @Valid @RequestBody CandidateEntity candidateEntity: Este método espera receber um objeto do tipo CandidateEntity no corpo da solicitação.
    // A anotação @Valid diz ao Spring para verificar se os dados estão corretos antes de tentar criar o candidato.
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            //var result: Estamos guardando o resultado de algo em uma variável chamada result.
            //Chamamos um método chamado execute que tenta criar o candidato usando as informações recebidas.
            //Se der certo, result vai guardar o resultado da criação.
            var result = this.createCandidateUseCase.execute(candidateEntity);
            // Retorna uma resposta HTTP 200 (OK) com o resultado no corpo da resposta
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            // Em caso de erro, retorna uma resposta HTTP 400 (Bad Request) com a mensagem de erro
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
