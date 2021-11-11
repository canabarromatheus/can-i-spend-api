package canabarro.matheus.canispendapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BALANCE")
public class BalanceEntity {
    @Id
    @SequenceGenerator(name = "BALANCE_SEQ", sequenceName = "BALANCE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "BALANCE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_BALANCE")
    private Long id;

    @Column(name = "INCOME", nullable = false)
    private Double income;

    @Column(name = "PAY_DAY", nullable = false)
    private LocalDate payDay;

    @OneToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private UserEntity user;

    @OneToOne(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private PreferencesEntity preferences;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillEntity> bills;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditEntity> credits;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DebitEntity> debits;
}