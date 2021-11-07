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
 * Месячная отработка в сменах
 */
@Entity
@Table(name = "wh_monthly work shifts")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MonthlyWorkShifts extends AbstractMonthlyWork {
    /**
     * Отработано в должности
     */
    @ManyToOne
    @JoinColumn(name = "employment_id")
    private Employment employment;

    /**
     * Отработано смен
     */
    private Integer shifts;
}