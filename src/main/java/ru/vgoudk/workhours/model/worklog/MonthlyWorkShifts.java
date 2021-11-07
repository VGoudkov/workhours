package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.employment.EmployeeIncrease;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Месячная отработка в сменах (для расчёта надбавок)
 */
@Entity
@Table(name = "wh_monthly work shifts")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MonthlyWorkShifts extends AbstractMonthlyWork {
    /**
     * Отработано по надбавке
     */
    @ManyToOne
    @JoinColumn(name = "salary_increase_fk")
    private EmployeeIncrease salaryIncrease;

    /**
     * Отработано смен
     */
    private Integer shifts;
}