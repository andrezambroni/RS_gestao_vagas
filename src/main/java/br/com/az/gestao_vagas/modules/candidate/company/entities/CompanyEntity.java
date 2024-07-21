package br.com.az.gestao_vagas.modules.candidate.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
// name = "company": Define o nome da tabela no banco de dados como company.
// Sem essa anotação, o nome da tabela seria o mesmo nome da classe (CompanyEntity).
@Entity(name = "company")
public class CompanyEntity {

    //strategy = GenerationType.UUID: Especifica como o valor da chave primária será gerado.
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    
    @NotBlank // Garante que o campo username não seja nulo e não contenha apenas espaços em branco.
    @Pattern(regexp = "\\S+", message = "O campo [username] nao deve contar espaco")
    //Garante que o username não contenha espaços. O regex \\S+ assegura que o campo deve conter pelo menos um caractere não espaço.
    private String username;

    @Email(message = "O campo [email] deve conter um email valido")
    private String email;

    @Length(min = 10, max = 100, message = "a senha deve conter entre 10 a 100 caracteres")
    private String password;
    
    private String website;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
