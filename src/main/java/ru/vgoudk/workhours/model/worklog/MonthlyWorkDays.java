package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.employment.Employment;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "employment_fk")
    private Employment employment;

    /**
     * Отработано дней
     */
    @NonNull
    @Column(name = "workdays", nullable = false)
    private Integer workdays;
}
