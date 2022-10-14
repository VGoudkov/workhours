package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.employment.SalarySupplement;
import ru.vgoudk.workhours.model.finance.Supplement;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Месячная отработка в сменах (для расчёта надбавок)
 */
@Entity
@Table(name = "wh_monthly_supplement")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MonthlySupplement extends AbstractMonthlyWork {
    private static final long serialVersionUID = 1L;

    /**
     * Отработано по надбавке
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "salary_supplement_fk")
    private SalarySupplement salarySupplement;

    /**
     * Отработано периодов, которые заявлены в {@link Supplement#getSupplementPeriodSize()}
     */
    @NonNull
    @Column(name = "periods", nullable = false)
    private Integer periods;
}
