package udemy.spring.electronicpoint.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.spring.electronicpoint.api.enums.PerfilEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = -5754246207015712518L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "valor_hora")
    private BigDecimal valorHora;

    @Column(name = "qtd_horas_trabalho_dia")
    private Float qtdHorasTrabalhoDia;

    @Column(name = "qtd_horas_almoco")
    private Float qtdHorasAlmoco;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false)
    private PerfilEnum perfil;

    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa empresa;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lancamento> lancamentos;


    @Transient
    public Optional<BigDecimal> getValorHoraOpt() {
        return Optional.ofNullable(valorHora);
    }

    @Transient
    public Optional<Float> getQtdHorasTrabalhoDiaOpt() {
        return Optional.ofNullable(qtdHorasTrabalhoDia);
    }

    @Transient
    public Optional<Float> getQtdHorasAlmocoOpt() {
        return Optional.ofNullable(qtdHorasAlmoco);
    }


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