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
@Table(name = "wh_monthly_workdays")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MonthlyWorkDays extends AbstractMonthlyWork {
    private static final long serialVersionUID = 1L;
    /**
     * Отработано в должности
     */
    @ManyToOne
    @JoinColumn(name = "in_employment_fk")
    private Employment inEmployment;
    /**
     * Отработано дней
     */
    private Integer days;
}