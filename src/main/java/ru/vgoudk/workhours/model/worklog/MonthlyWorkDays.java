package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.employment.Employment;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Месячная отработка в днях (для расчёта зарплаты)
 */
@Entity
@Table(name = "wh_monthly work days")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MonthlyWorkDays extends AbstractMonthlyWork {
    /**
     * Отработано в должности
     */
    @ManyToOne
    @JoinColumn(name = "employment_id")
    private Employment employment;
    /**
     * Отработано дней
     */
    private Integer days;
}