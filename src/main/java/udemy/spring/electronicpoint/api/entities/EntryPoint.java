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
@Table(name = "entry_point")
public class EntryPoint implements Serializable {

    private static final long serialVersionUID = 6524560251526772839L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "place")
    private String place;

    @Column(name = "createDate", nullable = false)
    private Date createDate;

    @Column(name = "updateDate", nullable = false)
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeEnum type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @PreUpdate
    public void preUpdate() {
        updateDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        createDate = atual;
        updateDate = atual;
    }

}