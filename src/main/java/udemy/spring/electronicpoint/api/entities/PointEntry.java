package udemy.spring.electronicpoint.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.spring.electronicpoint.api.enums.TypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "entry")
public class PointEntry implements Serializable {

    private static final long serialVersionUID = 6524560251526772839L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TypeEnum tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

}