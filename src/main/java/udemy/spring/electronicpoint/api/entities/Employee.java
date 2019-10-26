package udemy.spring.electronicpoint.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.spring.electronicpoint.api.enums.ProfileEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = -5754246207015712518L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "valuePerHour")
    private BigDecimal valuePerHour;

    @Column(name = "workingDayHours")
    private Float workingDayHours;

    @Column(name = "lunchHours")
    private Float lunchHours;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    private ProfileEnum profile;

    @Column(name = "createDate", nullable = false)
    private Date createDate;

    @Column(name = "updateDate", nullable = false)
    private Date updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EntryPoint> entries;


    @Transient
    public Optional<BigDecimal> getValuePerHourOpt() {
        return Optional.ofNullable(valuePerHour);
    }

    @Transient
    public Optional<Float> getWorkingDayHoursOpt() {
        return Optional.ofNullable(workingDayHours);
    }

    @Transient
    public Optional<Float> getLunchHoursOpt() {
        return Optional.ofNullable(lunchHours);
    }


    @PreUpdate
    public void preUpdate() {
        updateDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date now = new Date();
        createDate = now;
        updateDate = now;
    }

}