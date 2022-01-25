package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.employment.SalarySupplement;
import ru.vgoudk.workhours.model.finance.Supplement;

import javax.persistence.*;

/**
 * Месячная отработка в сменах (для расчёта надбавок)
 */
@Entity
@Table(name = "wh_monthly_workshifts")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MonthlyWorkShifts extends AbstractMonthlyWork {
    /**
     * Отработано по надбавке
     */
    @ManyToOne
    @JoinColumn(name = "with_salary_supplement_fk")
    private SalarySupplement withSalarySupplement;

    /**
     * Отработано периодов, которые заявлены в {@link Supplement#getPeriodSize()}
     */
    @Column(name = "periods")
    private Integer periods;
}