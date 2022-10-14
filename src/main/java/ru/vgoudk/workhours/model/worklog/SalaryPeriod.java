package ru.vgoudk.workhours.model.worklog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Month;


@Entity
@Table(name = "wh_salary_period")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryPeriod extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    /**
     * Период, за который рассчитывается зарплата
     */
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "month", nullable = false)
    private Month month;

    /**
     * Отработано в году
     */
    @NonNull
    @Min(2020)
    @Max(2050)
    @Column(name = "year", nullable = false)
    private Integer year;


    /**
     * Период является закрытым для добавления отработанных дней
     */
    @Column(name = "is_locked", nullable = false)
    @Builder.Default
    private Boolean isLocked = false;
}
