package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "funds_fk")
    private Funds funds;

    /**
     * Выплачивается для сотрудника в должности
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "position_fk")
    private Position position;


    /**
     * Период, за который рассчитывается надбавка
     */
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "supplement_period_size", nullable = false)
    private SupplementPeriodSize supplementPeriodSize;


    /**
     * Базовая сумма, которая умножается на количество отработанных периодов
     */
    @NonNull
    @Column(name = "amount_per_period", nullable = false)
    private BigDecimal amountPerPeriod;
}
