package ru.vgoudk.workhours.model.employment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.finance.Increase;
import ru.vgoudk.workhours.model.personnel.Employee;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Надбавка конкретному человеку
 */
@Entity
@Table(name = "wh_employee_increase")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EmployeeIncrease extends AbstractEmploymentPeriod {
    /**
     * Кому надбавка
     */
    @ManyToOne
    @JoinColumn(name = "for_employee_fk")
    private Employee forEmployee;

    /**
     * Какая надбавка, т.е. как её рассчитывать исходя из количества отработанных смен ({@link ru.vgoudk.workhours.model.worklog.MonthlyWorkShifts}
     */
    @ManyToOne
    @JoinColumn(name = "increase_fk")
    private Increase increase;
}