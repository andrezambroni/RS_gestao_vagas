package br.com.az.gestao_vagas.modules.candidate.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "job")
@Data

public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;
    private String level;

    //insertable = false, updatable = false: Indica que a coluna company_id não será inserida nem atualizada diretamente através da entidade JobEntity.
    //Em vez disso, o JPA usará a referência de companyEntity para gerenciar o relacionamento.

    //@ManyToOne() : Define um relacionamento muitos-para-um entre JobEntity e CompanyEntity.Isso significa que muitos trabalhos podem estar associados a uma única empresa
    
    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name = "company_id")
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
