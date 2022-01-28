package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Надбавка к зарплате
 */
@Entity
@Table(name = "wh_supplement")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Supplement extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * Выплачивается из средств
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "from_funds_fk")
    private Funds fromFunds;

    /**
     * Выплачивается для сотрудника в должности
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "for_position_fk")
    private Position forPosition;


    /**
     * Период, за который рассчитывается надбавка
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "period_size", nullable = false)
    @NotNull
    private PeriodSize periodSize;


    /**
     * Базовая сумма, которая умножается на количество отработанных периодов
     */
    @Column(name = "amount_per_period", nullable = false)
    @NotNull
    private BigDecimal amountPerPeriod;
}