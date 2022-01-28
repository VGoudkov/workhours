package ru.vgoudk.workhours.model.worklog;

import lombok.*;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.*;
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
    @Column(name = "month")
    private Month month;

    /**
     * Отработано в году
     */
    @NonNull
    @Column(name = "year")
    private Integer year;


    /**
     * Период является закрытым для добавления отработанных дней
     */
    @Column(name = "is_locked")
    private Boolean isLocked = false;
}