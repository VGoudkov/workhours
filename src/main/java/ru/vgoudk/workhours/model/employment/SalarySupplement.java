package ru.vgoudk.workhours.model.employment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.finance.Supplement;
import ru.vgoudk.workhours.model.personnel.Employee;

import javax.persistence.*;

/**
 * Работа с получением надбавки
 */
@Entity
@Table(name = "wh_salary_supplement")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
//TODO: Уточнить у Аллы, может ли быть два раза одна и та же надбавка одному человеку.
//  если нет - то тут должен быть @EmbeddedId
public class SalarySupplement extends AbstractWorkPeriod {
    /**
     * Кому надбавка
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "for_employee_fk")
    private Employee forEmployee;

    /**
     * Какая надбавка, т.е. как её рассчитывать исходя из количества отработанных смен ({@link ru.vgoudk.workhours.model.worklog.MonthlyWorkShifts}
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "increase_fk")
    private Supplement supplement;
}