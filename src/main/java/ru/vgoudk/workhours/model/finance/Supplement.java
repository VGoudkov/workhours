package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Надбавка к зарплате
 */
@Entity
@Table(name = "wh_increase")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Supplement extends AbstractEntity {
    /**
     * Выплачивается из средств
     */
    @ManyToOne
    @JoinColumn(name = "from_funds_fk")
    private Funds fromFunds;

    /**
     * Выплачивается для сотрудника в должности
     */
    @ManyToOne
    @JoinColumn(name = "for_position_fk")
    private Position forPosition;


    /**
     * Период, за который рассчитывается надбавка
     */
    private PeriodSize periodSize;


    /**
     * Базовая сумма, которая умножается на количество отработанных периодов
     */
    private BigDecimal amount;
}