package br.com.az.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "candidate")

//Marca a classe como uma entidade JPA. O JPA (Java Persistence API) irá mapear essa classe para uma tabela no banco de dados.
//name="candidate": Define o nome da tabela no banco de dados como candidate. Se você não especificar o nome, 
//a tabela geralmente terá o mesmo nome da classe.

public class CandidateEntity {
    
    @Id
    //Define como o valor da chave primária será gerado
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;
    private String description;
    private String curriculum;

    //define o valor deste campo para o timestamp (data e hora) atual quando a entidade é criada.
    @CreationTimestamp
    private LocalDateTime createdAt;
   
}
